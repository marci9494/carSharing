package com.wwi16.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wwi16.model.Fahrzeug;
import com.wwi16.model.User;
import com.wwi16.service.FahrzeugService;
import com.wwi16.service.UserService;

public class Register_car extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register_car.jsp");
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Die einzelnen Kennzeichenbestandteile werden mit einem 
		//Minuszeichen zusammengef�hrt:
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
		FahrzeugService fahrzeugService = new FahrzeugService();
		Fahrzeug fahrzeug = fahrzeugService.createFahrzeug(kennzeichen, modell, baujahr, laufleistung, leistung, kraftstoff, sitzplaetze, basispreis, kilometerpreis);
//		PrintWriter out = response.getWriter();
//		if(fahrzeug != null){
//			System.out.println("Fahrzeug " + kennzeichen + " registriert");
//			HttpSession session=request.getSession();  
///*            session.setAttribute("userEmail",email);  
//            
//            out.print(Boolean.TRUE);*/
//    		out.flush();
//		}else{
//			//TODO fehlerbehandlung
//			out.print(Boolean.TRUE);
//	    	out.flush();
//		}
		
	}

}
