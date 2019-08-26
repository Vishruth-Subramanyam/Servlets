package com.caps.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.beans.User;
import com.dev.services.UserServices;
import com.dev.services.UserServicesImpl;

@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("user_id");
		String password = req.getParameter("passwd");
		System.out.println(uid);
		System.out.println(password);
		UserServices services = new UserServicesImpl();
		User user = services.login(Integer.parseInt(uid), password);
		PrintWriter out = resp.getWriter();
		System.out.println(user);
		if(user != null) {
			out.println("<h1> login successful<h1>");
			out.println("<h2>"+user+"<h2>");
		}else {
			out.println("<h1> login failed<h1>");
		}
		
		
	}
}