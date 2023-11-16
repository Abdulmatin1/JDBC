package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

	public static void main(String[] args) throws SQLException {

		// url username password database
		// connection
		Connection myConnectoin = DriverManager.getConnection("jdbc:mysql://localhost:3306/testapi", "username",
				"password");
		// statment

		Statement myStatment = myConnectoin.createStatement();
		// query
		// we insert data to database
		String insertQuery = "INSERT INTO `testapi`.`student` (`id`, `firstname`, `lastname`, `grade`, `marks`, `school`) VALUES ('4', 'Sahar', 'Faramarz', '12', '80', 'goerge Mason')";

		myStatment.execute(insertQuery);

		// update query
		// String updateQuery = "UPDATE `testapi`.`student` SET `lastname` = 'Karimi',
		// `marks` = '95' WHERE (`id` = '2')";

		// myStatment.execute(updateQuery);

		// String deletQuer = "DELETE FROM `testapi`.`student` WHERE (`id` = '2')";

		// myStatment.execute(deletQuer);

		// select query

		String selectQuery = "SELECT id, firstname, lastname, grade, marks, school FROM student";

		ResultSet rs = myStatment.executeQuery(selectQuery);

		while (rs.next()) {
			int id = rs.getInt("id");
			String fname = rs.getString("firstname");
			String lname = rs.getString("lastname");
			int grade = rs.getInt("grade");
			int marks = rs.getInt("marks");
			String school = rs.getString("school");

			System.out.println(" ID: " + id + " FirstName:  " + fname + " LastName: " + lname + " " + " Grade: " + grade
					+ " Mark: " + marks + " School: " + school);

		}

		System.out.println("=========================================\n");

		System.out.println("connection successfully ");
		System.out.println("all the records pulled");

		// excute

	}

}
