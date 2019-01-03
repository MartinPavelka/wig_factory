package com.gitlab.fisvse.tymova_uloha_pavm07.lookups;

public class OrderStatusLookup {
	private static OrderStatus []items = {
		new OrderStatus(0, "ADMIN", "Administrator"),
		new OrderStatus(1, "EMPLOYEE", "Zamestnanec"),
		new OrderStatus(2, "DONOR", "Donor"),
		new OrderStatus(3, "PATIENT", "Pacient"),
	};
}
