package com.gitlab.fisvse.tymova_uloha_pavm07.objects;

import java.time.Instant;
import java.util.Date;

import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.OrderStatus;
import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.OrderStatusLookup;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.Donor;

public class Order {

	private int
		id,
		status,
		userId;

	public Order() {
		
	}
	public Order(int id, int status, int userId) {
		this.setId(id);
		this.setStatus(status);
		this.setUserId(userId);
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

	public int getStatus() {
		return status;
	}
	
	public String getPropStatus() {
		OrderStatusLookup orderStatusLookup = OrderStatusLookup.getInstance();
		return orderStatusLookup.getById(status).getName();
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}
	
	public String getPropUserId() {
		return Integer.toString(userId);
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


}
