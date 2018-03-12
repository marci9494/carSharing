package com.wwi16.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wwi16.model.Kreditkarte;
import com.wwi16.model.User;
import com.wwi16.service.KreditkartenService;
import com.wwi16.service.UserService;
import com.wwi16.util.XssUtil;



// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Profil.
 */

public class Profil extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 112333L;
       
    /**
     * Instantiates a new profil.
     *
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
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
				request.setAttribute("user",nutzer);
				
				KreditkartenService kreditkartenService = new KreditkartenService();
				Kreditkarte kreditkarte = kreditkartenService.getKreditkarteByUser(nutzer);
				request.setAttribute("kreditkarte", kreditkarte);
				
			}else{
				//User nicht angemeldet was machen!?
				
			}
		}
		
		dispatcher.forward(request, response);
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		//TODO noch nicht alle parameter übergeben
		String userId = XssUtil.sanitize(request.getParameter("userId"));
		String vorname = XssUtil.sanitize(request.getParameter("vorname"));
		String nachname = XssUtil.sanitize(request.getParameter("nachname"));
		String strasse = XssUtil.sanitize(request.getParameter("strasse"));
		String plz = XssUtil.sanitize(request.getParameter("plz"));
		String ort = XssUtil.sanitize(request.getParameter("ort"));
		String email = XssUtil.sanitize(request.getParameter("email"));
		String kartennummer = XssUtil.sanitize(request.getParameter("kartennummer"));
		String valid = XssUtil.sanitize(request.getParameter("valid"));
		String karteninhaber = XssUtil.sanitize(request.getParameter("karteninhaber"));
		
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
