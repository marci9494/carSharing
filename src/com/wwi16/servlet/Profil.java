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

		HttpSession session = request.getSession(false);
		if (session != null) {
			String userEmail = (String) session.getAttribute("userEmail");

			if(userEmail != null){
				
				UserService nutzerService = new UserService();
				User nutzer = nutzerService.getNutzerByMail(userEmail);
				request.setAttribute("nutzer",nutzer);
				
			}else{
				//User nicht angemeldet was machen!?
				
			}
		}
		
		

		
		dispatcher.forward(request, response);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		//TODO noch nicht alle parameter übergeben
		String userId = request.getParameter("userId");
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String strasse = request.getParameter("strasse");
		String plz = request.getParameter("plz");
		String ort = request.getParameter("ort");
		String email = request.getParameter("email");
		String kartennummer = request.getParameter("kartennummer");
		String valid = request.getParameter("valid");
		String karteninhaber = request.getParameter("karteninhaber");
		
		UserService userService = new UserService();
		User user = userService.getNutzerById(userId);
		
		user.setVorname(vorname);
		user.setNachname(nachname);
		user.setStrasse(strasse);
		user.setOrt(ort);
		user.setEmail(email);
		user.setPlz(plz);
		
		userService.updateUser(user);
		
		
		doGet(request, response);
	}
	


}
