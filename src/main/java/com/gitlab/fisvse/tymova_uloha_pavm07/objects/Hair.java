package com.gitlab.fisvse.tymova_uloha_pavm07.objects;

import com.gitlab.fisvse.tymova_uloha_pavm07.users.Donor;

public class Hair {
	
	private Donor donatedBy;
	private String color;
	private boolean wasUsed;
	private int length;
	
	public Hair (Donor donatedBy, String color, boolean wasUsed,int length) {
		this.donatedBy = donatedBy;
		this.color = color;
		this.wasUsed = wasUsed;
		this.length = length;
	}

	public Donor getDonatedBy() {
		return donatedBy;
	}

	public void setDonatedBy(Donor donatedBy) {
		this.donatedBy = donatedBy;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isWasUsed() {
		return wasUsed;
	}

	public void setWasUsed(boolean wasUsed) {
		this.wasUsed = wasUsed;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
}
