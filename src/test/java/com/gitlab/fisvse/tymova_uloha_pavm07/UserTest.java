package com.gitlab.fisvse.tymova_uloha_pavm07;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.Database;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.User;

import javafx.collections.ObservableList;

import org.junit.After;
import org.junit.Before;


/**
 * Testovací třída pro třídu User.
 *
 */
public class UserTest {
	
	ObservableList<User> usersList;
	UserModel model = new  UserModel();
	public static final String TABLE = "Users";
	
    @Before
    public void setUp()
    {
    	
    }

    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testSuccessfulRegistration() {
    	usersList = model.getAll();
    	int userCount = usersList.size();
    	assertEquals(model.createUser("test", "testpassword", "example@mail.org", 2), true);
    	int newUserCount = usersList.size();
    	System.out.println(userCount);
    	System.out.println(newUserCount);
    	assertEquals(userCount, newUserCount - 1);
    }
    
    
    @Test
    public void testEmailChange() {
    	String newMail = "example3@mail.org";
    	assertEquals(model.setMail(3, newMail), true);
    	usersList = model.getAll();
    	for (int i = 0; i < usersList.size(); i++) {
    		System.out.println(usersList.get(i));
    		if (usersList.get(i).getUsername().equals("test")) {
    			assertEquals(usersList.get(i).getMail(), newMail);
    		}
    	}
    }
}

