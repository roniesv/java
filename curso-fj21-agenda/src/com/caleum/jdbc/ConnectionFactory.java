package com.caleum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21?useTimezonetrue&serverTimezone=UTC", "root", "admin");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
