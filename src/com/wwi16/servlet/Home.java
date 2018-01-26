package com.wwi16.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wwi16.model.Ausstattung;
import com.wwi16.service.AusstattungService;



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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
		
		AusstattungService ausstattungsServie = new AusstattungService();
		Ausstattung ausstattungById = ausstattungsServie.getAusstattungById("1");
		System.out.println(ausstattungById.getName());
		request.setAttribute("ausstattung", ausstattungById.getName());
//		CarService carService = new CarService();
//		Car car = carService.getCarByUserId("1");
//		System.out.println(car.getModel());
//		request.setAttribute("model", car.getModel());
		
		dispatcher.forward(request, response);
//		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = con.prepareStatement("select id, model, marke from car");
//			rs = ps.executeQuery();
//			
//			if(rs != null){
//				rs.next();
//				System.out.println(rs.getString("model"));
//				System.out.println(rs.getString("marke"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	


}
