package com.gitlab.fisvse.tymova_uloha_pavm07.main;

public class LoginScreenController extends Controller {

	public void init() {
		System.out.println("YUUUPPPIIIIIIII!!!! Login");
	}
	
	public void login() {
		this.router.setRoute("donor");
	}
	
	public void register() {
		
	}
}
