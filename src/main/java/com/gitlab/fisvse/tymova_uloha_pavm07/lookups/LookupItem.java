package com.gitlab.fisvse.tymova_uloha_pavm07.lookups;

public class LookupItem {
	private int id;
	private String strId;
	private String name;
	public LookupItem(int id, String strId, String name) {
		this.id = id;
		this.strId = strId;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public String getStrId() {
		return strId;
	}
	public String getName() {
		return name;
	}
}
