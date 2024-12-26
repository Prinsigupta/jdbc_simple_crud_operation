package com.ibm.jdbc_statement_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateUserController {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			// step-1 load/register driver class from driver software
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step-2 create connection with url,user,password
			String url = "jdbc:mysql://localhost:3306/jdbc-a5";
			String username = "root";
			String password = "root";
			connection = DriverManager.getConnection(url, username, password);

			// step-3 create statement
			Statement statement = connection.createStatement();

			// step-4 execute Query

			String update = "update user set dob='2003-11-11' where id= 123";

			int a = statement.executeUpdate(update);
			if (a != 0) {
				System.out.println("data updated");
			} else {
				System.out.println("Data not updated");
			}
		}

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			// step-5 close the connection
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
