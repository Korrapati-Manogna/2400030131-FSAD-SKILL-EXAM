package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Clientdemo
{
    public static void updateRestaurant(SessionFactory sf, int id)
    {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String hql = "update Restaurant set name=:name, status=:status where id=:id";

        Query q = session.createQuery(hql);
        q.setParameter("name", "Royal Restaurant");
        q.setParameter("status", "Closed");
        q.setParameter("id", id);

        int rows = q.executeUpdate();

        tx.commit();
        session.close();

        System.out.println(rows + " Record Updated using HQL");
    }
}