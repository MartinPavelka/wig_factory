package com.gitlab.fisvse.tymova_uloha_pavm07;

import static org.junit.Assert.*;

import org.junit.*;

import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.OrdersModel;


/**
 * Testovací třída pro třídu Patient.
 *
 */
public class PatientTest {

	OrdersModel model = new OrdersModel();
	int PatientId = 2;

    
    @Test
    public void testRequestCreated() {
    	int oldCount = model.getAll().size();
    	assertEquals(model.addOrder(PatientId), true);
    	int newCount = model.getAll().size();
    	assertEquals(oldCount, newCount - 1);
    	model.removeOrder(PatientId);
    }
}

    