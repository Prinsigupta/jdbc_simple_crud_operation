package com.ibm.jdbc_statement_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertUserController {
	public static void main(String[] args) {
		Connection connection=null;
		 try {
			//step-1 load driver class from driver software
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 //step-2 create connection with url,user,password
			 String url = "jdbc:mysql://localhost:3306/jdbc-a5";
			 String username ="root";
			 String password = "root";
			  connection = DriverManager.getConnection(url,username,password);
			 //step-3 create statement
			 Statement statement = connection.createStatement();
//		 System.out.println(statement);
//			 System.out.println(connection);
			 //step-4 execute Query
			 
			 String insertUserQuery = "insert into user(id) values(554,'karan','1997-07-31','Karan@1323.com',188456678)";
			 int a = statement.executeUpdate(insertUserQuery);
//			 System.out.println(a);
			 if(a!=0) {
				 System.out.println("Data-Stored!!!!!!");
		 }
		 else {
			System.out.println("Data not stored!!!!");
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