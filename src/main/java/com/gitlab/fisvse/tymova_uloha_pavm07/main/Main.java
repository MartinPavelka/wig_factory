package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import com.gitlab.fisvse.tymova_uloha_pavm07.main.Model.Database;
import com.gitlab.fisvse.tymova_uloha_pavm07.users.User;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private HashMap<String, Pane> paneMap = new HashMap<>();
	
	public Router router;
	public User currentUser;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// UI
			FXMLLoader loader = new FXMLLoader();
			Scene scene = new Scene(new Pane(), 600, 400);
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			Router router = new Router(this, scene);
			router.addRoute("login", getClass().getResource("/LoginScreen.fxml"));
			router.addRoute("donor", getClass().getResource("/DonorScreen.fxml"));
			router.setRoute("login");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//kontrola počtu parametrů
		if (args.length == 0) {
			//spuštění grafiky, parametr args je povinný, ale v tomto případě už ho v grafice nepoužijeme
			launch(args);
		} else {
			System.out.println("Neplatný parametr");		
		}
		
	}
}
