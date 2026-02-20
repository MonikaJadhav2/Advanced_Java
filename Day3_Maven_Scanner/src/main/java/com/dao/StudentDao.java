package com.dao;

import java.sql.*;

public class StudentDao {

	Connection c;

	public StudentDao() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/batch425",
				"root",
				"root");
	}

	public void insertData(int id, String name, String city) throws Exception {

		PreparedStatement ps = c.prepareStatement(
				"insert into student(id,name,city) values(?,?,?)");

		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, city);

		int check = ps.executeUpdate();

		if (check > 0)
			System.out.println("✅ Data Inserted");
		else
			System.out.println("❌ Insert Failed");
	}

	public void updateData(int id, String name, String city) throws Exception {

		PreparedStatement ps = c.prepareStatement(
				"update student set name=?, city=? where id=?");

		ps.setString(1, name);
		ps.setString(2, city);
		ps.setInt(3, id);

		int check = ps.executeUpdate();

		if (check > 0)
			System.out.println("✅ Data Updated");
		else
			System.out.println("❌ Update Failed");
	}

	public void deleteData(int id) throws Exception {

		PreparedStatement ps = c.prepareStatement(
				"delete from student where id=?");

		ps.setInt(1, id);

		int check = ps.executeUpdate();

		if (check > 0)
			System.out.println("✅ Data Deleted");
		else
			System.out.println("❌ Delete Failed");
	}

	public void fetchAllRecord() throws Exception {

		PreparedStatement ps = c.prepareStatement("select * from student");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " | "
					+ rs.getString(2) + " | "
					+ rs.getString(3));
		}
	}

	public void dropData() throws Exception {

		Statement s = c.createStatement();
		s.executeUpdate("drop table student");

		System.out.println("⚠ Table Dropped Successfully");
	}
}