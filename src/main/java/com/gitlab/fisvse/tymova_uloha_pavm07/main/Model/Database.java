package com.gitlab.fisvse.tymova_uloha_pavm07.main.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Connection conn;
	private static String url;
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(Database.url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void init(String url) {
		Database.url = url;
		
	}
}
