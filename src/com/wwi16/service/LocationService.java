package com.wwi16.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.Buchung;
import com.wwi16.model.LatLong;
import com.wwi16.util.HibernateUtil;


/**
 * The Class LocationService.
 */
public class LocationService {
	
	/**
	 * Fill lat long table.
	 *
	 * @param request the request
	 */
	public void fillLatLongTable(HttpServletRequest request) {
		//Only use this to fill the table
		ServletContext context = request.getServletContext();
		String fullPath = context.getRealPath("/WEB-INF/PLZ.txt");
		System.out.println("start to fill");
		try {
			Scanner sc2 = new Scanner(new File(fullPath));
			while (sc2.hasNextLine()) {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				String[] fileRow = sc2.nextLine().split("\t");
				LatLong location = new LatLong();
				location.setId(Integer.valueOf(fileRow[0]));
				location.setLat(fileRow[3]);
				location.setLon(fileRow[2]);
				location.setOrt(fileRow[4]);
				location.setPlz(fileRow[1]);
				try {
					session.save(location);
					session.getTransaction().commit();
				} catch (Exception e) {

					e.printStackTrace();
				} finally {
					session.close();
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the location by plz.
	 *
	 * @param plz the plz
	 * @return the location by plz
	 */
	public LatLong getLocationByPlz(String plz){
		 Session session = HibernateUtil.openSession();
	        Transaction tx = null;
	        LatLong location = null;
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("from LatLong where plz='"+plz+"'");
	            location = (LatLong)query.uniqueResult();
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return location;
	}
	
	/**
	 * Gets the all locations.
	 *
	 * @return the all locations
	 */
	public List<LatLong> getAllLocations(){
		 Session session = HibernateUtil.openSession();
	        Transaction tx = null;
	        List<LatLong> location = null;
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("from LatLong");
	            location = (List<LatLong>)query.list();
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return location;
	}
	
}
