package com.example.sanatoriyproj.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {

    private static final String url = "jdbc:postgresql://localhost:5432/sanatoriydb";
    private static final String username = "postgres";
    private static final String pwd = "egor404";
    static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, username, pwd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
