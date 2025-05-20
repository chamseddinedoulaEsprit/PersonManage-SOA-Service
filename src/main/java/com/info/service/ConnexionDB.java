package com.info.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {
    private static Connection cn;

    private ConnexionDB() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnexion() {
        try {
            if (cn == null || cn.isClosed()) {
                // Establish a new connection if it is not initialized or closed
                String url = "jdbc:mysql://localhost:3306/tptest";
                String username = "root";
                String password = "";
                Class.forName("com.mysql.cj.jdbc.Driver");
                cn = DriverManager.getConnection(url, username, password);
            }
            return cn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
