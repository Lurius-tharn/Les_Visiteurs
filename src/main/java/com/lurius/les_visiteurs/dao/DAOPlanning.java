package com.lurius.les_visiteurs.dao;

import com.lurius.les_visiteurs.config.ConnectionDatabase;
import com.lurius.les_visiteurs.model.Planning;

import java.sql.*;
import java.util.ArrayList;

public class DAOPlanning {
    private Planning p;

    public DAOPlanning(final Planning p) {
        this.p = p;
    }

    public static ArrayList<Planning> lister() {
        final ArrayList<Planning> arr = new ArrayList<Planning>();
        try {
            final Connection con = ConnectionDatabase.con();
            final Statement getPlannings = con.createStatement();
            final String str = "SELECT * FROM PLANNING";
            final ResultSet listPlanning = getPlannings.executeQuery(str);
            while (listPlanning.next()) {
                arr.add(new Planning(listPlanning.getInt(1), listPlanning.getString(2)));
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no charg\u00e9!");
        } catch (SQLException ex) {
        }
        return arr;
    }

    public static void supprimer(final int id) {
        try {
            final Connection con = ConnectionDatabase.con();
            final String str = "DELETE FROM  PLANNING  WHERE idPlanning = ?";
            final PreparedStatement updtatePlanning = con.prepareStatement(str);
            updtatePlanning.setInt(1, id);
            updtatePlanning.executeUpdate();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no charg\u00e9!");
        } catch (SQLException ex) {
        }
    }

    public void creer() {
        try {
            final Connection con = ConnectionDatabase.con();
            final String str = "INSERT  INTO  PLANNING VALUES (?,?)";
            final PreparedStatement insertPlanning = con.prepareStatement(str);
            insertPlanning.setInt(1, this.p.getIdPlanning());
            insertPlanning.setString(2, this.p.getNom());
            insertPlanning.executeUpdate();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no charg\u00e9!");
        } catch (SQLException ex) {
        }
    }

    public void modifier(final String nom) {
        this.p.setNom(nom);
        try {
            final Connection con = ConnectionDatabase.con();
            final String str = "UPDATE  PLANNING  SET nom = ? WHERE idPlanning = ?";
            final PreparedStatement updtatePlanning = con.prepareStatement(str);
            updtatePlanning.setString(1, this.p.getNom());
            updtatePlanning.setInt(2, this.p.getIdPlanning());
            updtatePlanning.executeUpdate();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no charg\u00e9!");
        } catch (SQLException ex) {
        }
    }
}