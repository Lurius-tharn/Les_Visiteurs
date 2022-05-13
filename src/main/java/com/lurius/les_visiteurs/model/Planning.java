package com.lurius.les_visiteurs.model;

/**
 * @deprecated
 **/
public class Planning {
    private int idPlanning;
    private String nom;

    private Planning() {
    }

    public Planning(final int idPlanning, final String nom) {
        this.idPlanning = idPlanning;
        this.nom = nom;
    }

    public int getIdPlanning() {
        return this.idPlanning;
    }

    public void setIdPlanning(final int idPlanning) {
        this.idPlanning = idPlanning;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Planning{idPlanning=" + this.idPlanning + ", nom='" + this.nom + '\'' + '}';
    }
}