package com.gitlab.fisvse.tymova_uloha_pavm07.objects;

public class Donation {

	private String type;
	private int amount;

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
	public void donate(int amount, String type) {
		this.amount = amount;
		this.type = type;
	}
}
