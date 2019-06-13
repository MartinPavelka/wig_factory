package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.HashMap;

import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.RoleLookup;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.DonationsModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Donation;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.User;

public class AdminScreenController extends Controller{

	@FXML
	MenuItem
		logoutFromMenu,
		endApplication;
	@FXML
	TableView tableUsers;
	@FXML
	TextField 
		inputUserPasswordOld,
		inputUserPasswordNew,
		inputUserPasswordNewCheck,
		inputUserEmailNew,
		inputNewUserName,
		inputNewUserMail,
		inputNewUserPassword;
	@FXML
	ComboBox <String> comboboxNewUserRole;


	public void init() {
		RoleLookup roleLookup = RoleLookup.getInstance();
		comboboxNewUserRole.getItems().clear();
		comboboxNewUserRole.getItems().add(roleLookup.getByStrId("ADMIN").getName());
		comboboxNewUserRole.getItems().add(roleLookup.getByStrId("EMPLOYEE").getName());
		comboboxNewUserRole.getItems().add(roleLookup.getByStrId("DONOR").getName());
		comboboxNewUserRole.getItems().add(roleLookup.getByStrId("PATIENT").getName());
		comboboxNewUserRole.getSelectionModel().selectLast();
		
		updateUsersList();
	}
	
	public void login() {
		
	}
	
	public void register() {
		
	}

	public void onClickChangeUserPassword() {
		String oldPassword = inputUserPasswordOld.getText();
		String newPassword = inputUserPasswordNew.getText();
		String newPasswordCheck = inputUserPasswordNewCheck.getText();
		
		UserModel model = new UserModel();
		if(model.login(app.currentUser.getUsername(), oldPassword) == null) {
			alertErrorAndWait("Špatné heslo.");
			return;
		}
		
		if (!newPassword.equals(newPasswordCheck)) {
			alertErrorAndWait("Hesla se neshodují.");
			return;
		}
		
		if (!app.currentUser.setPassword(newPassword)) {
			alertErrorAndWait("Heslo nelze zmenit", "Objevila se neocekavana chyba, proto nic nebude...");
			return;
		};
		
		clearPasswordChange();
		alertInfoAndWait("Heslo zmeneno.");
	}
	
	public void onClickChangeUserMail() {
		String mail = inputUserEmailNew.getText();

		if(!new UserModel().setMail(app.currentUser.getId(), mail)){
			alertErrorAndWait("Email nelze zmenit", "Objevila se neocekavana chyba, proto nic nebude...");
			return;
		}
		
		app.currentUser.setMail(mail);
		
		clearEmailChange();
		alertInfoAndWait("Email zmenen.");
		updateUsersList();
	}
	
	public void onClickCreateNewUser() {
		UserModel model = new UserModel();
		String role = comboboxNewUserRole.getSelectionModel().getSelectedItem();

		RoleLookup roleLookup = (RoleLookup)RoleLookup.getInstance();
		
		model.createUser(
			inputNewUserName.getText(),
			inputNewUserPassword.getText(),
			inputNewUserMail.getText(),
			roleLookup.getByName(role).getId()
		);
		
		alertInfoAndWait("Uživatel vytvořen.");
		clear();
		updateUsersList();
	}
	
	public void onClickLogout() {
		logout();
	}
	
	private void clear() {
		clearNewUser();
	}
	
	private void clearNewUser() {
		inputNewUserName.clear();
		inputNewUserPassword.clear();
		inputNewUserMail.clear();
	}
	
	private void clearEmailChange() {
		inputUserEmailNew.clear();
	}
	
	private void clearPasswordChange() {
		inputUserPasswordOld.clear();
		inputUserPasswordNew.clear();
		inputUserPasswordNewCheck.clear();
	}
	
	private void updateUsersList() {

		tableUsers.getItems().clear();
		UserModel model = new UserModel();
		ObservableList<User> userList = model.getAll();

		tableUsers.setItems(userList);
	}
}
