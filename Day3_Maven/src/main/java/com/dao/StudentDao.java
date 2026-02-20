package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	public void fetchAllRecord() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch425", "root", "root");

		PreparedStatement ps = c.prepareStatement("select * from student where id = ?");

		// for single Fetching
//		PreparedStatement ps = c.prepareStatement("select * from student where id = ?");
//		ps.setInt(1, 125);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "     " + rs.getString(3));
		}
		c.close();

	}

	public void insertData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch425", "root", "root");

//		Statement s = c.createStatement();
//		int check = s.executeUpdate("insert into student(id,name,city)values(129,'priya','nagpur')");

		PreparedStatement ps = c.prepareStatement("insert into student(id,name,city)values(?,?,?)");
		ps.setInt(1, 143);
		ps.setString(2, "raj");
		ps.setString(3, "NSK");

		int check = ps.executeUpdate();

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

		PreparedStatement ps = c.prepareStatement("update student set name = ?, city = ? where id = ?");
		ps.setString(1, "ganesh");
		ps.setString(2, "GOA");
		ps.setInt(3, 125);

		int check = ps.executeUpdate();
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

		PreparedStatement ps = c.prepareStatement("delete from student where id =?");
		ps.setInt(1, 126);
		int check = ps.executeUpdate();
		if (check > 0) {
			System.out.println("Data is deleted.. !");
		} else {
			System.out.println("Data is Not deleted.. !");
		}

		c.close();

	}

	public void dropData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch425", "root", "root");

		Statement s = c.createStatement();
		boolean check = s.execute("drop table student");
		
		if (check == true) {
			System.out.println("table drop successfully .. !");
		} else {
			System.out.println("table drop Failed  .. !");
		}

		c.close();

	}
}