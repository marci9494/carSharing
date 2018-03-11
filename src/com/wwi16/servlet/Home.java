package com.wwi16.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.wwi16.model.FahrzeugVermietZeitraum;
import com.wwi16.model.User;
import com.wwi16.service.AusstattungService;
import com.wwi16.service.BuchungService;
import com.wwi16.service.FahrzeugFarbeService;
import com.wwi16.service.FahrzeugKategorieService;
import com.wwi16.service.FahrzeugService;
import com.wwi16.service.HerstellerService;
import com.wwi16.service.LocationService;
import com.wwi16.service.UserService;
import com.wwi16.util.RadiusSearchUtil;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Home.
 */

public class Home extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 112333L;

	/**
	 * Instantiates a new home.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userEmail = (String) session.getAttribute("userEmail");
			UserService userService = new UserService();
			if (userEmail != null) {
				User user = userService.getNutzerByMail(userEmail);
				System.out.print("Hello, " + user.getEmail() + " Welcome to Profile");
				request.setAttribute("user", user);
				UserService nutzerService = new UserService();
				User nutzer = nutzerService.getNutzerByMail(userEmail);
				request.setAttribute("user",nutzer);
			}
		}
		FahrzeugKategorieService kategorieService = new FahrzeugKategorieService();
		FahrzeugFarbeService farbService = new FahrzeugFarbeService();
		AusstattungService ausstattungsService = new AusstattungService();
		request.setAttribute("kategories", kategorieService.getAllKategories());
		request.setAttribute("ausstattungen", ausstattungsService.getAllAusstattung());
		request.setAttribute("farben", farbService.getAllFarben());

		dispatcher.forward(request, response);

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

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");

		if ("searchCar".equals(action)) {
			String distance = request.getParameter("distance");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String plz = request.getParameter("plz");
			List<Distance> carDistanceList = getFahrzeugeForPlz(request, plz, Double.valueOf(distance), startDate,
					endDate);

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

		} else if ("rentCar".equals(action)) {
			String userEmail = request.getParameter("userEmail");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String carId = request.getParameter("carId");

			BuchungService buchungService = new BuchungService();
			buchungService.createBuchung(userEmail, carId, startDate, endDate);

		}

	}

	/**
	 * Gets the fahrzeuge for plz.
	 *
	 * @param request the request
	 * @param plz the plz
	 * @param distance the distance
	 * @param startDateString the start date string
	 * @param endDateString the end date string
	 * @return the fahrzeuge for plz
	 */
	private List<Distance> getFahrzeugeForPlz(HttpServletRequest request, String plz, double distance,
			String startDateString, String endDateString) {
		RadiusSearchUtil radiusSearchUtil = new RadiusSearchUtil();
		List<Distance> radiusCalculation = radiusSearchUtil.radiusCalculation(request, plz, distance);
		FahrzeugService fahrzeugService = new FahrzeugService();

		Date startDate = parseDate(startDateString);
		Date endDate = parseDate(endDateString);
		Calendar startCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();
		startCal.setTime(startDate);
		endCal.setTime(endDate);
		List<Distance> carDistanceList = new ArrayList();

		for (Distance distance2 : radiusCalculation) {
			List<Fahrzeug> fahrzeugeByPlz = fahrzeugService.searchFahrzeugByPlz(distance2.getPlz());
			if (fahrzeugeByPlz.size() > 0) {
				List<Fahrzeug> fahrzeugeInDateRange = new ArrayList<>();
				for (Fahrzeug fahrzeug : fahrzeugeByPlz) {
					List<FahrzeugVermietZeitraum> vermietZeitraeume = fahrzeug.getVermietZeitraeume();
					for (FahrzeugVermietZeitraum fahrzeugVermietZeitraum : vermietZeitraeume) {
						Calendar cal1 = Calendar.getInstance();
						Calendar cal2 = Calendar.getInstance();
						cal1.setTime(fahrzeugVermietZeitraum.getStartDate());
						cal2.setTime(fahrzeugVermietZeitraum.getEndDate());
						if ((fahrzeugVermietZeitraum.getStartDate().before(startDate)
								&& fahrzeugVermietZeitraum.getEndDate().after(endDate))) {
							fahrzeugeInDateRange.add(fahrzeug);
						} else if (checkIfSameDay(cal1, startCal)) {
							if (fahrzeugVermietZeitraum.getEndDate().after(endDate)) {
								fahrzeugeInDateRange.add(fahrzeug);
							}
						} else if (checkIfSameDay(cal2, endCal)) {
							if (fahrzeugVermietZeitraum.getStartDate().before(startDate)) {
								fahrzeugeInDateRange.add(fahrzeug);
							}
						}
					}
				}
				Distance distanceToAdd = new Distance(distance2.getPlz(), distance2.getDistance(), distance2.getOrt());
				distanceToAdd.setFahrzeug(fahrzeugeInDateRange);
				carDistanceList.add(distanceToAdd);
			}

		}
		return carDistanceList;
	}

	/**
	 * Parses the date.
	 *
	 * @param dateString the date string
	 * @return the date
	 */
	private Date parseDate(String dateString) {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Sets the fahrzeug bild string.
	 *
	 * @param distanceList the distance list
	 * @return the list
	 */
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

	/**
	 * Check if same day.
	 *
	 * @param cal1 the cal 1
	 * @param cal2 the cal 2
	 * @return true, if successful
	 */
	private boolean checkIfSameDay(Calendar cal1, Calendar cal2) {
		return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
	}

}
