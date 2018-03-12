package com.wwi16.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wwi16.model.Buchung;
import com.wwi16.model.BuchungStatus;
import com.wwi16.model.Fahrzeug;
import com.wwi16.model.User;
import com.wwi16.service.BuchungService;
import com.wwi16.service.FahrzeugService;
import com.wwi16.service.UserService;
import com.wwi16.util.DateUtil;
import com.wwi16.util.SessionUtil;
import com.wwi16.util.XssUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class Return_car.
 */
public class Return_car extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/return_car.jsp");

		// Buchungsservice wird angelegt, damit die Funktion sp�ter verwendet
		// werden kann
		User user = SessionUtil.setSessionEmail(request);
		if (user != null) {

			BuchungService buchungservice = new BuchungService();

			// F�r die Buchung wird die Buchungsid geholt
			String buchungid = request.getParameter("id");
			Buchung buchung = buchungservice.getBuchungById(buchungid);
			if (BuchungStatus.ABGESCHLOSSEN == buchung.getStatus() || buchung == null) {
				response.sendRedirect("/carSharing/buchungen");
				return;
			}
			request.setAttribute("buchung", buchung);
		}else{
			response.sendRedirect("/carSharing/login");
			return;
		}
		dispatcher.forward(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Parameter werden auf die Werte aus der jsp gesetzt
		String maengel = XssUtil.sanitize(request.getParameter("maengel"));
		String buchungid = XssUtil.sanitize(request.getParameter("buchungid"));
		String kilometerstand = XssUtil.sanitize(request.getParameter("kilometerstand"));
		String rueckgabedatum = XssUtil.sanitize(request.getParameter("rueckgabedatum"));

		PrintWriter out = response.getWriter();
		if (buchungid != null && kilometerstand != null && rueckgabedatum != null) {

			// Buchungsservice wird angelegt
			BuchungService buchungservice = new BuchungService();
			FahrzeugService fahrzeugService = new FahrzeugService();
			// Es wird nach entsprechender Buchung gesucht
			Buchung buchung = buchungservice.getBuchungById(buchungid);
			// Daten aus Eingabe werden in die Buchung geschrieben
			buchung.setMaengel(maengel);
			buchung.setTatsaechlicheRueckgabeDatum(DateUtil.parseDate(rueckgabedatum));
			buchung.setStatus(BuchungStatus.ABGESCHLOSSEN);
			Fahrzeug fahrzeug = buchung.getFahrzeug();
			fahrzeug.setKm_stand(kilometerstand);

			// Buchung wird gespeichert
			buchungservice.updateBuchung(buchung);
			fahrzeugService.updateFahrzeug(fahrzeug);
			out.print(Boolean.TRUE);
		} else {
			out.print(Boolean.FALSE);

		}
		out.flush();
	}
}
