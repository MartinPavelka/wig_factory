package com.gitlab.fisvse.tymova_uloha_pavm07.users;

public class User {

	private String name;
	private String username;
	private String password;
	private boolean Gender; // 0 - female, 1 - male
	private int userType;
	
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
	public boolean isGender() {
		return Gender;
	}
	public void setGender(boolean gender) {
		Gender = gender;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
}
