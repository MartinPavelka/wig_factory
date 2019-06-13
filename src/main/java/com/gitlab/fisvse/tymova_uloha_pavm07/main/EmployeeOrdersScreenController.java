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

import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.OrderStatusLookup;
import com.gitlab.fisvse.tymova_uloha_pavm07.lookups.RoleLookup;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.OrdersModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.ProjectsModel;
import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Order;
import com.gitlab.fisvse.tymova_uloha_pavm07.objects.Project;

public class EmployeeOrdersScreenController extends Controller{

    @FXML ComboBox<String> comboBoxNewStatus;
    @FXML Button
    	changeStatus,
    	logout,
    	goBack;
    @FXML TableView<Order> tableOrders;
    @FXML
    Button buttonChangeStatus;
    
    ChangeListener tableOrdersListener;
	Order selectedOrder;

    public void init() {
    	OrderStatusLookup statusLookup = OrderStatusLookup.getInstance();
    	comboBoxNewStatus.getItems().clear();
    	comboBoxNewStatus.getItems().add((statusLookup.getByStrId("CREATED").getName()));
    	comboBoxNewStatus.getItems().add((statusLookup.getByStrId("MANUFACTURED").getName()));
    	comboBoxNewStatus.getItems().add((statusLookup.getByStrId("READY").getName()));
    	comboBoxNewStatus.getItems().add((statusLookup.getByStrId("HANDEDOVER").getName()));
    	comboBoxNewStatus.getSelectionModel().selectFirst();
    	updateOrdersList();
    	
    	// Init table view listener
		if (tableOrdersListener == null)
			initTableOrdersListener();
    }
    
    private void initTableOrdersListener() {
    	tableOrdersListener = new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				selectedOrder = tableOrders.getSelectionModel().getSelectedItem();
				buttonChangeStatus.setDisable(selectedOrder == null);
			}};
		tableOrders.getSelectionModel().selectedItemProperty().addListener(tableOrdersListener);
	}

    public void onClickLogout() {
    	logout();
    }

    public void onClickChangeOrderStatus() {
        //change status of a selected patient's order in DB
    	OrdersModel model = new OrdersModel();
		// Set status to 1 = "PAID"
		String statusName = comboBoxNewStatus.getSelectionModel().getSelectedItem();

		OrderStatusLookup orderStatusLookup = (OrderStatusLookup)OrderStatusLookup.getInstance();
		model.setOrderStatus(
				selectedOrder.getId(),
				orderStatusLookup.getByName(statusName).getId()
		);
		updateOrdersList();
    }

    public void onClickGoBack() {
        // go back to employeeScreen
    	router.setRoute("employee");
    }
    
    private void updateOrdersList() {
    	selectedOrder = null;
    	buttonChangeStatus.setDisable(true);

    	tableOrders.getItems().clear();
    	OrdersModel model = new OrdersModel();
    	ObservableList<Order> orderList = model.getAll();
    	
    	tableOrders.setItems(orderList);
    }

}