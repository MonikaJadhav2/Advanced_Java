package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded...!");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch425","root", "root");

//		System.out.println("Connection Done.....!");
		
		Statement s = c.createStatement();
		s.executeUpdate("insert into student(id,name,city) values (123, 'om', 'pune')");
		
		System.out.println("Data is Inserted...!");
		
		c.close();
	}
}