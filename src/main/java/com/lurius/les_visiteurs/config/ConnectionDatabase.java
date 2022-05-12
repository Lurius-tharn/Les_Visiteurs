package com.lurius.les_visiteurs.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
    public static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/Visiteurs";

    public static Connection con() throws ClassNotFoundException, SQLException {
        Class.forName(CLASS_NAME);
        final Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        return con;
    }
}