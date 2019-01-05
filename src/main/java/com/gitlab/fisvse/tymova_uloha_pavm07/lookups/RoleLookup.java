package com.gitlab.fisvse.tymova_uloha_pavm07.lookups;

import java.util.Arrays;

import com.gitlab.fisvse.tymova_uloha_pavm07.users.Admin;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.Donor;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.Employee;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.Patient;

public class RoleLookup extends Lookup{
	private static RoleLookup instance;

	public static RoleLookup getInstance() {
		if (instance == null) {
			instance = new RoleLookup();
		}
		return instance;
	}

	@Override
	public void init() {
		items = Arrays.asList(
				(LookupItem)new Role(0, "ADMIN", "Administrator", Admin.class),
				(LookupItem)new Role(1, "EMPLOYEE", "Zamestnanec", Employee.class),
				(LookupItem)new Role(2, "DONOR", "Donor", Donor.class),
				(LookupItem)new Role(3, "PATIENT", "Pacient", Patient.class)
		);
	}
}
