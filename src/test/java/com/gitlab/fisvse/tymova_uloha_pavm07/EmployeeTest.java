package com.gitlab.fisvse.tymova_uloha_pavm07;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.OrdersModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.ProjectsModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Project;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.User;

import javafx.collections.ObservableList;


/**
 * Testovací třída pro třídu Patient.
 *
 */
public class EmployeeTest {
	
	UserModel users = new UserModel();
	OrdersModel orders = new OrdersModel();
	ProjectsModel projects = new ProjectsModel();
	ObservableList<Project> projectsList;
	ObservableList<User> usersList;
	
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown() {
    	
    }

    
    @Test
    public void testMultipleOrders() {
    	assertEquals(users.createUser("zamestnanec", "12345", "example@mail.org", 1), true);
    	assertEquals(users.createUser("pacient1", "12345", "example@mail.org", 3), true);
    	assertEquals(users.createUser("pacient2", "12345", "example@mail.org", 3), true);
    	usersList = users.getAll();
    	int id = 0;
    	for (int i = 0; i < usersList.size(); i++) {
    		if (usersList.get(i).getUsername().equals("zamestnanec")) {
    			id = usersList.get(i).getId();
    		}
    	}
    	projectsList = projects.getAll(id);
    	int oldCount = projectsList.size();
    	assertEquals(projects.addProject("projekt1", 100), true);
    	assertEquals(projects.addProject("projekt1", 200), true);
    	projectsList = projects.getAll(id);
    	int newCount = projectsList.size();
    	assertEquals(oldCount, newCount - 2);
    	for (int i = 2; i <= usersList.size(); i++) {
    		users.removeUser(i);
    	}
    }
}