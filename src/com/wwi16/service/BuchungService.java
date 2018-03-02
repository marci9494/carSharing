package com.wwi16.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.Ausstattung;
import com.wwi16.model.Buchung;
import com.wwi16.model.Fahrzeug;
import com.wwi16.util.HibernateUtil;

public class BuchungService {
	
	public List<Buchung> searchBuchungByUser(String plz) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<Buchung> buchungen = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Buchung");
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

}
