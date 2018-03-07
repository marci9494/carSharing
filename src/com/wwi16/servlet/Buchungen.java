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
import com.wwi16.model.User;
import com.wwi16.service.BuchungService;
import com.wwi16.service.UserService;

public class Buchungen extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userEmail = (String) session.getAttribute("userEmail");
			if (userEmail != null) {
				UserService userService = new UserService();
				User user = userService.getNutzerByMail(userEmail);
				System.out.print("Hello, " + user.getEmail() + " Welcome to Profile");
				request.setAttribute("user", user);
				dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/buchungen.jsp");
				BuchungService buchungsService = new BuchungService();
				List<Buchung> buchungen = buchungsService.searchBuchungenByUser(user);
				request.setAttribute("myBuchungen", buchungen);
				List<Buchung> buchungenForMyCars = buchungsService.searchBuchungenMyCars(user);
				request.setAttribute("carsBuchungen", buchungenForMyCars);
				System.out.print("Hello, " + userEmail + " Welcome to Profile");
				UserService nutzerService = new UserService();
				User nutzer = nutzerService.getNutzerByMail(userEmail);
				request.setAttribute("user",nutzer);
			}
			else{
				 dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			}
			
		}
		
		
		
		
		
		dispatcher.forward(request, response);
	} 

}
