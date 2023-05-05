package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.AddStatement;

import java.sql.*;





public class Insertupdateviewdelete 
{
	

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yogeshdatabase","root","Yo9112025449@");
		Statement st=con.createStatement();
//		st.execute("create table user(id int,name varchar(10),email varchar(30),pass int)");

		System.out.println("what opertion you have to do");
		System.out.println("1.insert");
		System.out.println("2.update");
		System.out.println("3.delete");
		System.out.println("4.view");
		System.out.println("5.exit");
		Scanner sc=new Scanner (System.in);
		
		for(;;) {
			int choice=sc.nextInt();
			System.out.println("what opertion you have to do");
			System.out.println("1.insert");
			System.out.println("2.update");
			System.out.println("3.delete");
			System.out.println("4.view");
			System.out.println("5.exit");
			
		    switch(choice) {
		    case 1:
			PreparedStatement ps = con.prepareStatement("insert into user(id,name,email,pass) values(?,?,?,?)");
			System.out.println();
			System.out.println("inset the records");
			System.out.println();
			System.out.println("enter id");
			int id=sc.nextInt();
			System.out.println("enter name");
			String name=sc.next();
			System.out.println("enter email");
			String email=sc.next();
			System.out.println("enter pass");
			int pass=sc.nextInt();
						
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setInt(4, pass);
			ps.execute();
			System.out.println("record inseeted");break;
			
			case 2:
			PreparedStatement ps2=con.prepareStatement("update user set name=? where id=?");
			System.out.println("enter the do you want change name");
			String  name1=sc.next();
			System.out.println("enter the id where do you want to update");
			int id2=sc.nextInt();
			ps2.setString(1, name1);
			ps2.setInt(2, id2);
			ps2.execute();
			System.out.println();
			System.out.println("record updated sucussfully");break;
						
				
		   case 3: PreparedStatement ps1=con.prepareStatement("delete from user where id=?");
		   System.out.println("enter the id to delete record");
		   int id1=sc.nextInt();
		   ps1.setInt(1, id1);
		   ps1.execute();
		   System.out.println("row deleted succefully from the table user from particular entered id"); break;
			
			
		   case 4:
			   try {
				   PreparedStatement ps3=con.prepareStatement("select *  from user where id=?");
			   System.out.println("enter the id");
			   int id3=sc.nextInt();
			   ps3.setInt(1, id3);
			  // ps3.execute();
			   ResultSet rs=ps3.executeQuery();
			   while(rs.next())
			   System.out.println(  "ID : "+rs.getInt(1)+" "+ "NAME :"+rs.getString(2)+" "+"EMAIL :"+rs.getString(3)+" "+"PASS :"+rs.getInt(4));
				   }
				   catch (SQLException e)
				   {
					   System.out.println(e);
				   }
			   
			   
			  
		  case 5:System.exit(0);
			
		}
		}
		
		
		
		

}

	
	}

