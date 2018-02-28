package com.wwi16.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wwi16.model.Fahrzeug;
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
			System.out.print("Hello, " + userEmail + " Welcome to Profile");
			request.setAttribute("userEmail", userEmail);
		}
		
		String carId = (String)request.getParameter("id");
		
		if(carId != null){
			FahrzeugService fahrzeugService = new FahrzeugService();
			Fahrzeug fahrzeugById = fahrzeugService.getFahrzeugById(carId);
			request.setAttribute("car", fahrzeugById);
		}else{
			System.out.println("Keine CarId gesetzt");
		}
		
		
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
