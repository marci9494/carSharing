package com.wwi16.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;

import com.wwi16.model.Buchung;
import com.wwi16.service.BuchungService;

public class Buchungen extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userEmail = (String) session.getAttribute("userEmail");
			if(userEmail != null){
				dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/buchungen.jsp");
				BuchungService buchungsService = new BuchungService();
				List<Buchung> buchungen = buchungsService.searchBuchungByUser(userEmail);
				request.setAttribute("buchungen", buchungen);
				System.out.print("Hello, " + userEmail + " Welcome to Profile");
				request.setAttribute("userEmail", userEmail);
			}
			else{
				 dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			}
			
		}
		
		
		
		
		
		dispatcher.forward(request, response);
	} 

}
