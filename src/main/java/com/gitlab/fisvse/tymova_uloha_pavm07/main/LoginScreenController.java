package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import java.util.HashMap;

import com.gitlab.fisvse.tymova_uloha_pavm07.enums.Roles;
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
	
	private HashMap<String, String> roleMap = new HashMap<>();


	// INIT

	public void init() {
		initRoleMap();
		initComboBox();
		clear();
		comboboxRole.getSelectionModel().selectLast();
	}
	private void initRoleMap() {
		roleMap.put("Pacient", "PATIENT");
		roleMap.put("Donor", "DONOR");
	}
	@SuppressWarnings("unchecked")
	private void initComboBox() {
		for (String key : roleMap.keySet()) {
			comboboxRole.getItems().add(key);
		}
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
//		this.router.setRoute("donor");
	}
	
	public void onClickRegister() {
		UserModel model = new UserModel();
		String role = roleMap.get(comboboxRole.getSelectionModel().getSelectedItem());
		
		model.createUser(
			inputRegUsername.getText(),
			inputRegPassword.getText(),
			inputRegMail.getText(),
			Roles.getInstance().get(role)
		);
		clear();
	}
}
