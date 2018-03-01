package com.wwi16.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.FahrzeugFarbe;
import com.wwi16.model.FahrzeugKategorie;
import com.wwi16.util.HibernateUtil;

public class FahrzeugKategorieService {
	
	public FahrzeugKategorie getFahrzeugKategorieById(String publicId) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		FahrzeugKategorie kategorie = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from FahrzeugKategorie where id='" + publicId + "'");
			kategorie = (FahrzeugKategorie) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return kategorie;
	}
}
