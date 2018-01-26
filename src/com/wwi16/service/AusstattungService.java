package com.wwi16.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.Ausstattung;
import com.wwi16.util.HibernateUtil;

public class AusstattungService {
	
    public Ausstattung getAusstattungById(String publicId) {
        Session session = HibernateUtil.openSession();
        System.err.println("Session geöffnet");
        Transaction tx = null;
        Ausstattung ausstattung = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Ausstattung where id='"+publicId+"'");
            ausstattung = (Ausstattung)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ausstattung;
    }
}
