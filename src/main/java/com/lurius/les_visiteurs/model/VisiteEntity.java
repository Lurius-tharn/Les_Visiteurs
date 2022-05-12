package com.lurius.les_visiteurs.model;

import javax.persistence.*;

@Entity
@Table(name = "visite", schema = "visiteurs", catalog = "")
public class VisiteEntity {
    private int idVisite;
    private String nom;
    private String date;
    private int note;
    private int idPlanning;

    @Id
    @Column(name = "idVisite", nullable = false)
    public int getIdVisite() {
        return idVisite;
    }

    public void setIdVisite(int idVisite) {
        this.idVisite = idVisite;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 25)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "date", nullable = false, length = 25)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "note", nullable = false)
    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Basic
    @Column(name = "idPlanning", nullable = false)
    public int getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisiteEntity that = (VisiteEntity) o;

        if (idVisite != that.idVisite) return false;
        if (note != that.note) return false;
        if (idPlanning != that.idPlanning) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVisite;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + note;
        result = 31 * result + idPlanning;
        return result;
    }
}
