package com.caps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
//import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req")
public class RequestExample extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String url = req.getRequestURL().toString();
		out.println("Url: " + url);
		
		String data = req.getParameter("data");
		out.println("Data: " + data);
		
		String[] langs = req.getParameterValues("langs");
		out.println(Arrays.toString(langs));
		
		String httpMethod = req.getMethod();
		out.println("HTTP Method: " + httpMethod);
	}
}