package com.lurius.les_visiteurs.dao;

import com.lurius.les_visiteurs.model.HibernateSessionFactory;
import com.lurius.les_visiteurs.model.PlanningEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class PlanningDAO {

    private PlanningEntity planningEntity;

    public PlanningDAO() {
        this.planningEntity = new PlanningEntity();
    }

    public PlanningDAO(PlanningEntity planningEntity) {
        this.planningEntity = planningEntity;
    }

    public static ArrayList<PlanningEntity> lister() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        final ArrayList<PlanningEntity> plannings = (ArrayList<PlanningEntity>) session.createQuery("from PlanningEntity ").list();
        session.close();
        return plannings;

    }

    public static void main(String[] args) {

        PlanningEntity planningEntity = new PlanningEntity();
        planningEntity.setIdPlanning(7);
        PlanningDAO planningDAO = new PlanningDAO(planningEntity);
//        planningDAO.supprimer();

        //Ajout d'un nouveau planning
        PlanningEntity planningEntity2 = new PlanningEntity();
        planningEntity2.setNom("Chez Fitz");
        planningEntity2.setIdPlanning(11);

        planningDAO.setPlanningEntity(planningEntity2);
        planningDAO.creer();
        planningDAO.modifier("Thom");

        //Modification du planning
        planningDAO.modifier("Thom");
        ArrayList<PlanningEntity> arrayList = PlanningDAO.lister();

        for (PlanningEntity planningEntityo :
                arrayList
        ) {
            System.out.println(planningEntityo.toString());
        }

    }

    public void supprimer() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        PlanningEntity planningEntity = session.find(PlanningEntity.class, this.planningEntity.getIdPlanning());
        session.remove(planningEntity);
        tx.commit();
        session.close();

    }

    public void creer() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(planningEntity);
        tx.commit();
        session.close();

    }

    public void modifier(final String nom) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        PlanningEntity planningEntity = session.find(PlanningEntity.class, this.planningEntity.getIdPlanning());
        planningEntity.setNom(nom);
        session.update(planningEntity);
        tx.commit();
        session.close();

    }

    public PlanningEntity getPlanningEntity() {
        return planningEntity;
    }

    public void setPlanningEntity(PlanningEntity planningEntity) {
        this.planningEntity = planningEntity;
    }
}
