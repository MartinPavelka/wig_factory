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
