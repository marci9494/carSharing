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
import com.wwi16.model.Bewertung;
import com.wwi16.model.Buchung;
import com.wwi16.model.Fahrzeug;
import com.wwi16.model.BuchungStatus;
import com.wwi16.model.User;
import com.wwi16.util.DateUtil;
import com.wwi16.util.HibernateUtil;

import jdk.nashorn.internal.runtime.UserAccessorProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class BuchungService.
 */
public class BuchungService {
	
	/**
	 * Search buchungen by user.
	 *
	 * @param user the user
	 * @return the list
	 */
	public List<Buchung> searchBuchungenByUser(User user) {

		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<Buchung> buchungen = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Buchung b where b.mieter.id=:id");
			query.setParameter("id", user.getId());
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
	
	/**
	 * Search buchungen my cars.
	 *
	 * @param user the user
	 * @return the list
	 */
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
				Query query = session.createQuery("from Buchung b where b.fahrzeug.id=:fahrzeugId");
				 query.setParameter("fahrzeugId", fahrzeug.getId());
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
	
    /**
     * Gets the buchung by id.
     *
     * @param publicId the public id
     * @return the buchung by id
     */
    public Buchung getBuchungById(String publicId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Buchung buchung = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Buchung where id= :id");
            query.setParameter("id", Long.valueOf(publicId));
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
    
    /**
     * Update buchung.
     *
     * @param buchung the buchung
     * @return the buchung
     */
    public Buchung updateBuchung(Buchung buchung){
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
    
    /**
     * Creates the buchung.
     *
     * @param userEmail the user email
     * @param carId the car id
     * @param startDateString the start date string
     * @param endDateString the end date string
     * @return the buchung
     */
    public Buchung createBuchung(String userEmail,String carId, String startDateString, String endDateString){
    	UserService userService = new UserService();
    	FahrzeugService fahrzeugService = new FahrzeugService();
    	Fahrzeug fahrzeug = fahrzeugService.getFahrzeugById(carId);
    	User user = userService.getNutzerByMail(userEmail);
    	
    	Buchung buchung = new Buchung();
    	buchung.setFahrzeug(fahrzeug);
    	buchung.setMieter(user);
    	buchung.setEndDatum(DateUtil.parseDate(endDateString));
    	buchung.setStartDatum(DateUtil.parseDate(startDateString));
    	buchung.setStatus(BuchungStatus.ANGEFRAGT);
    	
    	
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
    
    public Bewertung createBewertungForBuchung(Bewertung bewertung, String buchungsId){
    	Buchung buchung = getBuchungById(buchungsId);
    	if(buchung != null){
    		buchung.setStatus(BuchungStatus.BEWERTET);
    		updateBuchung(buchung);
    		bewertung.setBuchung(buchung);
    		
    		Session session = HibernateUtil.openSession();
    		session.beginTransaction();
        	
    		try {
    			 session.save(bewertung);
    			 session.getTransaction().commit();
    		} catch (Exception e) {

    			e.printStackTrace();
    		} finally {
    			session.close();
    		}

    		return bewertung;
    		
    	}
    	return null;
    }
    

}
