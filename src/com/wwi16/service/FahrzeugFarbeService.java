package com.wwi16.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.FahrzeugFarbe;
import com.wwi16.model.FahrzeugKategorie;
import com.wwi16.util.HibernateUtil;

public class FahrzeugFarbeService {
	
    public FahrzeugFarbe getFahrzeugFarbeById(String publicId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        FahrzeugFarbe farbe = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from FahrzeugFarbe where id='"+publicId+"'");
            farbe = (FahrzeugFarbe)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return farbe;
    }
    
	public List<FahrzeugFarbe> getAllFarben(){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        List<FahrzeugFarbe> farben = new ArrayList<>();
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from FahrzeugFarbe");
            farben = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return farben;
	}
}
