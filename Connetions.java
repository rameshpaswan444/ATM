package com.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connetions {

	static Connection con;
	public static Connection createC() {
		
	
		
		try {
			
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			
			String user="root";
			String password="";
			String url="jdbc:mysql://localhost:3306/studentm";
			
			con=DriverManager.getConnection(url, user, password);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}
}
