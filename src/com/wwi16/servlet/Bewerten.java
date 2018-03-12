package com.wwi16.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wwi16.model.Buchung;
import com.wwi16.model.Fahrzeug;
import com.wwi16.model.User;
import com.wwi16.service.BuchungService;
import com.wwi16.service.FahrzeugService;
import com.wwi16.service.UserService;
import com.wwi16.util.SessionUtil;
import com.wwi16.util.XssUtil;

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

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/bewerten.jsp");
		String buchungid = request.getParameter("id");
		if (buchungid != null) {

			SessionUtil.setSessionEmail(request);
			
			
			BuchungService buchungsService = new BuchungService();
			Buchung buchung = buchungsService.getBuchungById(buchungid);
			if(buchung != null){
				request.setAttribute("buchung", buchung);
			}else{
				response.sendRedirect("/carSharing/buchungen");
				return;
			}
			
			
		}else{
			response.sendRedirect("/carSharing/buchungen");
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
		String zustand = XssUtil.sanitize(request.getParameter("zustand"));
		String freundlichkeit = XssUtil.sanitize(request.getParameter("freundlichkeit"));
		String zahlen = XssUtil.sanitize(request.getParameter("zahlen"));
		

		//Daten in Datenbank schie�en
		//Nutzer zu Buchungsid?
	}

}
