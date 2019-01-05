package com.gitlab.fisvse.tymova_uloha_pavm07.lookups;

import java.util.Arrays;

public class OrderStatusLookup extends Lookup{
	private static OrderStatusLookup instance;

	public static OrderStatusLookup getInstance() {
		if (instance == null) {
			instance = new OrderStatusLookup();
		}
		return instance;
	}
	
	@Override
	public void init() {
		items = Arrays.asList(
				(LookupItem)new ProjectStatus(0, "ADMIN", "Administrator"),
				(LookupItem)new ProjectStatus(1, "EMPLOYEE", "Zamestnanec"),
				(LookupItem)new ProjectStatus(2, "DONOR", "Donor"),
				(LookupItem)new ProjectStatus(3, "PATIENT", "Pacient")
		);
	}
}
