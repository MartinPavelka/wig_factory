package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.HashMap;

import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.DonationsModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.ProjectsModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.UserModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Donation;
import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Project;

public class EmployeeScreenController extends Controller {

	@FXML
	MenuItem logoutFromMenu, endApplication;
	@FXML
	TextField inputUserPasswordOld, inputUserPasswordNew, inputUserPasswordNewCheck, inputUserEmailNew,
	inputNewProjectName,
	inputNewProjectPrice;
	@FXML
	TableView<Project> tableProjects;
	
	@FXML
	Button buttonPayProject;
	
	ChangeListener tableProjectsListener;
	Project selectedProject;
	
	boolean table;

	public void init() {
		clearAll();
		updateProjectsList();
		
		// Init table view listener
		if (tableProjectsListener == null)
			initTableProjectsListener();

	}
	
	private void initTableProjectsListener() {
		tableProjectsListener = new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				selectedProject = tableProjects.getSelectionModel().getSelectedItem();
				if (selectedProject == null)
					buttonPayProject.setDisable(true);
				else
					buttonPayProject.setDisable(selectedProject.getStatus() != 0);
			}};
		tableProjects.getSelectionModel().selectedItemProperty().addListener(tableProjectsListener);
	}
	
	private void updateProjectsList() {
		selectedProject = null;
		buttonPayProject.setDisable(true);

		tableProjects.getItems().clear();
		ProjectsModel model = new ProjectsModel();
		ObservableList<Project> projectsList = model.getAll(app.currentUser.getId());
		tableProjects.setItems(projectsList);
	}

	public void onClickChangeUserPassword() {
		String oldPassword = inputUserPasswordOld.getText();
		String newPassword = inputUserPasswordNew.getText();
		String newPasswordCheck = inputUserPasswordNewCheck.getText();

		UserModel model = new UserModel();
		if (model.login(app.currentUser.getUsername(), oldPassword) == null) {
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
		}
		;

		clearPasswordChange();
		alertInfoAndWait("Heslo zmeneno.");
	}

	public void onClickChangeUserMail() {
		String mail = inputUserEmailNew.getText();

		if (!new UserModel().setMail(app.currentUser.getId(), mail)) {
			alertErrorAndWait("Email nelze zmenit", "Objevila se neocekavana chyba, proto nic nebude...");
			return;
		}

		app.currentUser.setMail(mail);

		clearEmailChange();
		alertInfoAndWait("Email zmenen.");
	}

	public void onClickLogout() {
		logout();
	}

	private void clearAll() {
		clearEmailChange();
		clearPasswordChange();
		clearNewProject();
	}
	
	private void clearNewProject() {
		inputNewProjectName.clear();
		inputNewProjectPrice.clear();
	}

	private void clearEmailChange() {
		inputUserEmailNew.clear();
	}

	private void clearPasswordChange() {
		inputUserPasswordOld.clear();
		inputUserPasswordNew.clear();
		inputUserPasswordNewCheck.clear();
	}

	public void onClickPayProject() {
		ProjectsModel model = new ProjectsModel();
		// Set status to 1 = "PAID"
		model.setProjectStatus(selectedProject.getId(), 1);
		updateProjectsList();
	}

	public void onClickCreateProject() {
		String name = inputNewProjectName.getText();
		int price;

		try {
			price = Integer.parseInt(inputNewProjectPrice.getText());
		} catch (NumberFormatException e) {
			alertErrorAndWait("Neplatne hodnoty. Zadejte prosim cele cislo.");
			return;
		}

		ProjectsModel model = new ProjectsModel();
		if (!model.addProject(
				name,
				price)) {
			alertErrorAndWait("Nelze pridat dar", "Objevila se neocekavana chyba, proto nic nebude...");
		}
		
		clearNewProject();
		updateProjectsList();
	}

	public void onClickOpenRequests() {
		// open screen with patient requests
		router.setRoute("employeeOrders");
	}
}
