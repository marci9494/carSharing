package com.wwi16.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.wwi16.model.Ausstattung;
import com.wwi16.model.Fahrzeug;
import com.wwi16.service.AusstattungService;
import com.wwi16.service.FahrzeugService;
import com.wwi16.service.NutzerService;

/**
 * Servlet implementation class Home
 */

public class Home extends HttpServlet {
	private static final long serialVersionUID = 112333L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userEmail = (String) session.getAttribute("userEmail");

			System.out.print("Hello, " + userEmail + " Welcome to Profile");
		}
		// AusstattungService ausstattungsServie = new AusstattungService();
		// Ausstattung ausstattungById =
		// ausstattungsServie.getAusstattungById("1");
		// System.out.println(ausstattungById.getName());
		// request.setAttribute("fahrzeug", ausstattungById);

		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		FahrzeugService fahrzeugService = new FahrzeugService();
		// TODO search for plz
		List<Fahrzeug> searchFahrzeug = fahrzeugService.searchFahrzeug("12345");

		String json = new Gson().toJson(searchFahrzeug);
		System.out.println(json);
		out.print(json);
		out.flush();
	}

}
