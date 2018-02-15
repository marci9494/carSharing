package com.wwi16.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wwi16.model.Nutzer;
import com.wwi16.service.NutzerService;

public class Register extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//TODO noch nicht alle parameter übergeben
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String strasse = request.getParameter("strasse");
		String plz = request.getParameter("postleitzahl");
		String ort = request.getParameter("stadt");
		String email = request.getParameter("email");
		//Aktuell werden keine vermieter angelegt
		boolean vermieter = false;
		String passwort = request.getParameter("passwort");
	
		
		
		NutzerService nutzerService = new NutzerService();
		Nutzer nutzer = nutzerService.createNutzer(vorname, nachname, strasse, plz, ort, email, vermieter, passwort);
		
		if(nutzer != null){
			System.out.println("User " + email + " registriert");
			HttpSession session=request.getSession();  
            session.setAttribute("userEmail",email);  
            PrintWriter out = response.getWriter();
            out.print(Boolean.TRUE);
    		out.flush();
		}
		
	}

}
