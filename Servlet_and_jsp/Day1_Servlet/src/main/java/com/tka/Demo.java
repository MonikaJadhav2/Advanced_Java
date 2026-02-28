package com.tka;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submit")
public class Demo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");

		System.out.println(name);
		System.out.println(email);
		System.out.println(dob);

		PrintWriter out = response.getWriter();
		out.print(name);
		out.print(email);
		out.print(dob);

	}

}