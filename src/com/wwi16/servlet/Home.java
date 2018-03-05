package com.wwi16.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.wwi16.model.Ausstattung;
import com.wwi16.model.Distance;
import com.wwi16.model.Fahrzeug;
import com.wwi16.model.FahrzeugHersteller;
import com.wwi16.service.AusstattungService;
import com.wwi16.service.FahrzeugFarbeService;
import com.wwi16.service.FahrzeugKategorieService;
import com.wwi16.service.FahrzeugService;
import com.wwi16.service.HerstellerService;
import com.wwi16.service.UserService;
import com.wwi16.util.RadiusSearchUtil;

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
			request.setAttribute("userEmail", userEmail);
		}
		FahrzeugKategorieService kategorieService = new FahrzeugKategorieService();
		FahrzeugFarbeService farbService = new FahrzeugFarbeService();
		AusstattungService ausstattungsService = new AusstattungService();
		request.setAttribute("kategories", kategorieService.getAllKategories());
		request.setAttribute("ausstattungen", ausstattungsService.getAllAusstattung());
		request.setAttribute("farben", farbService.getAllFarben());

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
		String plz = request.getParameter("plz");
		// String filterType = request.getParameter("plz");
		// String plz = request.getParameter("plz");
		String distance = request.getParameter("distance");

		List<Distance> carDistanceList = getFahrzeugeForPlz(request, plz, Double.valueOf(distance));

		if (carDistanceList != null) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				String json = mapper.writeValueAsString(setFahrzeugBildString(carDistanceList));
				out.print(json);
				out.flush();
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}

	}

	private List<Distance> getFahrzeugeForPlz(HttpServletRequest request, String plz, double distance) {
		RadiusSearchUtil radiusSearchUtil = new RadiusSearchUtil();
		List<Distance> radiusCalculation = radiusSearchUtil.radiusCalculation(request, plz, distance);
		FahrzeugService fahrzeugService = new FahrzeugService();

		List<Distance> carDistanceList = new ArrayList();

		for (Distance distance2 : radiusCalculation) {
			List<Fahrzeug> fahrzeugeByPlz = fahrzeugService.searchFahrzeugByPlz(distance2.getPlz());
			if (fahrzeugeByPlz.size() > 0) {
				Distance distanceToAdd = new Distance(distance2.getPlz(), distance2.getDistance(), distance2.getOrt());
				distanceToAdd.setFahrzeug(fahrzeugeByPlz);
				carDistanceList.add(distanceToAdd);
			}

		}
		return carDistanceList;
	}

	private List<Distance> setFahrzeugBildString(List<Distance> distanceList) {
		for (Distance distance : distanceList) {
			List<Fahrzeug> fahrzeugList = distance.getFahrzeug();
			for (Fahrzeug fahrzeug : fahrzeugList) {
				if (fahrzeug.getFahrzeugbild() != null) {
					fahrzeug.setFahrzeugBildString(new sun.misc.BASE64Encoder().encode(fahrzeug.getFahrzeugbild()));
				}
			}

		}

		return distanceList;
	}

}
