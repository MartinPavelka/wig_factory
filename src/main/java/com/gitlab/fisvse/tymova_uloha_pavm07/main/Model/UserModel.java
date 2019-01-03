package com.gitlab.fisvse.tymova_uloha_pavm07.main.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserModel extends Model {
	public static final String TABLE = "Users";
	
	public boolean createUser(String username, String password, String mail, Integer role) {
		String hashedPassword = hashPassword(password);

		String sql = "INSERT INTO " + TABLE + "(username,password,role,mail) VALUES(?,?,?,?);";		
		try (Connection conn = Database.getConnection();
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
	
	public String hashPassword(String password) {
		return password;
	}
}
