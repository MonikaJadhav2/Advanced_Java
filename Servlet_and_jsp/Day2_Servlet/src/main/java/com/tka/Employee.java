package com.tka;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submit")
public class Employee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String id = request.getParameter("empId");
		int empID = Integer.parseInt(id);

		String name = request.getParameter("empName");
		String city = request.getParameter("empCity");
		String email = request.getParameter("empEmail");

		String sal = request.getParameter("empSalary");
		double salary = Double.parseDouble(sal);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch425", "root", "root");
			PreparedStatement ps = c
					.prepareStatement("insert into employee(empID,name,city,email,salary)values(?,?,?,?,?)");
			ps.setInt(1, empID);
			ps.setString(2, name);
			ps.setString(3, city);
			ps.setString(4, email);
			ps.setDouble(5, salary);

			int check = ps.executeUpdate();
			if (check > 0) {
				out.println("<h1 style ='color:green'>Data is Inserted.. !</h1>");
			} else {
				out.println("<h1 style ='color:red'>Data is  Not Inserted.. !</h1>");
			}
			c.close();
		} catch (Exception e) {
			out.println("<h1 style ='color:red'>" + e.getMessage() + "</h1>");
		}

	}

}