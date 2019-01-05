package com.gitlab.fisvse.tymova_uloha_pavm07.main.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.Role;
import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.RoleLookup;
import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Donation;
import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Order;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrdersModel extends Model {
	public static final String TABLE = "Orders";
	
	public boolean addOrder(int userId) {
		String sql = "INSERT INTO " + TABLE + "(status,userid) VALUES(0,?);";
		
		try (	Connection conn = DriverManager.getConnection(Database.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean setOrderStatus(int id, int status) {
		String sql = "UPDATE " + TABLE + " SET status = ? WHERE id = ?;";
		
		try (	Connection conn = DriverManager.getConnection(Database.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.setInt(2, status);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public Order getOrderByUserId(int userid) {
		String sql = "SELECT id,status,userid FROM " + TABLE + " WHERE userid = ?;";
	
		try (
			Connection conn = DriverManager.getConnection(Database.url);
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next())
				return null;

			Order o = new Order();
			o.setId(rs.getInt("id"));
			o.setStatus(rs.getInt("status"));
			o.setUserId(rs.getInt("userId"));
			return o;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	public ObservableList<Order> getAll() {
		String sql = "SELECT Orders.id, username, status, userid FROM " + TABLE + " JOIN Users on Users.id = " + TABLE + ".userId;";
		
		ObservableList<Order> ordersList = FXCollections.observableArrayList();
		
		try (Connection conn = Database.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Order o = new Order(
						rs.getInt("id"),
						rs.getInt("status"),
						rs.getInt("userid")
				);
				o.setUsername(rs.getString("username"));
				ordersList.add(o);
			}
			return ordersList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
