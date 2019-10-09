package com.ecc.app;

public class Main {
	
	public static void main(String[] args) {
		ScannerUtil scanner = new ScannerUtil();
		App app = new App(scanner);
		app.start();
	}
}