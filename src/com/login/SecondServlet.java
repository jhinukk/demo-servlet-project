package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			res.setContentType("text/html");
			PrintWriter printout = res.getWriter();
			HttpSession session = req.getSession(false);
			String name = (String)session.getAttribute("username");
			String password =(String)session.getAttribute("password");
			
			printout.print("Name = "+name+" Password= "+password);
			printout.close();
		}
		catch(Exception exps) {
			System.out.println(exps);
		}
	}

}
