package com.gitlab.fisvse.tymova_uloha_pavm07.lookups;

import java.util.Arrays;

public class ProjectStatusLookup extends Lookup{
	private static ProjectStatusLookup instance;

	public static ProjectStatusLookup getInstance() {
		if (instance == null) {
			instance = new ProjectStatusLookup();
		}
		return instance;
	}
	
	@Override
	public void init() {
		items = Arrays.asList(
				(LookupItem)new ProjectStatus(0, "CREATED", "Nezaplacen"),
				(LookupItem)new ProjectStatus(1, "PAID", "Zaplacen")
		);
	}
}
