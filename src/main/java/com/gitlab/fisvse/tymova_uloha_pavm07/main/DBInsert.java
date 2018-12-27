package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBInsert {

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
	 * Insert a new row into table donations
	 *
	 * @param donation_id, donation_type, amount, donor, hair_id 
	 */
	public void insertDonations(String donation_id,String donation_type,float amount,String donor,String hair_id) {
		String sql = "INSERT INTO donations(donation_id,donation_type,amount,donor,hair_id) VALUES(?,?,?,?,?)";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, donation_id);
			pstmt.setString(2, donation_type);
			pstmt.setFloat(3, amount);
			pstmt.setString(4, donor);
			pstmt.setString(5, hair_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Insert a new row into table events
	 *
	 * @param event_id, event_type, cost, madeFor, madeBy
	 */
	public void insertEvent(String event_id,String event_type,float cost,String madeFor,String madeBy) {
		String sql = "INSERT INTO events(event_id,event_type,cost,madeFor,madeBy) VALUES(?,?,?,?,?)";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, event_id);
			pstmt.setString(2, event_type);
			pstmt.setFloat(3, cost);
			pstmt.setString(4, madeFor);
			pstmt.setString(5, madeBy);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Insert a new row into table hair
	 *
	 * @param hair_id, hair_type, donor, length
	 */
	public void insertHair(String hair_id,String hair_type,String donor,int length) {
		String sql = "INSERT INTO hair(hair_id,hair_type,donor,length) VALUES(?,?,?,?)";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, hair_id);
			pstmt.setString(2, hair_type);
			pstmt.setString(3, donor);
			pstmt.setInt(4, length);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Insert a new row into table resources
	 *
	 * @param resource_type, amount, resource_id
	 */
	public void insertResources(String resource_type,float amount,String resource_id) {
		String sql = "INSERT INTO resources(resource_type,amount,resource_id) VALUES(?,?,?)";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, resource_type);
			pstmt.setFloat(2, amount);
			pstmt.setString(3, resource_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Insert a new row into table users
	 *
	 * @param user_id, username, password, user_type, jmeno, prijmeni, Rod_cis, adresa, nazevSpol, IC, telefon
	 */
	public void insertUser(String user_id,String username,String password,String user_type,String jmeno,String prijmeni,String Rod_cis,String adresa,String nazevSpol,int IC,String telefon) {
		String sql = "INSERT INTO users(user_id,username,password,user_type,jmeno,prijmeni,Rod_cis,adresa,nazevSpol,IC,telefon) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user_id);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.setString(4, user_type);
			pstmt.setString(5, jmeno);
			pstmt.setString(6, prijmeni);
			pstmt.setString(7, Rod_cis);
			pstmt.setString(8, adresa);
			pstmt.setString(9, nazevSpol);
			pstmt.setInt(10, IC);
			pstmt.setString(11, telefon);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		DBInsert app = new DBInsert();
		// insert three new rows
		app.insertDonations(null, null, 0, null, null);
		app.insertEvent(null, null, 0, null, null);
		app.insertHair(null, null, null, 0);
		app.insertResources(null, 0, null);
		app.insertUser(null, null, null, null, null, null, null, null, null, 0, null);
	}

}