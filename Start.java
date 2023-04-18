package com.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
System.out.println("hello");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
while(true)
{
	System.out.println("PRESS 1 to ADD student");
	System.out.println("Press 2 to Delete student");
	System.out.println("Press 3 to Display student");
	System.out.println("Press 4 to exit app");
	
	int c= Integer.parseInt(br.readLine());
	
	if(c==1)
	{
		//add student
		System.out.println("enter the user name :");
		String name=br.readLine();
		
		System.out.println("enter the user phone");
		String phone=br.readLine();
		
		System.out.println("enter the user city");
		String city=br.readLine();
		
		Student st=new Student(name, phone, city);
		
	boolean result=	StudentDao.insertStudentToDB(st);
	
	if(result)
	{
		System.out.println("student successfull added....");
	}else {
		System.out.println("Something went wrong try again.....!!");
	}
	
	}else if(c==2)
	{
		//delete student
		System.out.println("Enter the student id to delete the student......");
		int userId=Integer.parseInt(br.readLine());
		boolean f=StudentDao.deleteStudent(userId);
		
		if(f)
		{
			System.out.println("student deleted sucessfully......");
		}else
		{
			System.out.println("Something went wrong.....!!");
		}
	}else if(c==3)
	{
		//display student
		StudentDao.showAllStudnet();
		
	}else if(c==4)
	
	{
		//exit
		break;
		
	}else
	{
	
}
	}
System.out.println("Thanks for using my app");

}
}

