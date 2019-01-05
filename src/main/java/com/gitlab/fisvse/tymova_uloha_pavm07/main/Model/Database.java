package com.gitlab.fisvse.tymova_uloha_pavm07.main.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Connection conn;
	public static final String url = "jdbc:sqlite:src/main/resources/wigs.db";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(Database.url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
