package com.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Connertionestablish 
{
	

public static void main(String[]args)throws ClassNotFoundException, SQLException  {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Yo9112025449@");
	Statement st=conn.createStatement();
	System.out.println("enter the choice");
	System.out.println(); 
	System.out.println("1.create table\n2.inset date\n3.delete row\n4.drop table\n5.fetch data\n6.fetch single row");
	Scanner sc=new Scanner(System.in);
	Scanner ch=new Scanner (System.in);
	int choice=ch.nextInt();
	

	switch(choice)
	{

	
	case 1:
		{
//			    st.execute("create table yogesh6 (id int,name varchar(10))");
	            System.out.println("table created sucssefilyyy");
		}break;
	case 2:{	PreparedStatement ps=conn.prepareStatement("insert into yogesh6 values(?,?)");
	            System.out.println("enter the id");
	             int id=sc.nextInt();
            	System.out.println("enter the name");
                  	String name=sc.next();
	                  ps.setInt(1, id);
	                  ps.setString(2, name);
	                  ps.execute();
	                  System.out.println("values insert dynamically");
	}break;
	
	
	case 3:{
	                 	PreparedStatement ps1=conn.prepareStatement("delete from yogesh6 where id=?");
	                 	System.out.println("enter the id");
		                 int id2=sc.nextInt();
	                  	ps1.setInt(1, id2);
		                ps1.execute();
		               System.out.println("row deleted");
	}break;
	
	case 4:{
		st.execute("drop table yogesh6");
		System.out.println("done drop");
	}break;

	
	
	
	case 5:{	ResultSet rs=st.executeQuery("select * from yogesh6");
             while(rs.next())
	{
	int id=rs.getInt(1);
		String name=rs.getString(2);
		System.out.println("id : " + id +"  name "+name);
	} 
	}break;
	
             case 6:{	
            	 PreparedStatement ps=conn.prepareStatement("select * from yogesh6 where id=?");
	System.out.println("enter the id");
	
	int id=sc.nextInt();
        ps.setInt(1, id);
	ResultSet rs1=ps.executeQuery();
	while(rs1.next())
	{
		int id1=rs1.getInt(1);
		String name1=rs1.getString(2);
		System.out.println("id : "+id1  +"name :" +name1);
	}
	

	}break;
	default :{
		System.out.println("enter valid option");
	}
	}
	
}
}

	



