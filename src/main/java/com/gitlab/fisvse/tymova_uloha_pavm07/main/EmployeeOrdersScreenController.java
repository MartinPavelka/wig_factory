package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.HashMap;

public class EmployeeOrdersScreenController extends Controller{

    @FXML
    MenuItem logoutFromMenu;
    MenuItem endApplication;
    TableView tableOrders;
    TextField inputPatientID;
    ComboBox<String> newStatus;

    public void init() {

    }

    public void donate() {

    }

    public void onClickLogout() {

    }

    public void onClickChangeOrderStatus() {
        //change status of a selected patient's order in DB
    }

    public void onClickGoBack() {
        // go back to employeeScreen
    }

}