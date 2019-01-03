package com.gitlab.fisvse.tymova_uloha_pavm07.users;

import java.util.ArrayList;

import com.gitlab.fisvse.tymova_uloha_pavm07.objects.*;

public class Donor  extends User {
	private ArrayList<Donation> donations = new ArrayList<Donation>();
	int amount;
	String type;
	
	public void donate(int amount, String type) {
		Donation donation = new Donation(type, amount, this);
		donations.add(donation);
	}
	
	public ArrayList<Donation> getDonations() {
		return donations;
	}
}
