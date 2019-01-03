package com.gitlab.fisvse.tymova_uloha_pavm07.enums;

import java.util.HashMap;

public class Roles {
	private static Roles instance;
	private HashMap<String, Integer> map = new HashMap<>();
	
	Roles() {
		map.put("ADMIN", 0);
		map.put("EMPLOYEE", 1);
		map.put("DONOR", 2);
		map.put("PATIENT", 3);
	}
	
	public static Roles getInstance() {
		if (instance == null)
			instance = new Roles();
		return instance;
	}

	public Integer get(String role) {
		return map.get(role);
	}
}
