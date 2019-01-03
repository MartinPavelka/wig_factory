package com.gitlab.fisvse.tymova_uloha_pavm07.lookups;

public class ProjectStatusLookup {
	private static ProjectStatus []items = {
		new ProjectStatus(0, "ADMIN", "Administrator"),
		new ProjectStatus(1, "EMPLOYEE", "Zamestnanec"),
		new ProjectStatus(2, "DONOR", "Donor"),
		new ProjectStatus(3, "PATIENT", "Pacient"),
	};
}
