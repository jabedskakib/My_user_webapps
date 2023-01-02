package org.btm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btm.dao.UserDao;
import org.btm.dto.User;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nm");
		long phone = Long.parseLong(req.getParameter("ph"));
		String email = req.getParameter("em");
		String password = req.getParameter("ps");
		
		User user = new User();
		user.setName(name);
		user.setPhone(phone);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDao dao = new UserDao();
		user = dao.saveUser(user);
		System.out.println("User save with Id : "+user.getId());
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body><h1>User Saved Succesfully</h1></body></html>");
	}

	
}
