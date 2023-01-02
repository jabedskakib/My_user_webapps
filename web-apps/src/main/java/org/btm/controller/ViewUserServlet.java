package org.btm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btm.dao.UserDao;
import org.btm.dto.User;


@WebServlet("/getall")
public class ViewUserServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//int id = Integer.parseInt(req.getParameter("id"));
		UserDao dao = new UserDao();
		
		List<User> users = dao.getAllUsers();
		PrintWriter writer = resp.getWriter();
		for (User user : users) {
			writer.write("<html><body><h1>Your details</h1>");
			writer.write("<h2>ID:" + user.getId() + "</h2>");
			writer.write("<h2>Name:" + user.getName() + "</h2>");
			writer.write("<h2>Phone:" + user.getPhone() + "</h2>");
			writer.write("<h2>Phone:" + user.getEmail()+ "</h2>");
			writer.write("<h2>------------------</h2></body></html>");
		}
	}

}
