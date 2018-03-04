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

import com.wwi16.model.Fahrzeug;
import com.wwi16.model.FahrzeugHersteller;
import com.wwi16.model.FahrzeugKategorie;
import com.wwi16.model.User;
import com.wwi16.service.FahrzeugHerstellerService;
import com.wwi16.service.FahrzeugKategorieService;
import com.wwi16.service.FahrzeugService;
import com.wwi16.service.UserService;

@MultipartConfig
public class Register_car extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register_car.jsp");
				
		FahrzeugHerstellerService FahrzeugHerstellerService = new FahrzeugHerstellerService();
		List<FahrzeugHersteller> hersteller = FahrzeugHerstellerService.getAllHersteller();
		System.out.println("Ausgabe" + hersteller);
		request.setAttribute("hersteller",hersteller);
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Die einzelnen Kennzeichenbestandteile werden mit einem
		// Minuszeichen zusammengefuehrt:
		String kennzeichen_1 = request.getParameter("kennzeichen_1");
		String kennzeichen_2 = request.getParameter("kennzeichen_2");
		String kennzeichen_3 = request.getParameter("kennzeichen_3");
		String kennzeichen = kennzeichen_1 + "-" + kennzeichen_2 + "-" + kennzeichen_3;

		String modell = request.getParameter("modell");
		String baujahr = request.getParameter("baujahr");
		String laufleistung = request.getParameter("laufleistung");
		String leistung = request.getParameter("leistung");
		String kraftstoff = request.getParameter("kraftstoff");
		String farbe = request.getParameter("farbe");
		String sitzplaetze = request.getParameter("sitzplaetze");
		String basispreis = request.getParameter("basispreis_range");
		String kilometerpreis = request.getParameter("kilometerpreis_range");

		InputStream inputStream = null;
		Part filePart = request.getPart("fahrzeugbild");
		if (filePart != null) {
			// prints out some information for debugging
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());

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
			Fahrzeug fahrzeug = fahrzeugService.createFahrzeug(kennzeichen, modell, baujahr, laufleistung, leistung,
					kraftstoff, sitzplaetze, basispreis, kilometerpreis,buffer.toByteArray());
		}
		// PrintWriter out = response.getWriter();
		// if(fahrzeug != null){
		// System.out.println("Fahrzeug " + kennzeichen + " registriert");
		// HttpSession session=request.getSession();
		/// * session.setAttribute("userEmail",email);
		//
		// out.print(Boolean.TRUE);*/
		// out.flush();
		// }else{
		// //TODO fehlerbehandlung
		// out.print(Boolean.TRUE);
		// out.flush();
		// }

	}

}
