package com.wwi16.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.Ausstattung;
import com.wwi16.model.FahrzeugFarbe;
import com.wwi16.util.HibernateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AusstattungService.
 */
public class AusstattungService {
	
    /**
     * Gets the ausstattung by id.
     *
     * @param publicId the public id
     * @return the ausstattung by id
     */
    public Ausstattung getAusstattungById(String publicId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Ausstattung ausstattung = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Ausstattung where id= :id");
            query.setParameter("id", Long.valueOf(publicId));
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
    
	/**
	 * Gets the all ausstattung.
	 *
	 * @return the all ausstattung
	 */
	public List<Ausstattung> getAllAusstattung(){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        List<Ausstattung> ausstattung = new ArrayList<>();
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Ausstattung");
            ausstattung = query.list();
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
