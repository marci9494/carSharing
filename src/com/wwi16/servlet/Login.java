package com.wwi16.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wwi16.service.NutzerService;

/*import com.wwi16.service.NutzerService;*/

public class Login extends HttpServlet {
	
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		
//		AusstattungService ausstattungsServie = new AusstattungService();
//		Ausstattung ausstattungById = ausstattungsServie.getAusstattungById("1");
//		System.out.println(ausstattungById.getName());
//		request.setAttribute("ausstattung", ausstattungById);

		
		dispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        String user = request.getParameter("username");
	        String pass = request.getParameter("pass");
	        NutzerService nutzerService = new NutzerService();
	        boolean checkLogin = nutzerService.checkLogin(user, pass);
	        System.out.println("Login = " + checkLogin);
	        
	        if(checkLogin){
	        	System.out.println("Nutzer " + user + " angemeldet");
	        	HttpSession session=request.getSession();  
	            session.setAttribute("userEmail",user);  
	            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
	            dispatcher.forward(request, response);
	        }else{
	        	System.out.println("Falsches PW von User  " + user);
	        	//TODO Fehlermeldung anzeigen
	        }
	        	
	}
}

