package com.gitlab.fisvse.tymova_uloha_pavm07.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login {
	static private String username, password, type;
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	
	public Login() throws IOException {
		System.out.println("zadej username");
		username = br.readLine();
		
		System.out.println("zadej heslo");
		password = br.readLine();
	}
	
	public void Register() throws IOException{
		System.out.println("a) jsem donor b) jsem pacient");
		String answer = br.readLine();
		if (answer.equals("a")) {
			System.out.println("Jsem a) fyzicka osoba b) pravnicka osoba");
		} else {
			
		}
	}
	
	String toSHA(String pass) { // TO DO HASHING
		String passwordHash;
		return pass;
	}
}
