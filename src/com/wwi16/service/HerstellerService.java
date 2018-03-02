package com.wwi16.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.FahrzeugFarbe;
import com.wwi16.model.FahrzeugHersteller;
import com.wwi16.model.User;
import com.wwi16.util.HibernateUtil;

public class HerstellerService {
	

	
	public List<FahrzeugHersteller> getAllHersteller(){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        List<FahrzeugHersteller> hersteller = new ArrayList<>();
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("select name from FahrzeugHersteller");
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
	
    public FahrzeugHersteller getHerstellerById(String publicId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        FahrzeugHersteller FahrzeugHersteller = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from FahrzeugHersteller where id='"+publicId+"'");
            FahrzeugHersteller = (FahrzeugHersteller)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return FahrzeugHersteller;
    }

}
