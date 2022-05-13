package com.lurius.les_visiteurs.dao;

import com.lurius.les_visiteurs.config.ConnectionDatabase;
import com.lurius.les_visiteurs.model.Compte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @deprecated
 */
public class DAOCompte {
    private Compte c;

    public DAOCompte(final Compte c) {
        this.c = c;
    }

    public static boolean isAlreadyExisted(final String login) {
        boolean isExisted = false;
        try {
            final Connection con = ConnectionDatabase.con();
            final String str = "SELECT * FROM COMPTE WHERE login = ? ";
            final PreparedStatement selectLogin = con.prepareStatement(str);
            selectLogin.setString(1, login);
            final ResultSet res = selectLogin.executeQuery();
            if (res.next()) {
                isExisted = true;
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver !");
        } catch (SQLException ex) {
        }
        return isExisted;
    }

    public boolean LogIn() {
        boolean logged = false;
        try {
            final Connection con = ConnectionDatabase.con();
            final String str = "SELECT * FROM COMPTE WHERE login = ? AND password = ? ";
            final PreparedStatement selectLogin = con.prepareStatement(str);
            selectLogin.setString(1, this.c.getLogin());
            selectLogin.setString(2, this.c.getPassword());
            final ResultSet res = selectLogin.executeQuery();
            if (res.next()) {
                logged = true;
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no charg\u00e9!");
        } catch (SQLException ex) {
        }
        return logged;
    }

    public void register() {
        try {
            final Connection con = ConnectionDatabase.con();
            final String str = "INSERT INTO COMPTE VALUES (null,?,?)";
            final PreparedStatement insertPlanning = con.prepareStatement(str);
            insertPlanning.setString(1, this.c.getLogin());
            insertPlanning.setString(2, this.c.getPassword());
            insertPlanning.executeUpdate();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no charg\u00e9!");
        } catch (SQLException ex) {
        }
    }
}