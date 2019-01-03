package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import java.util.HashMap;

import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.Lookup;
import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.RoleLookup;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.Pair;
import javafx.scene.control.ComboBox;

public class LoginScreenController extends Controller {

	@FXML TextField inputRegUsername,
					inputRegPassword,
					inputRegMail,
					inputUsername,
					inputPassword;
	@FXML ComboBox<String> comboboxRole;
	
	// INIT

	public void init() {
		initComboBox();
		clear();
		comboboxRole.getSelectionModel().selectLast();
	}

	private void initComboBox() {
		System.out.println("asdfasdfasdf");
		System.out.println(RoleLookup.getByStrId("DONOR"));
		comboboxRole.getItems().add(RoleLookup.getByStrId("DONOR").getName());
		comboboxRole.getItems().add(RoleLookup.getByStrId("PATIENT").getName());
	}

	//
	
	public void clear() {
		inputRegUsername.setText(null);
		inputRegPassword.setText(null);
		inputRegMail.setText(null);
		inputUsername.setText(null);
		inputPassword.setText(null);
	}

	public void onClickLogin() {
		UserModel model = new UserModel();
		model.login(
			inputUsername.getText(),
			inputPassword.getText()
		);
	}
	
	public void onClickRegister() {
		UserModel model = new UserModel();
		String role = comboboxRole.getSelectionModel().getSelectedItem();
		
		model.createUser(
			inputRegUsername.getText(),
			inputRegPassword.getText(),
			inputRegMail.getText(),
			RoleLookup.getByName(role).getId()
		);
		clear();
	}
}
