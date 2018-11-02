package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection;
	public static Connection getConnection()
	{
		try {
			if(connection == null|| connection.isClosed())
			{
				new DBConnection();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public DBConnection()
	{
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String userName="sqlserveruser1";
		String password="amina04";
		String url="jdbc:sqlserver://USER-PC\\SQLEXPRESS"+";databaseName=foodsystem1";
		
			connection=DriverManager.getConnection(url,userName,password);
		}
		catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex);
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
