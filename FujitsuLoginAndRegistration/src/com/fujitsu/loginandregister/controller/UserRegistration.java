package com.fujitsu.loginandregister.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fujitsu.loginanAndRegister.DAO.UserRegistrationDao;
import com.fujitsu.loginanAndRegister.model.User;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/userRegistration")
public class UserRegistration extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//object of dao class
		UserRegistrationDao dao;
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int phone=Integer.parseInt(request.getParameter("phone"));
		String address=request.getParameter("address");
		
		
		//generating random numbers for userId
		Random random=new Random();
		int userId=random.nextInt(999);
		
		
		User newUser=new User(userId,username,password,phone,address);
		
		//save user details in database
		dao = new UserRegistrationDao();
		boolean result=dao.registeruser(newUser);
		
		if(result) {
			System.out.println("User Registred Successfully");
			response.sendRedirect("Welcome.jsp");
		}
		else
			System.err.println("Internal server Error");
			response.sendRedirect("error.jsp");
	}

}
