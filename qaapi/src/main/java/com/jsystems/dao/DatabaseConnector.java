package com.jsystems.dao;

import com.jsystems.api.TestUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            initConnection();
        }
        return connection;
    }

    private static void initConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "testuser";
            String pass = "testUser";
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
