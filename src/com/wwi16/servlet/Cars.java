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



/**
 * Servlet implementation class Cars
 */

public class Cars extends HttpServlet {
	private static final long serialVersionUID = 112333L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cars() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;

		HttpSession session = request.getSession(false);
		if (session != null) {
			String userEmail = (String) session.getAttribute("userEmail");

			if(userEmail != null){
				dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/cars.jsp");
				UserService nutzerService = new UserService();
				User nutzer = nutzerService.getNutzerByMail(userEmail);
				request.setAttribute("user",nutzer);
				
				FahrzeugService fahrzeugService = new FahrzeugService();
				List<Fahrzeug> fahrzeuge = fahrzeugService.searchFahrzeugeByUser(nutzer);
				request.setAttribute("fahrzeuge",fahrzeuge);
				
				
				
			}else{
				//User nicht angemeldet was machen!?
				dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			}
		}
		
		

		
		dispatcher.forward(request, response);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	


}
