package com.wwi16.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.wwi16.model.User;
import com.wwi16.service.UserService;

/**
 * The Class Register.
 */
@MultipartConfig
public class Register extends HttpServlet{
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");
		dispatcher.forward(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//TODO noch nicht alle parameter übergeben
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String strasse = request.getParameter("strasse");
		String plz = request.getParameter("postleitzahl");
		String ort = request.getParameter("stadt");
		String email = request.getParameter("email");
		String kartennummer = request.getParameter("kartennummer");
		String valid = request.getParameter("valid");
		String karteninhaber = request.getParameter("karteninhaber");
		//Aktuell werden keine vermieter angelegt
		String passwort = request.getParameter("passwort");
		InputStream inputStream = null;
		Part filePart = request.getPart("personalausweis");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[16384];

            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
              buffer.write(data, 0, nRead);
            }

            buffer.flush();

            UserService nutzerService = new UserService();
            User nutzer = nutzerService.createNutzer(vorname, nachname, strasse, plz, ort, email, passwort, buffer.toByteArray(), kartennummer, valid, karteninhaber);
            PrintWriter out = response.getWriter();
       
		
		if(nutzer != null){
			System.out.println("User " + email + " registriert");
			HttpSession session=request.getSession();  
            session.setAttribute("userEmail",email);  
            
            out.print(Boolean.TRUE);
    		out.flush();
		}else{
			//TODO fehlerbehandlung
			out.print(Boolean.TRUE);
	    	out.flush();
		}
        }
		
	}

}
