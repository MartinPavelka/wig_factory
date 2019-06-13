package com.gitlab.fisvse.tymova_uloha_pavm07.lookups;

import java.util.List;

public abstract class Lookup {
	protected List<LookupItem> items;
	
	public Lookup() {
		init();
	}

	public abstract void init();

	public LookupItem getById(int id) {
		for(LookupItem item: items) {
			if (item.getId() == id)
				return item;
		}
		return null;
	}
	
	public LookupItem getByStrId(String strId) {
		for(LookupItem item: items) {
			if (item.getStrId().equals(strId))
				return item;
		}
		return null;
	}
	
	public LookupItem getByName(String name) {
		for(LookupItem item: items) {
			if (item.getName().equals(name))
				return item;
		}
		return null;
	}
}
