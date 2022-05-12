package com.lurius.les_visiteurs.dao;

import com.lurius.les_visiteurs.model.CompteEntity;
import com.lurius.les_visiteurs.model.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class CompteDAO {
    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();


        Query selectQuery = session.createQuery("from CompteEntity  where id = :idUser");
        selectQuery.setParameter("idUser", 3);
        List listCompte = selectQuery.list();
        Iterator it = listCompte.iterator();
        while (it.hasNext()) {
            CompteEntity c = (CompteEntity) it.next();
            System.out.println(c.getLogin());
            c.setLogin("FItzounet");
            session.saveOrUpdate(c);
            tx.commit();


        }


        HibernateSessionFactory.getSessionFactory().close();
    }
}
