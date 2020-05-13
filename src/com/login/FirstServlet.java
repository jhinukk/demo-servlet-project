package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		 try { res.setContentType("text/html");
		  
		 String name =req.getParameter("username"); 
		 String password =req.getParameter("password"); 
		 
		 PrintWriter printout = res.getWriter();
		  printout.print("Name is "+name); 
		  printout.print("Password is "+password);
		 
		  HttpSession session = req.getSession(); 
		  session.setAttribute("username",name); 
		  session.setAttribute("password", password);
		 
		 printout.print("<a href='welcome'>view details</a>"); 
		 printout.close();
		 
		 RequestDispatcher rq = req.getRequestDispatcher("/welcome");
		 	rq.include(req,res); 
		 	} 
		 catch(Exception exp) { 
			 System.out.println(exp); 
			 }
		 
		/*
		 * System.out.println("Username is "+req.getParameter("username"));
		 * System.out.println("Password is "+req.getParameter("password"));
		 */
	}
}
