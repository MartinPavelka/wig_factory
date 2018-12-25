package com.gitlab.fisvse.tymova_uloha_pavm07.objects;

import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Hair;

public class EventWig {

	private Hair hairReceived;
	private int cost;
	private int moneyReceived;
	
	public EventWig (Hair hairReceived, int cost, int moneyReceived) {
		this.setHairReceived(hairReceived);
		this.setCost(cost);
		this.setMoneyReceived(moneyReceived);
	}

	public Hair getHairReceived() {
		return hairReceived;
	}

	public void setHairReceived(Hair hairReceived) {
		this.hairReceived = hairReceived;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getMoneyReceived() {
		return moneyReceived;
	}

	public void setMoneyReceived(int moneyReceived) {
		this.moneyReceived = moneyReceived;
	}
}
