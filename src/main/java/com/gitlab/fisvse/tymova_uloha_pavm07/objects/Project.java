package com.gitlab.fisvse.tymova_uloha_pavm07.objects;

import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.ProjectStatusLookup;

public class Project {

	private int
		id,
		price,
		status,
		userid;
	private String
		name;
	

	public Project() {
		
	}
	public Project(int id, int price, int status, String name, int userid) {
		this.setId(id);
		this.setStatus(status);
		this.setName(name);
		this.setUserid(userid);
		this.setPrice(price);
	}
	public int getId() {
		return id;
	}
	public String getPropId() {
		return Integer.toString(id);
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public String getPropPrice() {
		return Integer.toString(price);
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public String getPropStatus() {
		ProjectStatusLookup projectStatusLookup = ProjectStatusLookup.getInstance();
		return projectStatusLookup.getById(status).getName();
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public String getPropName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
