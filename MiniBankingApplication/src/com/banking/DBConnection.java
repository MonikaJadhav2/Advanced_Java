package com.banking;

import java.sql.DriverManager;

public class DBConnection {
    static java.sql.Connection con;

    public static java.sql.Connection getConnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/BANK";
            String user = "root";
            String pass = "root";

            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            System.out.println("Connection Failed! " + e.getMessage());
        }
        return con;
    }
}