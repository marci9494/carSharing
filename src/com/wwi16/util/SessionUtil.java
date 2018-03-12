package com.wwi16.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wwi16.model.User;
import com.wwi16.service.UserService;

public class SessionUtil {
	public static User setSessionEmail(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userEmail = (String) session.getAttribute("userEmail");

			if (userEmail != null) {
				UserService nutzerService = new UserService();
				User nutzer = nutzerService.getNutzerByMail(userEmail);
				request.setAttribute("user", nutzer);
				return nutzer;
			}
			return null;
		}
		return null;
	}
}
