package com.caps.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.dev.beans.User;
import com.dev.services.UserServices;
import com.dev.services.UserServicesImpl;
@WebServlet("/search")
public class SearchServ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("user_id");
		UserServices services = new UserServicesImpl();
		User User = null;
		User user = services.searchUser(Integer.parseInt(uid)); 
		
		if(user != null) {
			//out.println("<h1> Search successful");
			
		}else {
			
		}
		
	}
}
