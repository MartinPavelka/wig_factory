package com.gitlab.fisvse.tymova_uloha_pavm07.users;

import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.objects.*;

public class User {

	private int id;
	private String username;
	private int role;
	private String mail;
	
	User() {
		
	}
	User(int id, String username, String password, int role, String mail) {
		this.username = username;
		this.role = role; 
		this.mail = mail;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean setPassword(String password) {
		return new UserModel().setPassword(id, password);
	}
	
	
}
