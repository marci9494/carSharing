package com.wwi16.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wwi16.model.Ausstattung;
import com.wwi16.service.AusstattungService;



/**
 * Servlet implementation class Profil
 */

public class Profil extends HttpServlet {
	private static final long serialVersionUID = 112333L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/profil.jsp");
		
		AusstattungService ausstattungsServie = new AusstattungService();
		Ausstattung ausstattungById = ausstattungsServie.getAusstattungById("1");
		System.out.println(ausstattungById.getName());
		request.setAttribute("ausstattung", ausstattungById);

		
		dispatcher.forward(request, response);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	


}
