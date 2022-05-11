package com.lurius.les_visiteurs.dao;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionDatabase
{
    public static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String DB_NAME = "Visiteurs";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/Visiteurs";

    public static Connection con() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Visiteurs", "root", "");
        return con;
    }
}