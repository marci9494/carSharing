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
	        PrintWriter out = response.getWriter();
	        String user = request.getParameter("username");
	        String pass = request.getParameter("pass");
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carSharing", "root", "123456");
	            PreparedStatement pst = conn.prepareStatement("Select user,password from nutzer where user=? and password=?");
	            pst.setString(1, user);
	            pst.setString(2, pass);
	            ResultSet rs = pst.executeQuery();
	            if (rs.next()) {
	                out.println("Correct login credentials");
	            } 
	            else {
	                out.println("Incorrect login credentials");
	            }
	        } 
	        catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	}
}

