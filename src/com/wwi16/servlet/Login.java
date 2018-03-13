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

import com.wwi16.service.UserService;
import com.wwi16.util.XssUtil;


// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
public class Login extends HttpServlet {
	
    /**
     * Instantiates a new login.
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
		
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        String user = request.getParameter("username");
	        String pass = XssUtil.sanitize(request.getParameter("pass"));
	        UserService nutzerService = new UserService();
	        boolean checkLogin = nutzerService.checkLogin(user, pass);
	        
	        if(checkLogin){
	        	System.out.println("Nutzer " + user + " angemeldet");
	        	HttpSession session=request.getSession();  
	            session.setAttribute("userEmail",user);  
	            response.sendRedirect("/carSharing/home");
				return;
	        }else{
				PrintWriter out = response.getWriter();
				out.print("Fehler! Falsches PW. Bitte erneut probieren");
		    	out.flush();
	        }
	        	
	}
}

