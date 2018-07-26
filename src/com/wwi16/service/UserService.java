package com.wwi16.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.Ausstattung;
import com.wwi16.model.Kreditkarte;
import com.wwi16.model.User;
import com.wwi16.util.HibernateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class UserService.
 */
public class UserService {

	/**
	 * Check login.
	 *
	 * @param email
	 *            the email
	 * @param pw
	 *            the pw
	 * @return true, if successful
	 */
	public boolean checkLogin(String email, String pw) {
		User nutzer = getNutzerByMail(email);

		if (nutzer != null) {
			String hashPassword = hashPassword(pw);
			if (hashPassword.equals(nutzer.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			System.out.println("Email nicht gefunden");
		}

		return false;
	}

	/**
	 * Creates the nutzer.
	 *
	 * @param anrede
	 *            the anrede
	 * @param vorname
	 *            the vorname
	 * @param nachname
	 *            the nachname
	 * @param strasse
	 *            the strasse
	 * @param hausnummer
	 *            the hausnummer
	 * @param plz
	 *            the plz
	 * @param ort
	 *            the ort
	 * @param email
	 *            the email
	 * @param password
	 *            the password
	 * @param personalausweis
	 *            the personalausweis
	 * @param kartennummer
	 *            the kartennummer
	 * @param valid
	 *            the valid
	 * @param karteninhaber
	 *            the karteninhaber
	 * @return the user
	 */
	public User createNutzer(String anrede, String vorname, String nachname, String strasse, String hausnummer,
			String plz, String ort, String email, String password, byte[] personalausweis, String kartennummer,
			String valid, String karteninhaber) {
		Session session = HibernateUtil.openSession();

		session.beginTransaction();

		User nutzer = new User();

		nutzer.setAnrede(anrede);

		nutzer.setEmail(email);
		nutzer.setNachname(nachname);
		nutzer.setOrt(ort);
		nutzer.setPlz(plz);
		nutzer.setStrasse(strasse);
		nutzer.setHausnummer(hausnummer);
		nutzer.setVorname(vorname);
		nutzer.setPassword(hashPassword(password));
		nutzer.setPersonalausweis(personalausweis);
		

		try {
			session.save(nutzer);
			session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
		}
		

		session.beginTransaction();
		Kreditkarte kreditkarte = new Kreditkarte();
		kreditkarte.setUser(nutzer);
		kreditkarte.setKartennummer(kartennummer);
		kreditkarte.setValid(valid);
		kreditkarte.setInhaber(karteninhaber);
		
		try {
			session.save(kreditkarte);
			session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return nutzer;
	}

	/**
	 * Gets the nutzer by mail.
	 *
	 * @param email
	 *            the email
	 * @return the nutzer by mail
	 */
	public User getNutzerByMail(String email) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		User nutzer = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User where email=:email");
			query.setParameter("email", email);
			nutzer = (User) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return nutzer;
	}

	/**
	 * Gets the nutzer by id.
	 *
	 * @param id
	 *            the id
	 * @return the nutzer by id
	 */
	public User getNutzerById(String id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		User nutzer = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User where id=:id");
			query.setParameter("id", Long.valueOf(id));
			nutzer = (User) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println(nutzer);
		return nutzer;
	}

	/**
	 * Hash password.
	 *
	 * @param password
	 *            the password
	 * @return the string
	 */
	private String hashPassword(String password) {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(password.getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	/**
	 * Update user.
	 *
	 * @param user
	 *            the user
	 * @return the user
	 */
	public User updateUser(User user) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();

		try {
			session.update(user);
			session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return user;
	}

}
