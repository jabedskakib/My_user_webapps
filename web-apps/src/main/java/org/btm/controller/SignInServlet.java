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
@WebServlet("/signin")
public class SignInServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long phone = Long.parseLong(req.getParameter("pn"));
		String password = req.getParameter("ps");
		
		UserDao dao = new UserDao();
		User user = dao.verifyUser(phone, password);
		PrintWriter writer = resp.getWriter();
		if(user != null)
		{
			writer.write("<html><body><h1> Id :- "+user.getId()+"<h1>");
			writer.write("<h1> Name :- "+user.getName()+"<h1>");
			writer.write("<h1> Email :- "+user.getEmail()+"<h1>");
			writer.write("<h1> Phone :- "+user.getPhone()+"<h1></html></body>");
		
		}else {
			writer.write("<html><body><h1>Invalid Phone & Password <h1></html></body>");
		}
		
	}

}
