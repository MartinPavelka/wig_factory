package com.gitlab.fisvse.tymova_uloha_pavm07.main.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.Role;
import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.RoleLookup;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.User;

public class UserModel extends Model {
	public static final String TABLE = "Users";
	
	public boolean createUser(String username, String password, String mail, Integer role) {
		String hashedPassword = hashPassword(password);

		String sql = "INSERT INTO " + TABLE + "(username,password,role,mail) VALUES(?,?,?,?);";		
		try (Connection conn = DriverManager.getConnection(Database.url);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			pstmt.setString(2, hashedPassword);
			pstmt.setInt(3, role);
			pstmt.setString(4, mail);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;

	}
	
	public User login(String username, String password) {
		String sql = "SELECT id,username,role,mail FROM " + TABLE + " WHERE password = ?;";
	
		try (
			Connection conn = DriverManager.getConnection(Database.url);
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setString(1, password);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next())
				return null;

			RoleLookup roleLookup = RoleLookup.getInstance();
			int role = rs.getInt("role");
			Role r = (Role)roleLookup.getById(role);
			Class cls = r.getUserCls();
			User u = (User) cls.newInstance();
			u.setId(rs.getInt("id"));
			u.setUsername(rs.getString("username"));
			u.setRole(rs.getInt("role"));
			u.setMail(rs.getString("mail"));
			conn.close();
			return u;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean setPassword(int id, String password) {
		String hashedPassword = hashPassword(password);
		String sql = "UPDATE " + TABLE + " SET password = ? WHERE id = ?;";		
		try (	Connection conn = DriverManager.getConnection(Database.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, hashedPassword);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean setMail(int id, String mail) {
		String sql = "UPDATE " + TABLE + " SET mail = ? WHERE id = ?;";		
		try (	Connection conn = DriverManager.getConnection(Database.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, mail);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public String hashPassword(String password) {
		return password;
	}
}
