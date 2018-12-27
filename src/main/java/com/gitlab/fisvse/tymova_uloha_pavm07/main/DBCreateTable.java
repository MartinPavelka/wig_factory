package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCreateTable {
	public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/database.db";
        
        // SQL statement for creating a new table
        String sql = "select * from resources;";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public static void main(String[] args) {
        createNewTable();
    }
}
