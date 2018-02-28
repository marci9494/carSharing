package com.wwi16.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.Ausstattung;
import com.wwi16.model.Fahrzeug;
import com.wwi16.model.User;
import com.wwi16.util.HibernateUtil;

public class FahrzeugService {

	public List<Fahrzeug> searchFahrzeugByPlz(String plz) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<Fahrzeug> fahrzeuge = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Fahrzeug where plz = '" + plz + "'");
			fahrzeuge = (List<Fahrzeug>) query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fahrzeuge;
	}

	public Fahrzeug createFahrzeug(String kennzeichen, String modell, int baujahr, int laufleistung, int leistung,
			String kraftstoff, int sitzplaetze, int basispreis, int kilometerpreis) {

		Session session = HibernateUtil.openSession();
		session.beginTransaction();

		Fahrzeug fahrzeug = new Fahrzeug();
		/* fahrzeug.setHersteller(hersteller); */
		fahrzeug.setModell(modell);
		fahrzeug.setBaujahr(baujahr);
		fahrzeug.setLaufleistung(laufleistung);
		fahrzeug.setLeistung(leistung);
		fahrzeug.setKraftstoff(kraftstoff);
		fahrzeug.setSitzplaetze(sitzplaetze);
		fahrzeug.setBasispreis(basispreis);
		fahrzeug.setKilometerpreis(kilometerpreis);

		try {
			session.save(fahrzeug);
			session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return fahrzeug;

	}

	public Fahrzeug getFahrzeugById(String publicId) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Fahrzeug fahrzeug = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Fahrzeug where id='" + publicId + "'");
			fahrzeug = (Fahrzeug) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fahrzeug;
	}

	public List<Fahrzeug> searchFahrzeugeByUser(String userEmail) {

		UserService userService = new UserService();
		User nutzer = userService.getNutzer(userEmail);

		if (nutzer != null) {

			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			List<Fahrzeug> fahrzeuge = null;
			try {
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from Fahrzeug where eigentuemer = '" + nutzer.getId() + "'");
				fahrzeuge = (List<Fahrzeug>) query.list();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return fahrzeuge;
		}else{
			return null;
		}
	}
}
