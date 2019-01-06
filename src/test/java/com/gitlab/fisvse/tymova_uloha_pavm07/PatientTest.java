package com.gitlab.fisvse.tymova_uloha_pavm07;

import static org.junit.Assert.*;
import org.junit.Test;

import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.OrdersModel;

import org.junit.After;
import org.junit.Before;


/**
 * Testovací třída pro třídu Patient.
 *
 */
public class PatientTest {

	OrdersModel model = new OrdersModel();
	
    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testRequestCreated() {
    	int oldCount = model.getAll().size();
    	assertEquals(model.addOrder(2), true);
    	int newCount = model.getAll().size();
    	assertEquals(oldCount, newCount - 1);
    }
}

    