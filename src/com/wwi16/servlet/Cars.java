package com.wwi16.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wwi16.model.Fahrzeug;
import com.wwi16.model.User;
import com.wwi16.service.FahrzeugService;
import com.wwi16.service.UserService;
import com.wwi16.util.SessionUtil;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Cars.
 */

public class Cars extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 112333L;

	/**
	 * Instantiates a new cars.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public Cars() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Do get.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		User user = SessionUtil.setSessionEmail(request);

		if (user != null) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/cars.jsp");

			FahrzeugService fahrzeugService = new FahrzeugService();
			List<Fahrzeug> fahrzeuge = fahrzeugService.searchFahrzeugeByUser(user);
			request.setAttribute("fahrzeuge", fahrzeuge);

		} else {
			response.sendRedirect("/carSharing/login");
			return;
		}

		dispatcher.forward(request, response);

	}

	/**
	 * Do post.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
