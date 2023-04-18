package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	
	
	public static boolean insertStudentToDB(Student st)
	{
		boolean f=false;
		try {
			
			Connection con=Connetions.createC();
			String q="insert into student(sid,sname,sphone,scity) values(?,?,?,?)";
			
		PreparedStatement p=con.prepareStatement(q);
		p.setInt(1, st.getStudentId());
			p.setString(2, st.getStudentName());
			p.setString(3, st.getStudentPhone());
			p.setString(4, st.getStudentCity());
			
			p.executeUpdate();
			f=true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userId) {
		
		boolean f=false;
		try {
			
			Connection con=Connetions.createC();
			String q="delete from student where sid=?";
			
		PreparedStatement p=con.prepareStatement(q);
		p.setInt(1, userId);
			
			p.executeUpdate();
			f=true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}

	public static void showAllStudnet() {
		
		boolean f=false;
		try {
			
			Connection con=Connetions.createC();
			String q="select* from student";
			
		PreparedStatement p=con.prepareStatement(q);
		Statement st=con.createStatement();
		ResultSet set=st.executeQuery(q);
		
		while(set.next())
		{
			int id=set.getInt(1);
					
			String name=set.getString(2);
			String phone=set.getString(3);
			String city=set.getString(4);
			
			System.out.println("id:"+id );
			System.out.println("name: "+name);
			System.out.println("phone: "+phone);
			System.out.println("city: "+city);
			System.out.println("===============================================");
			
		}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}
