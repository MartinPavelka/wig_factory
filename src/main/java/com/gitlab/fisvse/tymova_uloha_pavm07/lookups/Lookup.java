package com.gitlab.fisvse.tymova_uloha_pavm07.lookups;

public class Lookup {
	private static LookupItem []items = {};
	
	public static LookupItem getById(int id) {
		for(LookupItem item: items) {
			if (item.getId() == id)
				return item;
		}
		return null;
	}
	
	public static LookupItem getByStrId(String strId) {
		for(LookupItem item: items) {
			if (item.getStrId().equals(strId))
				return item;
		}
		return null;
	}
	
	public static LookupItem getByName(String name) {
		for(LookupItem item: items) {
			if (item.getName().equals(name))
				return item;
		}
		return null;
	}
}
