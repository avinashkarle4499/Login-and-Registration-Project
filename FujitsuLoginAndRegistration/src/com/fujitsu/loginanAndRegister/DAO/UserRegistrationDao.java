package com.fujitsu.loginanAndRegister.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.fujitsu.loginanAndRegister.model.User;

public class UserRegistrationDao {

	public boolean registeruser(User user)
	{
		System.out.println("Start of  UserRegistrationDAO::registeruser");
		
		String url="jdbc:mysql://localhost:3306/advjava";
		String db_username="root";
		String db_password="Avinash@4499";
		
		Connection con;
		PreparedStatement pstmt;
		
		String sql="insert into user values(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,db_username,db_password);
		
			pstmt=con.prepareStatement(sql);
			
			
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, user.getPhone());
			pstmt.setString(5, user.getAddress());
			
			int result=pstmt.executeUpdate();
			
			if(result>0)
				return true;
					}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Start of  UserRegistrationDAO::registeruser");
		return false;
	}

}
