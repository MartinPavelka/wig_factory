package com.gitlab.fisvse.tymova_uloha_pavm07.main.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Donation;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IntkeyvalModel extends Model {
	public static final String TABLE = "Intkeyval";
	
	public void init() {
		delete();
		insert("money", 0);
		insert("hair", 0);
		System.out.println("done");
	}
	
	public boolean delete() {
		String sql = "DELETE FROM " + TABLE + ";";
		try (
				Connection conn = DriverManager.getConnection(Database.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)
			) {
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public Integer get(String key) {
		String sql = "SELECT key,value FROM " + TABLE + " WHERE key = ?;";
	
		try (
			Connection conn = DriverManager.getConnection(Database.url);
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setString(1, key);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next())
				return null;
			return rs.getInt("value");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public boolean set(String key, Integer value) {
		String sql = "UPDATE " + TABLE + " SET value = ? WHERE key = ?;";		
	
		try (
			Connection conn = DriverManager.getConnection(Database.url);
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setInt(1, value);
			pstmt.setString(2, key);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean add(String key, Integer value) {
		String sql = "UPDATE " + TABLE + " SET value = value + ? WHERE key = ?;";		
	
		try (
			Connection conn = DriverManager.getConnection(Database.url);
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setInt(1, value);
			pstmt.setString(2, key);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean substract(String key, Integer value) {
		String sql = "UPDATE " + TABLE + " SET value = value - ? WHERE key = ?;";		
	
		try (
			Connection conn = DriverManager.getConnection(Database.url);
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setInt(1, value);
			pstmt.setString(2, key);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean insert(String key, Integer value) {
		String sql = "INSERT INTO " + TABLE + "(key,value) VALUES(?,?);";		
	
		try (
			Connection conn = DriverManager.getConnection(Database.url);
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setString(1, key);
			pstmt.setInt(2, value);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
