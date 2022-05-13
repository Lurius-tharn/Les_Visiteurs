package com.lurius.les_visiteurs.dao;

import com.lurius.les_visiteurs.model.HibernateSessionFactory;
import com.lurius.les_visiteurs.model.VisiteEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class VisiteDAO {

    private VisiteEntity visite;

    public VisiteDAO() {
        this.visite = new VisiteEntity();
    }

    public VisiteDAO(VisiteEntity visite) {
        this.visite = visite;
    }

    public static ArrayList<VisiteEntity> lister(final int idPlanning) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        ArrayList<VisiteEntity> visites = (ArrayList<VisiteEntity>) session.createQuery("FROM VisiteEntity WHERE idPlanning = :idPlanning").setParameter("idPlanning", idPlanning).list();
        return visites;
    }

    public static void main(String[] args) {

        VisiteDAO v = new VisiteDAO();
        for (VisiteEntity visite : VisiteDAO.lister(11)
        ) {
            System.out.println(visite.toString());
        }
        VisiteEntity visiteEntity = new VisiteEntity();
        visiteEntity.setNom("Thomas");
        visiteEntity.setNote(100000);
        visiteEntity.setDate("23/11/2000");
        visiteEntity.setIdPlanning(11);

        v.setVisite(visiteEntity);
        v.creer();
        for (VisiteEntity visite : VisiteDAO.lister(11)
        ) {
            System.out.println(visite.toString());
        }
        VisiteEntity visiteEntityASupprimer = new VisiteEntity();
        visiteEntityASupprimer.setIdVisite(6);
        v.setVisite(visiteEntityASupprimer);
        v.supprimer();
        for (VisiteEntity visite : VisiteDAO.lister(11)
        ) {
            System.out.println(visite.toString());
        }

    }

    public void supprimer() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        System.out.println(visite.getIdVisite());
        VisiteEntity visiteEntity = session.find(VisiteEntity.class, this.visite.getIdVisite());
        session.remove(visiteEntity);
        tx.commit();
        session.close();

    }

//    public void modifier(final String nom, final) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        VisiteEntity planningEntity = session.find(PlanningEntity.class, this.visite.getIdVisite());
//        planningEntity.setNom(nom);
//        session.update(planningEntity);
//        tx.commit();
//        session.close();
//
//    }

    public void creer() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(visite);
        tx.commit();
        session.close();

    }

    public VisiteEntity getVisite() {
        return visite;
    }

    public void setVisite(VisiteEntity visite) {
        this.visite = visite;
    }
}
