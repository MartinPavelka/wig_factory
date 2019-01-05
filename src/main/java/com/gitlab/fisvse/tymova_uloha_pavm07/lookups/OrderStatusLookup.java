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
				(LookupItem)new ProjectStatus(0, "CREATED", "Vytvorena a ceka na schvaleni."),
				(LookupItem)new ProjectStatus(1, "MANUFACTURED", "Paruka je ve vyrobe."),
				(LookupItem)new ProjectStatus(2, "READY", "Paruka je pripravena k predani."),
				(LookupItem)new ProjectStatus(3, "HANDEDOVER", "Mate paruku na hlave.")
		);
	}
}
