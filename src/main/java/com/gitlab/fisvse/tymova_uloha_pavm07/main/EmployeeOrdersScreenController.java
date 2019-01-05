package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.HashMap;

import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.OrdersModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Order;

public class EmployeeOrdersScreenController extends Controller{

    @FXML ComboBox comboBoxNewStatus;
    @FXML Button
    	changeStatus,
    	logout,
    	goBack;
    @FXML TableView tableOrders;

    public void init() {
    	updateOrdersList();
    }

    public void onClickLogout() {
    	logout();
    }

    public void onClickChangeOrderStatus() {
        //change status of a selected patient's order in DB
    }

    public void onClickGoBack() {
        // go back to employeeScreen
    	router.setRoute("employee");
    }
    
    private void updateOrdersList() {
    	tableOrders.getItems().clear();
    	OrdersModel model = new OrdersModel();
    	ObservableList<Order> orderList = model.getAll();
    	
    	tableOrders.setItems(orderList);
    }

}