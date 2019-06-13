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
import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Project;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProjectsModel extends Model {
	public static final String TABLE = "Projects";
	
	public boolean addProject(String name, int price) {
		String sql = "INSERT INTO " + TABLE + "(name,price,status) VALUES(?,?,0);";
		
		try (	Connection conn = DriverManager.getConnection(Database.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean removeProject(Integer id) {
		String sql = "DELETE FROM " + TABLE + " WHERE id = ?;";		
		try (Connection conn = DriverManager.getConnection(Database.url);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			restartProjectsIncrement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean restartProjectsIncrement() {
		String sql = "UPDATE sqlite_sequence SET seq = ? WHERE name = '" + TABLE + "';";
		int maxId = maxId();
		try (Connection conn = DriverManager.getConnection(Database.url);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, maxId);
        	pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	private int maxId() {
		String sql = "SELECT MAX(id) FROM " + TABLE + ";";	
		int maxId = 1;
		
		try (Connection conn = Database.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			maxId = rs.getInt("MAX(id)");
			return maxId;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return maxId;
	}
	
	public ObservableList<Project> getAll(int userId) {
		String sql = "SELECT id,price,status,name,userid FROM " + TABLE + ";";	

		ObservableList<Project> projectsList = FXCollections.observableArrayList();
		
		try (Connection conn = DriverManager.getConnection(Database.url);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Project p = new Project(
						rs.getInt("id"),
						rs.getInt("price"),
						rs.getInt("status"),
						rs.getString("name"),
						rs.getInt("userid")
				);
				projectsList.add(p);
			}
			return projectsList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return null;
	}
	
	public boolean setProjectStatus(int id, int status) {
		String sql = "UPDATE " + TABLE + " SET status = ? WHERE id = ?;";
		
		try (	Connection conn = DriverManager.getConnection(Database.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, status);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}
