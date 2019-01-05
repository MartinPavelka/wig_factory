package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import java.util.HashMap;

import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.Lookup;
import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.RoleLookup;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.User;

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
		RoleLookup roleLookup = RoleLookup.getInstance();
		comboboxRole.getItems().add(roleLookup.getByStrId("DONOR").getName());
		comboboxRole.getItems().add(roleLookup.getByStrId("PATIENT").getName());
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
		User u = model.login(
			inputUsername.getText(),
			inputPassword.getText()
		);
		
		System.out.println(u.getClass().getSimpleName());
	}
	
	public void onClickRegister() {
		UserModel model = new UserModel();
		String role = comboboxRole.getSelectionModel().getSelectedItem();

		RoleLookup roleLookup = (RoleLookup)RoleLookup.getInstance();
		
		model.createUser(
			inputRegUsername.getText(),
			inputRegPassword.getText(),
			inputRegMail.getText(),
			roleLookup.getByName(role).getId()
		);
		clear();
	}
}
