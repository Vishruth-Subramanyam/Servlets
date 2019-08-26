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
@WebServlet("/CreateServ")
public class CreateServ extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("user_id");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String password = req.getParameter("passwd");
		System.out.println(uid);
		System.out.println(password);
		System.out.println(fname);
		System.out.println(lname);
		UserServices services = new UserServicesImpl();
		 User User =null;
		Boolean user = services.createProfile(User);
		PrintWriter out = resp.getWriter();
		//System.out.println(User);
		if(user!=null) {
			out.println("<h1> Creation successful<h1>");
			out.println(uid);
			out.println(fname);
			out.println(lname);
			out.println(password);
		}else {
			out.println("<h1> Creation failed<h1>");
		}
		
	}
}
