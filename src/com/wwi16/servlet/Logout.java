package com.wwi16.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Logout() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/logout.jsp");
		HttpSession session=request.getSession();  
		session.invalidate();

		
		dispatcher.forward(request, response);
		
	}
}
