/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBUtils {
     public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String xServer = "localhost";
        String xPort = "1433";
        String xDbName = "FoodManagement";
        //String xUrl = "jdbc:sqlserver://localhost:1433;databaseName = studentDB";
        String xUrl = "jdbc:sqlserver://" + xServer + ":" + xPort + ";databaseName = " + xDbName;
        String xUser = "sa";
        String xPW = "trung123";
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(xUrl, xUser, xPW);
        return conn;
    }

    public static void main(String[] args) {

        String xServer = "localhost";
        String xPort = "1433";
        String xDbName = "FoodManagement";
        String xUrl = "jdbc:sqlserver://localhost:1433;databaseName = UserManagement";
//        String xUrl = "jdbc:sqlserver://" + xServer + ":" + xPort + ";databaseName = " + xDbName;

        String xUser = "sa";
        String xPW = "12345";
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(xUrl, xUser, xPW);
            System.out.println("Connection successful.");
        } catch (Exception e) {
            System.out.println("Connection failed.");
        }

    }
}
