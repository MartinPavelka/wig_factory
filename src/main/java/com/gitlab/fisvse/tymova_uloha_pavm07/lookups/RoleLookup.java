package com.gitlab.fisvse.tymova_uloha_pavm07.lookups;

import com.gitlab.fisvse.tymova_uloha_pavm07.users.Admin;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.Donor;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.Employee;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.Patient;

public class RoleLookup extends Lookup{
	private static Role []items = {
		new Role(0, "ADMIN", "Administrator", Admin.class),
		new Role(1, "EMPLOYEE", "Zamestnanec", Employee.class),
		new Role(2, "DONOR", "Donor", Donor.class),
		new Role(3, "PATIENT", "Pacient", Patient.class),
	};
}
