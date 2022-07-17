package com.lurius.les_visiteurs.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Classe HibernateSessionFactory permettant d'effectuer des traitements en base
 *
 * @author Fitz
 * @version 1.0
 **/
public class HibernateSessionFactory {
    private static final SessionFactory sessionFactory;

    static {
        try {
// Crée l’objet SessionFactory à partir dehibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}