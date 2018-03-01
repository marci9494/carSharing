package com.wwi16.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wwi16.model.Buchung;
import com.wwi16.service.BuchungService;

public class Buchungen extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/buchungen.jsp");
		
		BuchungService buchungsService = new BuchungService();
		List<Buchung> buchungen = buchungsService.searchBuchungByUser("");
		
		System.out.println(buchungen.size());
		
		request.setAttribute("buchungen", buchungen);
		
		
		dispatcher.forward(request, response);
	} 

}
