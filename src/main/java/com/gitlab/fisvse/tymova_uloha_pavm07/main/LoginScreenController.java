package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import com.gitlab.fisvse.tymova_uloha_pavm07.enums.Roles;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginScreenController extends Controller {

	@FXML TextField inputRegUsername,
					inputRegPassword,
					inputRegMail;

	public void init() {
		System.out.println("YUUUPPPIIIIIIII!!!! Login");
	}
	
	public void onClickLogin() {
//		this.router.setRoute("donor");
	}
	
	public void onClickRegister() {
		UserModel model = new UserModel();
		model.createUser(
			inputRegUsername.getText(),
			inputRegPassword.getText(),
			inputRegMail.getText(),
			Roles.getInstance().get("DONOR")
		);
	}
}
