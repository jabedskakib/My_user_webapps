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
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		UserDao dao = new UserDao();
		User user = dao.getUser(id);
		PrintWriter writer = resp.getWriter();
		if (user != null) {
			new UserDao().deleteUser(id);
			writer.write("<html><body><h1>User deleted </h1></body></html>");
		} else {
			writer.write("<html><body><h1>User Not found </h1></body></html>");
		}
	}

}
