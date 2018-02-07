package com.wwi16.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.Ausstattung;
import com.wwi16.model.Nutzer;
import com.wwi16.util.HibernateUtil;

public class NutzerService {
	
	public boolean checkLogin(String email, String pw){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Nutzer nutzer = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Nutzer where email='"+email+"'");
            nutzer = (Nutzer)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
		
        if (nutzer != null){
        	String hashPassword = hashPassword(pw);
        	if(hashPassword.equals(nutzer.getPassword())){
        		return true;
        	}else{
        		return false;
        	}
        }else{
        	System.out.println("Email nicht gefunden");
        }
		
		return false;
	}
	
	public Nutzer createNutzer(String vorname, String nachname,String strasse,String plz, String ort, String email, boolean vermieter, String password){
		 Session session = HibernateUtil.openSession();
		 
		 session.beginTransaction();
		 
		 Nutzer nutzer = new Nutzer();
		 nutzer.setEmail(email);
		 nutzer.setNachname(nachname);
		 nutzer.setOrt(ort);
		 nutzer.setPlz(plz);
		 nutzer.setStrasse(strasse);
		 nutzer.setVermieter(vermieter);
		 nutzer.setVorname(vorname);
		 nutzer.setPassword(hashPassword(password));
		 try{
		 session.save(nutzer);
		 session.getTransaction().commit();
	        } catch (Exception e) {
	     
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
		
		return nutzer;
	}
	
	private String hashPassword(String password){
		String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
	}

}
