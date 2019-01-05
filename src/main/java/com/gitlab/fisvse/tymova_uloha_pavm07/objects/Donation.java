package com.gitlab.fisvse.tymova_uloha_pavm07.objects;

import java.time.Instant;
import java.util.Date;

import com.gitlab.fisvse.tymova_uloha_pavm07.users.Donor;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Donation {

	private int
		id,
		userid,
		amount,
		hair,
		created;

	public Donation (int id, int userid, int amount, int hair, int created) {
		this.setId(id);
		this.setUserid(userid);
		this.setAmount(amount);
		this.setHair(hair);
		this.setCreated(created);
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


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public int getAmount() {
		return amount;
	}
	
	public String getPropAmount() {
		return Integer.toString(amount);
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getHair() {
		return hair;
	}
	
	public String getPropHair() {
		return Integer.toString(hair);
	}


	public void setHair(int hair) {
		this.hair = hair;
	}


	public int getCreated() {
		return created;
	}
	
	public String getPropCreated() {
		Date date = Date.from( Instant.ofEpochSecond( created ) );
		return date.toString();
	}


	public void setCreated(int created) {
		this.created = created;
	}

}
