package com.caps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/date")
public class MyFirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstname = req.getParameter("fname");
		String lastname = req.getParameter("lname");
		
//		int i = 7/0;
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>The current Date is: " + new Date() +"</h1>");
		out.println(firstname + " " + lastname );
//		resp.setContentType("application/pdf");
		resp.setContentType("text/html");
		
		
	}
}