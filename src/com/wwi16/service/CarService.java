package com.wwi16.service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wwi16.model.Car;
import com.wwi16.util.HibernateUtil;

public class CarService {



    public Car getCarByUserId(String publicId) {
        Session session = HibernateUtil.openSession();
        System.err.println("Session geöffnet");
        Transaction tx = null;
        Car car = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Car where id='"+publicId+"'");
            car = (Car)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return car;
    }
    
//    public List<User> getListOfUsers(){
//        List<User> list = new ArrayList<User>();
//        Session session = HibernateUtil.openSession();
//        Transaction tx = null;        
//        try {
//            tx = session.getTransaction();
//            tx.begin();
//            list = session.createQuery("from User").list();                        
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return list;
//    }
}
