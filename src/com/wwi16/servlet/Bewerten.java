package com.wwi16.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wwi16.model.User;
import com.wwi16.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class Bewerten.
 */
public class Bewerten extends HttpServlet {

	/**
	 * Instantiates a new bewerten.
	 */
	public Bewerten() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/bewerten.jsp");
		System.out.println("Bewerten!!");
		dispatcher.forward(request, response);
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userEmail = (String) session.getAttribute("userEmail");

			if (userEmail != null) {
				UserService nutzerService = new UserService();
				User nutzer = nutzerService.getNutzerByMail(userEmail);
				request.setAttribute("user", nutzer);
			}
		}

	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
