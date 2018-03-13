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
import com.wwi16.util.XssUtil;

/**
 * The Class Register.
 */
@MultipartConfig
public class Register extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String anrede = XssUtil.sanitize(request.getParameter("anrede"));
		if (anrede.equals("0")) {
			anrede = "Frau";
		} else {
			anrede = "Herr";
		}
		String vorname = XssUtil.sanitize(request.getParameter("vorname"));
		String nachname = XssUtil.sanitize(request.getParameter("nachname"));
		String strasse = XssUtil.sanitize(request.getParameter("strasse"));
		String hausnummer = XssUtil.sanitize(request.getParameter("hausnummer"));
		String plz = XssUtil.sanitize(request.getParameter("postleitzahl"));
		String ort = XssUtil.sanitize(request.getParameter("stadt"));
		// Dont sanitize email
		String email = request.getParameter("email");
		String kartennummer = XssUtil.sanitize(request.getParameter("kartennummer"));
		String valid = XssUtil.sanitize(request.getParameter("valid"));
		String karteninhaber = XssUtil.sanitize(request.getParameter("karteninhaber"));
		String passwort = XssUtil.sanitize(request.getParameter("passwort"));
		InputStream inputStream = null;
		Part filePart = request.getPart("personalausweis");
		if (filePart != null) {

			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();

			int nRead;
			byte[] data = new byte[16384];

			while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}

			buffer.flush();

			UserService userService = new UserService();
			User nutzerByMail = userService.getNutzerByMail(email);
			User nutzer = null;
			if (nutzerByMail == null) {
				nutzer = userService.createNutzer(anrede, vorname, nachname, strasse, hausnummer, plz, ort, email,
						passwort, buffer.toByteArray(), kartennummer, valid, karteninhaber);
			}

			if (nutzer != null) {
				System.out.println("User " + email + " registriert");
				HttpSession session = request.getSession();
				session.setAttribute("userEmail", email);

				response.sendRedirect("/carSharing/home");
				return;
			} else {
				// TODO fehlerbehandlung
				PrintWriter out = response.getWriter();
				out.print("Fehler! Bitte erneut probieren");
				out.flush();
			}
		}

	}

}
