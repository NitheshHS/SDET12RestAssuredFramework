package com.rmg.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author Nitheesha
 *
 */
public class DatabaseUtility {
	private Connection connection;
	/**
	 * Get connetion to the database
	 * @throws Throwable
	 */
	public void getConnection() throws Throwable {

		Driver regDriver = new Driver();
		DriverManager.registerDriver(regDriver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}

	/**
	 * Execute a query to get result
	 * @param query
	 * @param columnLabel
	 * @param expectedData
	 * @return Value
	 * @throws Throwable
	 */
	public String exceuteQuery(String query,String columnLabel,String expectedData) throws Throwable {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			if(result.getNString(columnLabel).equals(expectedData)) {
				return expectedData;
			}

		}
		return "Expected Data is not matching with any data in database!!!";
	}

	public ArrayList<Object> executeQuery(String query,String columnLabel) throws Throwable {
		ArrayList<Object> list=new ArrayList<Object>();
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			list.add(result.getString(columnLabel));
		}
		return list;
	}

			/**
			 * Close the DB connection
			 * @throws SQLException
			 */
			public void closeDBConnection() throws SQLException {
			connection.close();
		}
	}
