package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	public void fetchAllRecord() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch425", "root", "root");
		Statement s = c.createStatement();

		ResultSet rs = s.executeQuery("select * from student");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "     " + rs.getString(3));
		}

		c.close();

	}

	public void insertData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch425", "root", "root");
		Statement s = c.createStatement();
		int check = s.executeUpdate("insert into student(id,name,city)values(127,'mahesh','nagpur')");
		if (check > 0) {
			System.out.println("Data is Inserted.. !");
		} else {
			System.out.println("Data is Not Inserted.. !");
		}
		c.close();
	}

	public void updateData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch425", "root", "root");
		Statement s = c.createStatement();

		int check = s.executeUpdate("update student set name = 'Anshul' where id = 127 ");

		if (check > 0) {
			System.out.println("Data is updated.. !");
		} else {
			System.out.println("Data is Not updated.. !");
		}
		c.close();

	}

	public void deleteData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch425", "root", "root");
		Statement s = c.createStatement();

		int check = s.executeUpdate("delete from student where id = 127");

		if (check > 0) {
			System.out.println("Data is deleted.. !");
		} else {
			System.out.println("Data is Not deleted.. !");
		}

		c.close();

	}
}
