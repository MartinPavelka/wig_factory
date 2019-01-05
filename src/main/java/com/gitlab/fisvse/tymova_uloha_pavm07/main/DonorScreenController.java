package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.DonationsModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.IntkeyvalModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Donation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DonorScreenController extends Controller {
	
	@FXML TextField inputUserDonationNewAmount,
					inputUserDonationNewHair,
					inputUserPasswordOld,
					inputUserPasswordNew,
					inputUserPasswordNewCheck,
					inputUserEmailNew;
	@FXML TableView<Donation> tableUserDonations;

	public void init() {
		clearAll();
		updateDonationsList();
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

		if(!new UserModel().setMail(app.currentUser.getId(), mail)){
			alertErrorAndWait("Email nelze zmenit", "Objevila se neocekavana chyba, proto nic nebude...");
			return;
		}
		
		app.currentUser.setMail(mail);
		
		clearEmailChange();
		alertInfoAndWait("Email zmenen.");
	}
	
	public void onClickDonate() {
		int moneyAmount,
			hairAmount;

		System.out.println("kek1");
		try {
			moneyAmount = Integer.parseInt(inputUserDonationNewAmount.getText());
			hairAmount = Integer.parseInt(inputUserDonationNewHair.getText());
		} catch (NumberFormatException e) {
			alertErrorAndWait("Neplatne hodnoty. Zadejte prosim cele cislo.");
			return;
		}
		
		System.out.println("kek2");
		
		DonationsModel model = new DonationsModel();
		if (!model.addDonation(
				app.currentUser.getId(),
				moneyAmount,
				hairAmount)) {
			alertErrorAndWait("Nelze pridat dar", "Objevila se neocekavana chyba, proto nic nebude...");
		}
		IntkeyvalModel kvModel = new IntkeyvalModel();
		kvModel.add("money", moneyAmount);
		kvModel.add("hair", hairAmount);
		
		
		updateDonationsList();
	}
	
	private void updateDonationsList() {

		tableUserDonations.getItems().clear();
		DonationsModel model = new DonationsModel();
		ObservableList<Donation> donationsList = model.getDonationsFromUser(app.currentUser.getId());

		tableUserDonations.setItems(donationsList);
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
		inputUserPasswordOld.clear();
		inputUserPasswordNew.clear();
		inputUserPasswordNewCheck.clear();
	}
	
}
