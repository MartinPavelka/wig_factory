package com.gitlab.fisvse.tymova_uloha_pavm07.persons;

import com.gitlab.fisvse.tymova_uloha_pavm07.departments.*;

public class User {
	String name;
	String pass;
	Department department;
	
	void User() {
		this.name = name;
		this.pass = setPass();
	}
	
	public String setPass() {
//		user input
		return pass;
	}
	
	public void changePass() {
		String oldPass = pass;
//		porovnani s oldPass
		String newPass = "Abcd123";
//		new Pass
//		repeat new Pass
		pass = newPass;
	}
	
	
}
