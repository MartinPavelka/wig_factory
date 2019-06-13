package com.gitlab.fisvse.tymova_uloha_pavm07;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.*;

import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.Database;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.User;

import javafx.collections.ObservableList;


/**
 * Testovací třída pro třídu User.
 *
 */
public class UserTest {
	
	ObservableList<User> usersList;
	UserModel model = new  UserModel();
	public static final String TABLE = "Users";
    
    @Test
    public void testSuccessfulRegistration() {
    	usersList = model.getAll();
    	int userCount = usersList.size();
    	assertEquals(model.createUser("test", "testpassword", "example@mail.org", 2), true);
    	usersList = model.getAll();
    	int newUserCount = usersList.size();
    	assertEquals(userCount, newUserCount - 1);
    	removeUnitUsers();
    }
    
    
    @Test
    public void testEmailChange() {
    	usersList = model.getAll();
    	int id = 0;
    	for (int i = 0; i < usersList.size(); i++) {
    		if (usersList.get(i).getUsername().equals("test")) {
    			id = usersList.get(i).getId();
    		}
    	}
    	String newMail = "example3@mail.org";
    	assertEquals(model.setMail(id, newMail), true);
    	usersList = model.getAll();
    	for (int i = 0; i < usersList.size(); i++) {
    		if (usersList.get(i).getUsername().equals("test")) {
    			assertEquals(usersList.get(i).getMail(), newMail);
    		}
    	}
    	removeUnitUsers();
    }
    
    public boolean removeUnitUsers() {
		String sql = "DELETE FROM Users WHERE mail like \"example%\";";		
		try (Connection conn = DriverManager.getConnection(Database.url);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.executeUpdate();
			model.restartUserIncrement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}

