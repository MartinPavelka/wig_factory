package com.gitlab.fisvse.tymova_uloha_pavm07.users;

import com.gitlab.fisvse.tymova_uloha_pavm07.objects.*;

public class User {

	private String name;
	private String username;
	private String password;
	private boolean gender; // 0 - female, 1 - male
	
	User(String name, String username, String password, boolean gender) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.gender = gender; 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isgender() {
		return gender;
	}
	public void setgender(boolean gender) {
		this.gender = gender;
	}
	
	
}
