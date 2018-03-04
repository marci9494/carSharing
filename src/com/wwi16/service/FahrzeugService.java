package com.wwi16.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.fabric.xmlrpc.base.Array;
import com.wwi16.model.Ausstattung;
import com.wwi16.model.Fahrzeug;
import com.wwi16.model.FahrzeugFarbe;
import com.wwi16.model.FahrzeugHersteller;
import com.wwi16.model.FahrzeugKategorie;
import com.wwi16.model.FahrzeugVermietZeitraum;
import com.wwi16.model.User;
import com.wwi16.model.VermietZeitraum;
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

	public Fahrzeug createFahrzeug(String kennzeichen, String modell, String baujahr, String laufleistung,
			String leistung, String kraftstoff, String sitzplaetze, String basispreis, String kilometerpreis,byte[] fahrzeugbild) {

		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		FahrzeugFarbeService farbService = new FahrzeugFarbeService();
		HerstellerService herstellerService = new HerstellerService();
		FahrzeugKategorieService kategorieService = new FahrzeugKategorieService();
		UserService userService = new UserService();
		//TODO 1 durch id ersetzen
		FahrzeugFarbe foundFarbe = farbService.getFahrzeugFarbeById("1");
		FahrzeugHersteller foundHersteller = herstellerService.getHerstellerById("1");
		FahrzeugKategorie foundKategorie = kategorieService.getFahrzeugKategorieById("1");
		User user = userService.getNutzerByMail("marcel_ament@web.de");
		Fahrzeug fahrzeug = new Fahrzeug();
		
		if(foundFarbe != null){
			fahrzeug.setFarbe(foundFarbe);
			System.out.println(foundFarbe.getName());
		}
		if(foundHersteller != null){
			fahrzeug.setHersteller(foundHersteller);
			System.out.println(foundHersteller.getName());
		}
		if(foundKategorie != null){
			fahrzeug.setKategorie(foundKategorie);
			System.out.println(foundKategorie.getName());
		}
		if(user != null){
			fahrzeug.setEigentuemer(user);
			System.out.println(user.getNachname());
		}

		// TODO auskommentierte felder müssen noch in der DB angelegt werden.
		
		fahrzeug.setLeistung(leistung);
		fahrzeug.setSitzplaetze(sitzplaetze);
		fahrzeug.setModell(modell);
		fahrzeug.setKm_stand(laufleistung);
		fahrzeug.setFahrzeugbild(fahrzeugbild);
		//TODO ersetzen
		fahrzeug.setPlz("89168");
		
		
		
		
		/* fahrzeug.setHersteller(hersteller); */
		
		// fahrzeug.setBaujahr(baujahr);
		// fahrzeug.setLaufleistung(laufleistung);
		
		// fahrzeug.setKraftstoff(kraftstoff);
		
		// fahrzeug.setBasispreis(basispreis);
		// fahrzeug.setKilometerpreis(kilometerpreis);

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
		User nutzer = userService.getNutzerByMail(userEmail);

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
		} else {
			return null;
		}
	}
	
	public  void addVermietungsZeitraeumeToFahrzeug(List<VermietZeitraum> vermietZeitraeume, String carId){
		Session session = HibernateUtil.openSession();
		Fahrzeug fahrzeug = getFahrzeugById(carId);
		for (VermietZeitraum vermietZeitraum : vermietZeitraeume) {
			
			FahrzeugVermietZeitraum vermietZeitraumEntity = new FahrzeugVermietZeitraum();
			vermietZeitraumEntity.setEndDate(parseDate(vermietZeitraum.getEndDate()));
			vermietZeitraumEntity.setStartDate(parseDate(vermietZeitraum.getStartDate()));
			vermietZeitraumEntity.setFahrzeug(fahrzeug);
			
			
			try {
				 session.save(vermietZeitraumEntity);
				 session.getTransaction().commit();
			} catch (Exception e) {

				e.printStackTrace();
			} finally {
			
			}
			
		}
		

	}
	
	private Date parseDate(String dateString){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date =  formatter.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return date;
	}
}
