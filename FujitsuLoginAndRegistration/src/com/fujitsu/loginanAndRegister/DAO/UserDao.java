package com.fujitsu.loginanAndRegister.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class UserDao
{
	public ResultSet getDetails() 
	{
		String url="jdbc:mysql://localhost:3306/advjava";
		String db_username="root";
		String db_password="Avinash@4499";
		
		Connection con;
		PreparedStatement pstmt;
		
		String sql="select * from user";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,db_username,db_password);
			
			
			pstmt=con.prepareStatement(sql);
			
			
			ResultSet rs=pstmt.executeQuery();
			
			
				return rs;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
}
