package com.gitlab.fisvse.tymova_uloha_pavm07.users;

import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.Role;
import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.RoleLookup;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.objects.*;

public class User {

	private int id;
	private String username;
	private int role;
	private String mail;
	
	User() {
		
	}
	public User(int id, String username, int role, String mail) {
		this.id = id;
		this.username = username;
		this.role = role; 
		this.mail = mail;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPropUsername() {
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
	public String getPropRole() {
		Role r = (Role) new RoleLookup().getById(role);
		return r.getName();
	}
	public String getMail() {
		return mail;
	}
	public String getPropMail() {
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
	public String getPropId() {
		return Integer.toString(id);
	}
	
	public boolean setPassword(String password) {
		return new UserModel().setPassword(id, password);
	}
	
	
}
