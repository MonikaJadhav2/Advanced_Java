package com.banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankManagement {

    // Create Account
    public static boolean createAccount(String name, int pass) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, pass);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Account Created Successfully!");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    // Login Account
    public static boolean loginAccount(String name, int pass) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful!");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}