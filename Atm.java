package com.atm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;
public class Atm {

	public static void main(String[] args) {
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM","root","");
			Statement st=con.createStatement();
			Scanner s=new Scanner(System.in);
			System.out.println("welcome to the ATM app");
			System.out.println("Enter your account pin number :");
			int pin=s.nextInt();
			
			ResultSet set=st.executeQuery("select* from atmdatabase where acc_num="+pin);
			
			
			int balance=0;
			String name="null";
			int count=0;
			while(set.next())
			{
				name=set.getString(3);
				balance=set.getInt(4);
				count++;
				
				
			}
			int choice;
			int amount=0;
			
			int withdraw_amount=0;
			
			if(count>0)
			{
				System.out.println();
			
				System.out.println("Hello" +name);
				while(true) {
					
					System.out.println("press 1 to check balance");
					System.out.println("press 2 to add balance");
					System.out.println("press 3 to withdraw amount");
					System.out.println("press 4 to print the recipt");
					System.out.println("press 5 to exit");
					
					System.out.println();
					System.out.println("Enter your choice :");
					
					choice=s.nextInt();
					
					switch(choice) {
					
					case 1:
						System.out.println("Your current balance is :"+balance);
						break;
						
					case 2:
						System.out.println("Enter the amount you want to deposit: ");
						amount=s.nextInt();
						balance=balance+amount;
						
						int bal=st.executeUpdate("UPDATE atmdatabase SET balance= "+balance+" WHERE acc_num="+pin);
						System.out.println("The amount is successfully added and your current balance is:"+balance);
					break;
					
					case 3:
						
					System.out.println("Enter the amount you want to withdraw:"+amount);
					withdraw_amount=s.nextInt();
					if(withdraw_amount>balance)
					{
						System.out.println("Insufficient balance........!!!");
					}else
					{
					balance=balance-withdraw_amount;
					int sub=st.executeUpdate("UPDATE atmdatabase SET balance= "+balance+" WHERE acc_num= "+pin);
					System.out.println("After withdrawing you currrent balance is :"+balance);
					}
					break;
					case 4:
						System.out.println("thanks for using this app");
						System.out.println("your current balance is:"+balance);
						System.out.println("Added amount:" +amount);
						System.out.println("withdraw amount: "+withdraw_amount);
					break;
					}
					if(choice==5)
						break;
				}
			}else
			{
				System.out.println("wrong pin.....");
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
