package com.wwi16.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wwi16.model.Fahrzeug;
import com.wwi16.model.User;
import com.wwi16.model.VermietZeitraum;
import com.wwi16.service.FahrzeugService;
import com.wwi16.service.UserService;

/**
 * Servlet implementation class Cars_detail
 */

public class Cars_detail extends HttpServlet {
	private static final long serialVersionUID = 112333L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cars_detail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/cars_detail.jsp");

		HttpSession session = request.getSession(false);
		if (session != null) {
			String userEmail = (String) session.getAttribute("userEmail");

			if (userEmail != null) {

				UserService nutzerService = new UserService();
				User nutzer = nutzerService.getNutzerByMail(userEmail);
				request.setAttribute("nutzer", nutzer);

				FahrzeugService fahrzeugService = new FahrzeugService();
				String carId = (String) request.getParameter("id");
				//TODO Check if user is owner of fahrzeug
				Fahrzeug fahrzeug = fahrzeugService.getFahrzeugById(carId);
				System.out.println(fahrzeug.getVermietZeitraeume().size());
				
				
				request.setAttribute("fahrzeug", fahrzeug);

			} else {
				response.sendRedirect("/carSharing/login");
				return;

			}
		}

		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doPost");
		// TODO noch nicht alle parameter übergeben
		String action = request.getParameter("action");
		// UPDATE CAR
		//
		// UserService userService = new UserService();
		// User user = userService.getNutzerById(userId);
		//
		// user.setVorname(vorname);
		// user.setNachname(nachname);
		// user.setStrasse(strasse);
		// user.setOrt(ort);
		// user.setEmail(email);
		// user.setPlz(plz);
		//
		// userService.updateUser(user);

		if (action.equals("saveVermietzeitraum")) {

			System.out.println("Ajax call super");
			String carId = request.getParameter("carId");
			String vermietZeitraeumeString = request.getParameter("vermietZeitraeume");
			System.out.println(carId);
			System.out.println(vermietZeitraeumeString);
			Gson gson = new Gson();
			List<VermietZeitraum> vermietzeitraeume = gson.fromJson(vermietZeitraeumeString,
					new TypeToken<List<VermietZeitraum>>() {
					}.getType());
			
			FahrzeugService fahrzeugService = new FahrzeugService();
			fahrzeugService.addVermietungsZeitraeumeToFahrzeug(vermietzeitraeume, carId);
		}else if ("update".equals(action)){
			//TODO @Jonas marke usw upzudaten is doch quatsch... Evtl nur Ausstattung, tagespreis, km-stand
			String marke = request.getParameter("marke");
			String modell = request.getParameter("modell");
			String farbe = request.getParameter("farbe");
			String sitzplaetze = request.getParameter("sitzplaetze");
			String leistung = request.getParameter("leistung");
			String tagespreis = request.getParameter("tagespreis");
			String carId = request.getParameter("carId");
			FahrzeugService fahrzeugService = new FahrzeugService();
			Fahrzeug fahrzeug = fahrzeugService.getFahrzeugById(carId);
			
			
		}

	}

}
