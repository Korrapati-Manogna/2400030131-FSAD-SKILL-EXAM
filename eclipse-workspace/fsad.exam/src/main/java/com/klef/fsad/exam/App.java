package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class App 
{
    public static void main(String[] args) 
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Restaurant r = new Restaurant();
        r.setName("Food Palace");
        r.setDate(new Date());
        r.setStatus("Open");
        r.setLocation("Hyderabad");
        r.setRating(4.5);

        session.persist(r);

        tx.commit();
        session.close();

        System.out.println("Restaurant Inserted Successfully");

        Clientdemo.updateRestaurant(sf, r.getId());

        sf.close();
    }
}