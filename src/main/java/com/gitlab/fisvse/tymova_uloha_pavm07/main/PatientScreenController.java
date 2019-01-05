package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.HashMap;

import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;

public class PatientScreenController extends Controller{

	
	@FXML MenuItem 
		logoutFromMenu,
		endApplication;
	@FXML TextField 
		inputUserPasswordOld,
		inputUserPasswordNew,
		inputUserPasswordNewCheck,
		inputUserEmailNew;

	public void init() {
		clearAll();
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
	}

	public void onClickCreateNewOrder() {
		// založit žádost o paruku a nahrát do DB
	}
	
	public void onClickLogout() {
		logout();
	}
	
	private void clearAll() {
		clearEmailChange();
		clearPasswordChange();
	}
	private void clearEmailChange() {
		inputUserEmailNew.clear();
	}
	private void clearPasswordChange() {
		inputUserPasswordOld.clear();
		inputUserPasswordNew.clear();
		inputUserPasswordNewCheck.clear();
	}
}
