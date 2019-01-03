package com.gitlab.fisvse.tymova_uloha_pavm07.lookups;

public class Role extends LookupItem {

	private Class userCls;

	public Role(int id, String strId, String name, Class userCls) {
		super(id, strId, name);
		this.userCls = userCls;
	}

	public Class getUserCls() {
		return userCls;
	}
}
