package com.gitlab.fisvse.tymova_uloha_pavm07;

import static org.junit.Assert.*;
import org.junit.Test;

import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;

import org.junit.After;
import org.junit.Before;


/**
 * Testovací třída pro třídu User.
 *
 */
public class UserTest {

	UserModel model = new  UserModel();
	
    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }
    
    
    public void testSuccessfulRegistration() {
    	assertEquals(model.createUser("test", "testpassword", "example@mail.org", 2), true);
    }
    
    public void testPasswordChange() {
    	model.createUser("test2", "12345", "example2@mail.org", 2);
    	assertEquals(model.setPassword(4, "56789"), true);
    	
    }
    
    public void testEmailChange() {
    	assertEquals(model.setMail(3, "example3@mail.org"), true);
    }
}

