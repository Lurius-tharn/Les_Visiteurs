package com.lurius.les_visiteurs.model;

import javax.persistence.*;

/**
 * Classe PLanning representant la Table planning
 *
 * @author Fitz
 * @version 1.0
 **/
@Entity
@Table(name = "planning", schema = "visiteurs", catalog = "")
public class PlanningEntity {
    private int idPlanning;
    private String nom;

    @Id
    @Column(name = "idPlanning", nullable = false)
    public int getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 25)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanningEntity that = (PlanningEntity) o;

        if (idPlanning != that.idPlanning) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPlanning;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PlanningEntity{" +
                "idPlanning=" + idPlanning +
                ", nom='" + nom + '\'' +
                '}';
    }
}
