package com.wwi16.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wwi16.service.NutzerService;

public class Login extends HttpServlet {
	
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
		
		String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
		NutzerService nutzerService = new NutzerService();
		boolean erfolgreich = nutzerService.checkLogin(user, pass);
		if (erfolgreich == true) {
			  System.out.println("Correct login credentials");
        } 
        else {
        	System.out.println("Incorrect login credentials");
        }	
			
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
}

