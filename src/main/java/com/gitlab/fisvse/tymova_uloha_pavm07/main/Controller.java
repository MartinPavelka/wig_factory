package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {
	Router router;
	Main app;
	
	public void init() {
		// TODO Auto-generated method stub
		
	}

	public void setRouter(Router r) {
		this.router = r;
	}
	
	public void setApp(Main app) {
		this.app = app;
	}
	
	protected void alertErrorAndWait(String header) {
		alertErrorAndWait(header, null);
	}
	protected void alertErrorAndWait(String header, String text) {
		alertAndWait(AlertType.ERROR, "Error", header, text);
	}
	
	protected void alertInfoAndWait(String header) {
		alertErrorAndWait(header, null);
	}
	protected void alertInfoAndWait(String header, String text) {
		alertAndWait(AlertType.INFORMATION, "Information", header, text);
	}
	
	protected void alertAndWait(AlertType type, String title, String header, String text) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		if (text != null)
			alert.setContentText(text);
		alert.showAndWait();
	}
	
	protected void logout() {
		this.app.currentUser = null;
		this.router.setRoute("login");
	}
}
