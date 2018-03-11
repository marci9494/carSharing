package com.wwi16.service;

import org.hibernate.Session;

import com.wwi16.model.Ausstattung;
import com.wwi16.model.Fahrzeug;
import com.wwi16.model.FahrzeugAusstattung;
import com.wwi16.util.HibernateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class FahrzeugAusstattungService.
 */
public class FahrzeugAusstattungService {

	/**
	 * Speichert in der Datenbank ein Fahrzeug-Ausstattung-Paar.
	 *
	 * @param fahrzeug the fahrzeug
	 * @param ausstattung            Ein Ausstattungs-Element
	 * @return the fahrzeug ausstattung
	 */
	public FahrzeugAusstattung createFahrzeugAusstattung(Fahrzeug fahrzeug, Ausstattung ausstattung) {

		Session session = HibernateUtil.openSession();
		session.beginTransaction();

		FahrzeugAusstattung fahrzeugAusstattung = new FahrzeugAusstattung();
		fahrzeugAusstattung.setFahrzeug(fahrzeug);
		fahrzeugAusstattung.setAusstattung(ausstattung);

		try {
			session.save(fahrzeugAusstattung);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return fahrzeugAusstattung;

	}

	/**
	 * Speichert in der Datenbank Fahrzeug-Ausstattungs-Paare ab.
	 *
	 * @param fahrzeug the fahrzeug
	 * @param ausstattung Mehrere Ausstattungs-Elemente in Form eines Arrays
	 * @return "true"
	 */
	public boolean createFahrzeugAusstattung(Fahrzeug fahrzeug, String[] ausstattung) {

		for (int i = 0; i < ausstattung.length; i++) {

			Session session = HibernateUtil.openSession();
			session.beginTransaction();

			FahrzeugAusstattung fahrzeugAusstattung = new FahrzeugAusstattung();
			fahrzeugAusstattung.setFahrzeug(fahrzeug);

			AusstattungService ausstattungService = new AusstattungService();
			fahrzeugAusstattung.setAusstattung(ausstattungService.getAusstattungById(ausstattung[i]));

			try {
				session.save(fahrzeugAusstattung);
			} catch (Exception e) {

				e.printStackTrace();
			} finally {
				session.close();
			}

		}

		return true;

	}

}
