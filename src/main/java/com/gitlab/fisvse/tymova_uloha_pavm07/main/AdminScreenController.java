package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.HashMap;

public class AdminScreenController {

	@FXML
	MenuItem logoutFromMenu;
	MenuItem endApplication;
	TableView tableUsers;
	TextField inputUserPasswordOld;
	TextField inputUserPasswordNew;
	TextField inputUserPaswordNewCheck;
	TextField inputUserEmailNew;
	TextField inputNewUserName;
	TextField inputNewUserMail;
	ComboBox <String> newUserRole;
	TextField inputNewUserPassword;



	public void init() {
		
	}
	
	public void login() {
		
	}
	
	public void register() {
		
	}

	public void onClickCreateNewUser() {
		//založení nového uživatele a uložení do DB
	}
}
