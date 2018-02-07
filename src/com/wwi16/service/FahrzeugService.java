package com.wwi16.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.Ausstattung;
import com.wwi16.model.Fahrzeug;
import com.wwi16.util.HibernateUtil;

public class FahrzeugService {

	public List<Fahrzeug> searchFahrzeug(String plz){
		
		
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        List<Fahrzeug> fahrzeuge = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Fahrzeug ");
            fahrzeuge = (List<Fahrzeug>)query.list();
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

}
