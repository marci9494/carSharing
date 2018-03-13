package com.wwi16.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wwi16.model.BuchungStatus;
import com.wwi16.model.Fahrzeug;
import com.wwi16.model.FahrzeugVermietZeitraum;
import com.wwi16.model.User;
import com.wwi16.model.VermietZeitraum;
import com.wwi16.service.BuchungService;
import com.wwi16.service.FahrzeugService;
import com.wwi16.service.UserService;
import com.wwi16.util.SessionUtil;
import com.wwi16.util.XssUtil;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Cars_detail.
 */

public class Cars_detail extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 112333L;

	/**
	 * Instantiates a new cars detail.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public Cars_detail() {
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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/cars_detail.jsp");

		User user = SessionUtil.setSessionEmail(request);
		if (user != null) {

			FahrzeugService fahrzeugService = new FahrzeugService();
			String carId = (String) request.getParameter("id");
			// TODO Check if user is owner of fahrzeug
			Fahrzeug fahrzeug = fahrzeugService.getFahrzeugById(carId);

			request.setAttribute("fahrzeug", fahrzeug);

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

		String action = request.getParameter("action");

		if (action.equals("saveVermietzeitraum")) {

			String carId = XssUtil.sanitize(request.getParameter("carId"));
			String vermietZeitraeumeString = request.getParameter("vermietZeitraeume");
			Gson gson = new Gson();
			List<VermietZeitraum> vermietzeitraeume = gson.fromJson(vermietZeitraeumeString,
					new TypeToken<List<VermietZeitraum>>() {
					}.getType());

			FahrzeugService fahrzeugService = new FahrzeugService();
			fahrzeugService.addVermietungsZeitraeumeToFahrzeug(vermietzeitraeume, carId);

		} else if ("update".equals(action)) {

			String tagespreis = XssUtil.sanitize(request.getParameter("tagespreis"));

			String carId = request.getParameter("carId");

			FahrzeugService fahrzeugService = new FahrzeugService();
			Fahrzeug fahrzeug = fahrzeugService.getFahrzeugById(carId);

			if (tagespreis != null || tagespreis != "") {
				fahrzeug.setTagespreis(tagespreis);
			}

			fahrzeugService.updateFahrzeug(fahrzeug);

			response.sendRedirect("/carSharing/cars_detail?id=" + carId);
			return;

		} else if ("delete".equals(action)) {
			String id = request.getParameter("id");
			FahrzeugService fahrzeugService = new FahrzeugService();
			fahrzeugService.deleteVermietzeitraum(id);
		}

	}

}
