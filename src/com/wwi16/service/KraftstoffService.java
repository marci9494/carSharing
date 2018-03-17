package com.wwi16.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.Kraftstoff;
import com.wwi16.util.HibernateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class KraftstoffService.
 */
public class KraftstoffService {
	
	/**
	 * Gets the kraftstoff by id.
	 *
	 * @param publicId the public id
	 * @return the kraftstoff by id
	 */
	public Kraftstoff getKraftstoffById(String publicId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Kraftstoff kraftstoff = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Kraftstoff where id=:id");
            query.setParameter("id",Long.valueOf(publicId));
            kraftstoff = (Kraftstoff)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return kraftstoff;
    }
    
	/**
	 * Gets the all kraftstoff.
	 *
	 * @return the all kraftstoff
	 */
	public List<Kraftstoff> getAllKraftstoff(){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        List<Kraftstoff> kraftstoffe = new ArrayList<>();
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Kraftstoff");
            kraftstoffe = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return kraftstoffe;
	}

}
