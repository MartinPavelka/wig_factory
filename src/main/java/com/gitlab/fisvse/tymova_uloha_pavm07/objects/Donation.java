package com.gitlab.fisvse.tymova_uloha_pavm07.objects;

import com.gitlab.fisvse.tymova_uloha_pavm07.users.Donor;

public class Donation {

	private String type; //type = either hair or money
	private int amount; //if money the unit is CZK, if hair its grams
	private Donor owner;
	
	public Donation (String type, int amount, Donor owner) {
		this.type = type;
		this.amount = amount;
		this.owner = owner;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Donor getOwner () {
		return owner;
	}

}
