package com.wwi16.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.Kreditkarte;
import com.wwi16.model.User;
import com.wwi16.util.HibernateUtil;

public class KreditkartenService {

	public Kreditkarte getKreditkarteByUser(User user){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Kreditkarte kreditkarte = null;
        
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("FROM Kreditkarte WHERE user=" + user.getId() + "");
            kreditkarte = (Kreditkarte) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return kreditkarte;
	}
	
	public Kreditkarte getKreditkarteByUserID(Long userID){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Kreditkarte kreditkarte = null;
        
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("FROM Kreditkarte WHERE user=" + userID + "");
            kreditkarte = (Kreditkarte) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return kreditkarte;
	}
	
	
	
}