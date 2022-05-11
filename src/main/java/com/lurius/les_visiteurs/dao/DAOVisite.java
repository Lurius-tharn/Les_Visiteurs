package com.lurius.les_visiteurs.dao;

import com.lurius.les_visiteurs.model.Visite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOVisite {
    private Visite v;

    public DAOVisite(final Visite v) {
        this.v = v;
    }

    public static ArrayList<Visite> lister(final int id) {
        final ArrayList<Visite> arr = new ArrayList<Visite>();
        try {
            final Connection con = ConnectionDatabase.con();
            final String str = "SELECT * FROM VISITE WHERE idPlanning = ? ";
            final PreparedStatement selectVisites = con.prepareStatement(str);
            selectVisites.setInt(1, id);
            final ResultSet res = selectVisites.executeQuery();
            while (res.next()) {
                System.out.println(res.getInt(1));
                arr.add(new Visite(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getInt(5)));
                System.out.println(res.getInt(5));
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
            final String str = "DELETE FROM  VISITE  WHERE idVisite = ?";
            final PreparedStatement updtatePlanning = con.prepareStatement(str);
            updtatePlanning.setInt(1, id);
            updtatePlanning.executeUpdate();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no charg\u00e9!");
        } catch (SQLException ex) {
        }
    }

    public Visite getV() {
        return this.v;
    }

    public void setV(final Visite v) {
        this.v = v;
    }
}