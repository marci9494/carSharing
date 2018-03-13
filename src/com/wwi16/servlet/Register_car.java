package com.wwi16.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.wwi16.model.Ausstattung;
import com.wwi16.model.Fahrzeug;
import com.wwi16.model.FahrzeugHersteller;
import com.wwi16.model.FahrzeugKategorie;
import com.wwi16.model.User;
import com.wwi16.service.AusstattungService;
import com.wwi16.service.FahrzeugHerstellerService;
import com.wwi16.service.FahrzeugKategorieService;
import com.wwi16.service.FahrzeugService;
import com.wwi16.service.UserService;
import com.wwi16.util.SessionUtil;
import com.wwi16.util.XssUtil;

@MultipartConfig
public class Register_car extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register_car.jsp");

		// �bergabe aller Fahrzeughersteller
		FahrzeugHerstellerService FahrzeugHerstellerService = new FahrzeugHerstellerService();
		List<FahrzeugHersteller> hersteller = FahrzeugHerstellerService.getAllHersteller();
		request.setAttribute("hersteller", hersteller);
		AusstattungService ausstattungsService = new AusstattungService();
		List<Ausstattung> ausstattungen = ausstattungsService.getAllAusstattung();
		request.setAttribute("ausstattungen", ausstattungen);

		// �bergabe des aktuellen Nutzers
		User user = SessionUtil.setSessionEmail(request);
		if (user == null) {

			response.sendRedirect("/carSharing/login");
			return;

		}

		dispatcher.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Die einzelnen Kennzeichenbestandteile werden mit einem
		// Minuszeichen zusammengefuehrt:
		String kennzeichen_1 = XssUtil.sanitize(request.getParameter("kennzeichen_1"));
		String kennzeichen_2 = XssUtil.sanitize(request.getParameter("kennzeichen_2"));
		String kennzeichen_3 = XssUtil.sanitize(request.getParameter("kennzeichen_3"));
		String kennzeichen = kennzeichen_1 + "-" + kennzeichen_2 + "-" + kennzeichen_3;

		String marke = XssUtil.sanitize(request.getParameter("marke"));
		String modell = XssUtil.sanitize(request.getParameter("modell"));
		String baujahr = XssUtil.sanitize(request.getParameter("baujahr"));
		String laufleistung = XssUtil.sanitize(request.getParameter("laufleistung"));
		String leistung = XssUtil.sanitize(request.getParameter("leistung"));
		String kraftstoff = XssUtil.sanitize(request.getParameter("kraftstoff"));
		String farbe = XssUtil.sanitize(request.getParameter("farbe"));
		String sitzplaetze = XssUtil.sanitize(request.getParameter("sitzplaetze"));
		String tagespreis = XssUtil.sanitize(request.getParameter("tagesPreisInput"));
		String eigentuemerID = XssUtil.sanitize(request.getParameter("userId"));
		String[] ausstattung = request.getParameterValues("ausstattung");

		InputStream inputStream = null;
		Part filePart = request.getPart("fahrzeugbild");
		if (filePart != null) {
			// prints out some information for debugging

			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();

			int nRead;
			byte[] data = new byte[16384];

			while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}

			buffer.flush();

			FahrzeugService fahrzeugService = new FahrzeugService();
			Fahrzeug fahrzeug = fahrzeugService.createFahrzeug(marke, kennzeichen, modell, baujahr, farbe, laufleistung,
					leistung, kraftstoff, sitzplaetze, tagespreis, buffer.toByteArray(), eigentuemerID,
					ausstattung);
		}

		response.sendRedirect("/carSharing/cars");
	}

}
