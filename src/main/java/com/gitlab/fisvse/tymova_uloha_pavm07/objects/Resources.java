package com.gitlab.fisvse.tymova_uloha_pavm07.objects;

import java.util.ArrayList;

import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Donation;

public class Resources {
	int size;
	ArrayList<Donation> resources = new ArrayList<>();
	ArrayList<Donation> hairResources = new ArrayList<>();
	
	Resources() {
		size = 0;
	}
	
	public void receiveDonation(Donation donation) {
		// create if statement for different types of donations. receive into different lists;
		if(donation.getType().equals("hair")) {
			hairResources.add(new Donation(donation.getType(), donation.getAmount(), donation.getOwner()));
		}
		resources.add(new Donation(donation.getType(), donation.getAmount(), donation.getOwner()));
	}
	
	public void useHair() {
		 if(!hairResources.isEmpty()){
			hairResources.remove(0);
		 }  System.out.print("The list is empty.");
		
	}
	
	public void useMoney() {
		int donation = resources.indexOf("money");
		resources.remove(donation);
	}
}
