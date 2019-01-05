package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import java.util.HashMap;

import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class DonorScreenController extends Controller {
	
	@FXML TextField inputUserDonationNewAmount,
					inputUserDonationNewHair,
					inputUserPasswordOld,
					inputUserPasswordNew,
					inputUserPasswordNewCheck,
					inputUserEmailNew;

	public void init() {
		clearAll();
	}
	
	public void donate() {

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
		if(!app.currentUser.setMail(mail)) {
			alertErrorAndWait("Email nelze zmenit", "Objevila se neocekavana chyba, proto nic nebude...");
			return;
		}
		
		clearEmailChange();
		alertInfoAndWait("Email zmenen.");
	}
	
	public void onClickDonate() {
		;
	}

	public void onClickLogout() {
		logout();
	}
	private void clearAll() {
		clearDonation();
		clearEmailChange();
		clearPasswordChange();
	}
	private void clearDonation() {
		inputUserDonationNewAmount.clear();
		inputUserDonationNewHair.clear();
	}
	private void clearEmailChange() {
		inputUserEmailNew.clear();
	}
	private void clearPasswordChange() {
		inputUserPasswordOld.clear();;
		inputUserPasswordNew.clear();;
		inputUserPasswordNewCheck.clear();;
	}
	
}
