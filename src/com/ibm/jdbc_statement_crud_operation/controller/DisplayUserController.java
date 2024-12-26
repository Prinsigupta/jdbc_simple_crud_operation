package com.ibm.jdbc_statement_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayUserController {
public static void main(String[] args) {
	Connection connection=null;
	 try {
		//step-1 load/register driver class from driver software
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 //step-2 create connection with url,user,password
		 String url = "jdbc:mysql://localhost:3306/jdbc-a5";
		 String username ="root";
		 String password = "root";
		  connection = DriverManager.getConnection(url,username,password);
		 //step-3 create statement
		 Statement statement = connection.createStatement();
//	 System.out.println(statement);
//		 System.out.println(connection);
		 //step-4 execute Query
		 
		 String display = "select * from user";
		 ResultSet set = statement.executeQuery(display);
		 
		 while(set.next()) {
         int id = set.getInt("id");
         System.out.println("id = "+id);
         
         String name = set.getString("name");
         System.out.println("name is :"+name);
         
         String  dob = set.getString("dob");
         System.out.println("dob is :"+dob);
         
         String email = set.getString("email");
         System.out.println("email is:"+email);
         
         int phoneNo = set.getInt("phoneNo");
         System.out.println("phoneNo is :"+phoneNo);
		 }	
	
	 }
	 
	 catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	 }finally {
		//step-5 close the connection
		 try {
			connection.close();
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
}
