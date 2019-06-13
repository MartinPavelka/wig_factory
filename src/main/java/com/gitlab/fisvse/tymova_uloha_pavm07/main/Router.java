package com.gitlab.fisvse.tymova_uloha_pavm07.main;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Router {
	Scene scene;
	Main app;
	private HashMap<String, FXMLLoader> loaderMap = new HashMap<>();

	Router(Main app, Scene scene) {
		this.scene = scene;
		this.app = app;
	}

	public void addRoute(String route, URL url) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(url);
		loader.load();
		loaderMap.put(route, loader);
	}
	
	public void setRoute(String route) {
		
		FXMLLoader l = loaderMap.get(route);
		if (l == null) {
			System.err.println(String.format("No such route '%s'.", route));
			return;
		}
		scene.setRoot((Parent) l.getRoot());
		Controller c = l.getController();
		c.setRouter(this);
		c.setApp(app);
		c.init();
	}
}
