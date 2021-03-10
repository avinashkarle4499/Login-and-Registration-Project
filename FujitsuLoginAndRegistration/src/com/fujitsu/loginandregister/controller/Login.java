package com.fujitsu.loginandregister.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fujitsu.loginanAndRegister.DAO.LoginDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginDAO dao=new LoginDAO();
		
		boolean result=dao.verifyUserCredentials(username, password);
		
		if(result){
			System.out.println("if statement executed"+result);
			
			HttpSession session = request.getSession(); 
			 session.setAttribute("user",username); 
			 response.sendRedirect("Welcome.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}
	
	 
	 

}