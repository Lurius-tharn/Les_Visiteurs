package com.lurius.les_visiteurs.dao;

import com.lurius.les_visiteurs.model.HibernateSessionFactory;
import com.lurius.les_visiteurs.model.PlanningEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

/**
 * @version 1.0
 * Classe PlanningDAO permettant l'interaction avec la table planning
 * @Author Fitz
 **/
public class PlanningDAO {

    private PlanningEntity planningEntity;

    /**
     * Constructeur vide instanciant les objets
     **/
    public PlanningDAO() {
        this.planningEntity = new PlanningEntity();
    }

    /**
     * Constructeur  instanciant un compte paramètres lors d'une instanciation
     *
     * @param planningEntity - PlanningEntity le model planning
     **/

    public PlanningDAO(PlanningEntity planningEntity) {
        this.planningEntity = planningEntity;
    }

    /**
     * Fonction static renvoyant une liste de tous les plannings
     *
     * @return plannings
     **/
    public static ArrayList<PlanningEntity> lister() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        final ArrayList<PlanningEntity> plannings = (ArrayList<PlanningEntity>) session.createQuery("from PlanningEntity ").list();
        session.close();
        return plannings;

    }

    /**
     * Fonction static représentant une transaction
     **/
    public static void main(String[] args) {

        PlanningEntity planningEntity = new PlanningEntity();
        planningEntity.setIdPlanning(7);
        PlanningDAO planningDAO = new PlanningDAO(planningEntity);
//        planningDAO.supprimer();

        //Ajout d'un nouveau planning
        PlanningEntity planningEntity2 = new PlanningEntity();
        planningEntity2.setNom("Chez FitzOunet");
//        planningEntity2.setIdPlanning(11);
//
        planningDAO.setPlanningEntity(planningEntity2);
        ;


        System.out.println(planningDAO.creer());
//        planningDAO.modifier("Thom");
//
//        //Modification du planning
//        planningDAO.modifier("Thom");
        ArrayList<PlanningEntity> arrayList = PlanningDAO.lister();

        for (PlanningEntity planningEntityo :
                arrayList
        ) {
            System.out.println(planningEntityo.toString());
        }

    }

    /**
     * Fonction supprimant planning
     **/
    public void supprimer() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        PlanningEntity planningEntity = session.find(PlanningEntity.class, this.planningEntity.getIdPlanning());
        session.remove(planningEntity);
        tx.commit();
        session.close();

    }

    /**
     * Fonction créant un planning
     **/
    public int creer() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(planningEntity);
        tx.commit();
        String getLatestId = "FROM PlanningEntity p WHERE p.nom = :nomEnregistre";
        Query query = session.createQuery(getLatestId);
        query.setParameter("nomEnregistre", planningEntity.getNom());
        ArrayList<PlanningEntity> results = (ArrayList<PlanningEntity>) query.list();
        session.close();

        return results.get(0).getIdPlanning();

    }

    /**
     * Fonction modifiant un planning
     *
     * @param nom - le nouveau nom du planning
     **/
    public void modifier(final String nom) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        PlanningEntity planningEntity = session.find(PlanningEntity.class, this.planningEntity.getIdPlanning());
        planningEntity.setNom(nom);
        session.update(planningEntity);
        tx.commit();
        session.close();

    }

    /**
     * Getters et Setters
     **/
    public PlanningEntity getPlanningEntity() {
        return planningEntity;
    }

    public void setPlanningEntity(PlanningEntity planningEntity) {
        this.planningEntity = planningEntity;
    }
}
