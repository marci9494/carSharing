package com.wwi16.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.FahrzeugHersteller;
import com.wwi16.util.HibernateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class FahrzeugHerstellerService.
 */
public class FahrzeugHerstellerService {
	
	/**
	 * Gets the all hersteller.
	 *
	 * @return the all hersteller
	 */
	public List<FahrzeugHersteller> getAllHersteller(){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        List<FahrzeugHersteller> hersteller = new ArrayList<>();
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("FROM FahrzeugHersteller");
            hersteller = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return hersteller;
	}
	
	
}
