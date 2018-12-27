package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSelect {
	/**
	 * Connect to the test.db database
	 * 
	 * @return the Connection object
	 */
	private Connection connect() {
		// SQLite connection string
		String url = "jdbc:sqlite:src/main/resources/database.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * select all rows in the warehouses table
	 */
	public void select(String table) {
		String sql = "SELECT * FROM " + table;

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			if (table.equals("resources")) {
				while (rs.next()) {
					System.out.println(rs.getString("resource_type") + "\t" + rs.getInt("amount") + "\t"
							+ rs.getString("resource_id"));
				}
			}

			if (table.equals("events")) {
				while (rs.next()) {
					System.out.println(rs.getString("event_id") + "\t" + rs.getInt("event_type") + "\t"
							+ rs.getFloat("cost") + "\t" + rs.getString("madeFor") + "\t" + rs.getString("madeBy"));
				}
			}
			if (table.equals("hair")) {
				while (rs.next()) {
					System.out.println(rs.getString("hair_id") + "\t" + rs.getString("hair_type") + "\t"
							+ rs.getString("donor") + "\t" + rs.getInt("length"));
				}
			}
			if (table.equals("donations")) {
				while (rs.next()) {
					System.out.println(rs.getString("donation_id") + "\t" + rs.getString("donation_type") + "\t"
							+ rs.getFloat("amount") + "\t" + rs.getString("donor") + "\t" + rs.getString("hair_id"));
				}
			}
			if (table.equals("users")) {
				while (rs.next()) {
					System.out.println(rs.getString("user_id") + "\t" + rs.getString("username") + "\t"
							+ rs.getString("password") + "\t" + rs.getString("user_type") + "\t" + rs.getString("jmeno")
							+ "\t" + rs.getString("prijmeni") + "\t" + rs.getString("Rod_cis") + "\t"
							+ rs.getString("adresa") + "\t" + rs.getString("nazevSpol") + "\t" + rs.getInt("IC") + "\t"
							+ rs.getString("telefon"));
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		DBSelect app = new DBSelect();
		app.select("resources");
	}
}
