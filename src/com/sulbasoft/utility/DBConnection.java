/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sulbasoft.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author M. S. Ali (CCS)
 */
public class DBConnection {
    private static Connection connection = null;

    private DBConnection() {
    }

    public static synchronized Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            String url = "jdbc:mysql://localhost:3306/sms";
            String uname = "root";
            String password = "root";
            try {
                connection = DriverManager.getConnection(url, uname, password);
            } catch (SQLException e) {
                System.out.println("Cannot create connection: " + e.toString());
            }
        }

        return connection;
    }

    public static synchronized void closeConnection() {
        if (connection != null) {
            connection = null;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Cannot close connection" + e.toString());
        } finally {
            connection = null;
        }
    }
}
