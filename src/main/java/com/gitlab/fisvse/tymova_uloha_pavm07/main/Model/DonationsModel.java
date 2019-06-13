package com.gitlab.fisvse.tymova_uloha_pavm07.main.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Donation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DonationsModel extends Model {
	public static final String TABLE = "Donations";
	
	public boolean addDonation(int userId, int amountMoney, int amountHair) {
		String sql = "INSERT INTO " + TABLE + "(userId,amount,hair,created) VALUES(?,?,?,?);";	
		
		long unixTime = System.currentTimeMillis() / 1000L;
		
		try (	Connection conn = DriverManager.getConnection(Database.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, userId);
			pstmt.setInt(2, amountMoney);
			pstmt.setInt(3, amountHair);
			pstmt.setLong(4, unixTime);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public ObservableList<Donation> getDonationsFromUser(int userId) {
		String sql = "SELECT id,userId,amount,hair,created FROM " + TABLE + " WHERE userId = ?;";	

		ObservableList<Donation> donationsList = FXCollections.observableArrayList();
		
		try (Connection conn = DriverManager.getConnection(Database.url);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Donation d = new Donation(
						rs.getInt("id"),
						rs.getInt("userid"),
						rs.getInt("amount"),
						rs.getInt("hair"),
						rs.getInt("created")
				);
				donationsList.add(d);
			}
			return donationsList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return null;
	}
}
