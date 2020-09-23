package com.caleum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21?useTimezonetrue&serverTimezone=UTC", "root", "admin1");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
