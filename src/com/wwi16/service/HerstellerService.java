package com.wwi16.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.User;
import com.wwi16.util.HibernateUtil;

public class HerstellerService {
	
	// unvollständig:
	public String[] getAllHersteller(){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        String [] hersteller = new String[73];
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("select name from fahrzeug_hersteller");
            hersteller[0] = (String)query.uniqueResult();
            system.out.println("Hallo");
            return hersteller;
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
