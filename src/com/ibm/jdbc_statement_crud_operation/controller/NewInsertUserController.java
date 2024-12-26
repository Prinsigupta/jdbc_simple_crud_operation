package com.ibm.jdbc_statement_crud_operation.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.mysql.cj.jdbc.Driver;

public class NewInsertUserController {
	public static void main(String[] args) {

		Connection connection = null;
		// step-1 Register the Driver class

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// step-2 Create Connection

			String url = "jdbc:mysql://localhost:3306/jdbc-a5";
			String username = "root";
			String password = "root";

			connection = DriverManager.getConnection(url, username, password);

			// step-3 create Statement

			Statement statement = connection.createStatement();

			// Step-4 Execute Query
			
			// insert query

//			String insertValue = "insert into user(id) values(0)";
//				int a = statement.executeUpdate(insertValue);
//				if (a!=0) {
//					System.out.println("data inserted");
//				}
//				else {
//					System.out.println("data not Inserted");
//				}
//			
//				
//				// Display values
//				
//				String display = "SELECT * FROM user WHERE id=1";
//				ResultSet set = statement.executeQuery(display);
//				set.next();
//				
//				int id = set.getInt("id");
//				System.out.println("id = "+id);
//				=======================================================================
			
			String displaySingleData = "SELECT * FROM user WHERE id=554";
			ResultSet set = statement.executeQuery(displaySingleData);
//		    String id = set.getString("id");
//		    String name = set.getString("name");
			Date date = set.getDate("dob");
			LocalDate d= date.toLocalDate();
			System.out.println(d);
//				
//				// Update values in database
//				
//				 String update = "update user set dob='2003-11-11' where id= 556";
//				 int b = statement.executeUpdate(update);
//					if (a != 0) {
//						System.out.println("data updated");
//					} else {
//						System.out.println("Data not updated");
//					}
//					
//					
//			// Delete the values from Database
//
//			String delete = "delete FROM user WHERE id=999";
//			int c = statement.executeUpdate(delete);
//
//			if (c != 0) {
//				System.out.println("given id data is deleted");
//			} else {
//				System.out.println("given id data is not deleted");
//			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}

// This is a code to perform CRUD operation in DATABASE but here we have perform all CRUD operation so it will give error , we execute one by one as per requirment.
