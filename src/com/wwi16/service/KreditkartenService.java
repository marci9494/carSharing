package com.wwi16.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.Kreditkarte;
import com.wwi16.model.User;
import com.wwi16.util.HibernateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class KreditkartenService.
 */
public class KreditkartenService {

	/**
	 * Gets the kreditkarte by user.
	 *
	 * @param user the user
	 * @return the kreditkarte by user
	 */
	public Kreditkarte getKreditkarteByUser(User user){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Kreditkarte kreditkarte = null;
        
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("FROM Kreditkarte k WHERE k.user.id=:id");
            query.setParameter("id",user.getId());
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
	
	/**
	 * Gets the kreditkarte by user ID.
	 *
	 * @param userID the user ID
	 * @return the kreditkarte by user ID
	 */
	public Kreditkarte getKreditkarteByUserID(Long userID){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Kreditkarte kreditkarte = null;
        
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("FROM Kreditkarte k WHERE k.user=:id");
            query.setParameter("id",userID);
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
	
	public Kreditkarte updateKreditkarte(Kreditkarte kreditkarte){
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
    	
		try {
			 session.update(kreditkarte);
			 session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return kreditkarte;
	}
	
}
