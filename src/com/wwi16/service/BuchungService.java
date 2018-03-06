package com.wwi16.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.Ausstattung;
import com.wwi16.model.Buchung;
import com.wwi16.model.Fahrzeug;
import com.wwi16.model.FahrzeugStatus;
import com.wwi16.model.User;
import com.wwi16.util.HibernateUtil;

import jdk.nashorn.internal.runtime.UserAccessorProperty;

public class BuchungService {
	
	public List<Buchung> searchBuchungenByUser(User user) {

		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<Buchung> buchungen = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Buchung where mieter ='"+ user.getId() +"'");
			buchungen = (List<Buchung>) query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return buchungen;
	}
	public List<Buchung> searchBuchungenMyCars(User user) {

		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<Buchung> buchungen = new ArrayList<>();
		FahrzeugService fahrzeugService = new FahrzeugService();
		List<Fahrzeug> fahrzeugeByUser = fahrzeugService.searchFahrzeugeByUser(user);
		try {
			for (Fahrzeug fahrzeug : fahrzeugeByUser) {
				tx = session.getTransaction();
				tx.begin();
				Query query = session.createQuery("from Buchung where fahrzeug ='"+ fahrzeug.getId() +"'");
				buchungen.addAll((List<Buchung>) query.list());
				tx.commit();
			}
			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return buchungen;
	}
	
    public Buchung getBuchungById(String publicId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Buchung buchung = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Buchung where id='"+publicId+"'");
            buchung = (Buchung)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return buchung;
    }
    
    public Buchung saveBuchung(Buchung buchung){
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
    	
		try {
			 session.update(buchung);
			 session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return buchung;
    }
    
    public Buchung createBuchung(String userEmail,String carId, String startDateString, String endDateString){
    	UserService userService = new UserService();
    	FahrzeugService fahrzeugService = new FahrzeugService();
    	Fahrzeug fahrzeug = fahrzeugService.getFahrzeugById(carId);
    	User user = userService.getNutzerByMail(userEmail);
    	
    	Buchung buchung = new Buchung();
    	buchung.setFahrzeug(fahrzeug);
    	buchung.setMieter(user);
    	buchung.setEndDatum(parseDate(endDateString));
    	buchung.setStartDatum(parseDate(startDateString));
    	buchung.setStatus(FahrzeugStatus.ANGEFRAGT);
    	
    	
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
    	
		try {
			 session.save(buchung);
			 session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return buchung;
    }

	private Date parseDate(String dateString){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
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
