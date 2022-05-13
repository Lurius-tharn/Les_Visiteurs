package com.lurius.les_visiteurs.dao;

import com.lurius.les_visiteurs.model.CompteEntity;
import com.lurius.les_visiteurs.model.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class CompteDAO {


    private CompteEntity compteEntity;

    public CompteDAO(final CompteEntity compteEntity) {
        this.compteEntity = compteEntity;
    }

    public CompteDAO() {
        this.compteEntity = new CompteEntity();
    }

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
        }
        session.close();
        CompteEntity addAccount = new CompteEntity();
        addAccount.setLogin("Helanu");
        addAccount.setPassword("Noland");
        CompteDAO c = new CompteDAO(addAccount);
        c.register();
        System.out.println(c.LogIn());
        System.out.println(CompteDAO.alreadyExists("FItzounet"));
        HibernateSessionFactory.getSessionFactory().close();

    }

    public static boolean alreadyExists(final String login) {
        boolean exist = false;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query selectQuery = session.createQuery("from CompteEntity  where login = :loginUser");
        selectQuery.setParameter("loginUser", login);
        if (!selectQuery.getResultList().isEmpty()) {
            exist = true;
        }
        session.close();
        return exist;
    }

    public boolean LogIn() {
        boolean logged = false;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query selectQuery = session.createQuery("from CompteEntity  where login = :loginUser and password = :passwordUser ");
        selectQuery.setParameter("loginUser", this.compteEntity.getLogin());
        selectQuery.setParameter("passwordUser", this.compteEntity.getPassword());

        if (!selectQuery.getResultList().isEmpty()) {
            logged = true;
        }
        session.close();

        return logged;
    }

    public void register() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(this.compteEntity);
        tx.commit();
        session.close();

    }
}
