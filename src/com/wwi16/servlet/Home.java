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
		 String plz = request.getParameter("plz");
		 System.out.println("plz = " + plz);
		//
		// FahrzeugService fahrzeugService = new FahrzeugService();
		// // TODO search for plz
		// List<Fahrzeug> searchFahrzeug =
		// fahrzeugService.searchFahrzeug("12345");
		//
//		 String json = new Gson().toJson(searchFahrzeug);
		// System.out.println(json);
		 String json = new Gson().toJson(radiusCalculation(request,plz));
		 System.out.println(json);
		 out.print(json);
		 out.flush();
	}

	public List<String> radiusCalculation(HttpServletRequest request,String plz) {
		List<String> orte = new ArrayList<>();
		double distance = 10;
		// Erdradius
		distance = distance / 6378;
		double maxCoord_lon = 0.0;
		double maxCoord_lat = 0.0;
		double minCoord_lon = 0.0;
		double minCoord_lat = 0.0;

		double origin_lon = 0.0;
		double origin_lat = 0.0;
		try {
			ServletContext context = request.getServletContext();
			String fullPath = context.getRealPath("/WEB-INF/PLZ.txt");
			Scanner sc2 = new Scanner(new File(fullPath));
			while (sc2.hasNextLine()) {
				String[] fileRow = sc2.nextLine().split("\t");
				if (fileRow[1].equals(plz)) {
					origin_lon = deg2rad(fileRow[2]);
					origin_lat = deg2rad(fileRow[3]);

					maxCoord_lon = origin_lon + distance;
					maxCoord_lat = origin_lat + distance;
					minCoord_lon = origin_lon - distance;
					minCoord_lat = origin_lat - distance;
				}
			}


			Scanner sc = new Scanner(new File(fullPath));
			while (sc.hasNextLine()) {
				String[] fileRow2 = sc.nextLine().split("\t");
				if (maxCoord_lon >= deg2rad(fileRow2[2]) && minCoord_lon <= deg2rad(fileRow2[2])
						&& maxCoord_lat >= deg2rad(fileRow2[3]) && minCoord_lat <= deg2rad(fileRow2[3])) {
					orte.add(fileRow2[4]);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orte;

	}

	private static double deg2rad(String degString) {
		double deg = Double.parseDouble(degString);
		return (deg * Math.PI / 180.0);
	}

}
