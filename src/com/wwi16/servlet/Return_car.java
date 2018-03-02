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
		if (session != null) {
			String userEmail = (String) session.getAttribute("userEmail");
			request.setAttribute("userEmail", userEmail);
			String buchung = (String) session.getAttribute("buchung");
			request.setAttribute("buchung", buchung);
		}
		
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maengel = request.getParameter("maengel");
		String nachricht = request.getParameter("nachricht");
		String buchungid = request.getParameter("buchungid");
		BuchungService buchungservice = new BuchungService();
		Buchung buchung = buchungservice.getBuchungById(buchungid); //wo bekomme ich die ID her?
		//buchung.set= maengel; hier fehlen bei beiden noch die tabellen
		//buchung.set = nachricht;
	}
}
