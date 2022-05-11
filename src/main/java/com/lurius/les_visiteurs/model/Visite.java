package com.lurius.les_visiteurs.model;

import java.util.Objects;

public class Visite
{
    private int id;
    private String nom;
    private int note;
    private String date;
    private int idPlanning;

    private Visite() {
    }

    public Visite(final int id, final String nom, final String date, final int note, final int idPlanning) {
        this.id = id;
        this.nom = nom;
        this.note = note;
        this.date = date;
        this.idPlanning = idPlanning;
    }

    public static String dateFRtoUS(final String date) {
        String newDate = "";
        if (date.length() > 1) {
            final String[] formatedDate = date.split("/");
            newDate = formatedDate[2] + "-" + formatedDate[1] + "-" + formatedDate[0];
        }
        return newDate;
    }

    public static String dateUStoFR(final String date) {
        String newDate = "";
        if (date.length() > 1) {
            final String[] formatedDate = date.split("-");
            newDate = formatedDate[2] + "/" + formatedDate[1] + "/" + formatedDate[0];
        }
        return newDate;
    }

    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public int getNote() {
        return this.note;
    }

    public void setNote(final int note) {
        this.note = note;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public int getIdPlanning() {
        return this.idPlanning;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Visite visite = (Visite)o;
        return this.note == visite.note && Objects.equals(this.nom, visite.nom) && Objects.equals(this.date, visite.date);
    }

    @Override
    public String toString() {
        return "Visite{id=" + this.id + ", nom='" + this.nom + '\'' + ", note=" + this.note + ", date='" + this.date + '\'' + ", idPlanning=" + this.idPlanning + '}';
    }
}