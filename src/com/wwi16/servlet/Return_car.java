package com.wwi16.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wwi16.model.Buchung;
import com.wwi16.model.Fahrzeug;
import com.wwi16.service.BuchungService;
import com.wwi16.service.FahrzeugService;

public class Return_car extends HttpServlet {
	
    public Return_car() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/return_car.jsp");
		
		HttpSession session = request.getSession(false);
		//Buchungsservice wird angelegt, damit die Funktion später verwendet werden kann
		if (session != null) {
			BuchungService buchungservice = new BuchungService();
			
			//Für den Willkommenstext wird die UserEmail geholt
			String userEmail = (String) session.getAttribute("userEmail");
			request.setAttribute("userEmail", userEmail);
			
			//Für die Buchung wird die Buchungsid geholt
			String buchungid = request.getParameter("id");
			Buchung buchung = buchungservice.getBuchungById(buchungid);
			request.setAttribute("buchung", buchung);
		}
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Parameter werden auf die Werte aus der jsp gesetzt
		String maengel = request.getParameter("maengel");
		String nachricht = request.getParameter("nachricht");
		String buchungid = request.getParameter("buchungid");
		
		//Zur Überprüfung werden die Daten in der Konsole ausgegeben
		System.out.println(maengel);
		System.out.println(nachricht);
		System.out.println(buchungid);
		
		//Buchungsservice wird angelegt
		BuchungService buchungservice = new BuchungService();
		//Es wird nach entsprechender Buchung gesucht
		Buchung buchung = buchungservice.getBuchungById(buchungid); 
		//Daten aus Eingabe werden in die Buchung geschrieben
		buchung.setNachricht(nachricht);
		buchung.setMaengel(maengel);
		//Buchung wird gespeichert
		buchungservice.saveBuchung(buchung);
		// TODO Status auf abgeschlossen noch setzen!!!
	}
}
