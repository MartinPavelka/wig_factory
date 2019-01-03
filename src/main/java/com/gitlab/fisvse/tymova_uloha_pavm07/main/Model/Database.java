package com.gitlab.fisvse.tymova_uloha_pavm07.main.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Connection conn;
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void connect(String url) {
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
