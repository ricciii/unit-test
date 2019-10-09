package com.ecc.app;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerUtil implements InputProvider {
	
	private Scanner scanner;

	public ScannerUtil() {
		this.scanner = new Scanner(System.in);
	}

	public ScannerUtil(Scanner scanner) {
		scanner = scanner;
	}

	public String getString() {
		String string = "";
		string = scanner.nextLine();
		return string;
	}

	public Integer getInt() {
		Integer integer = null;
		boolean done = false;
		do {
			try {
				integer = scanner.nextInt();
				scanner.nextLine();
				done = true;
			} catch(InputMismatchException mismatch) {
				scanner.nextLine();
			}
		} while(done == false);
		return integer;
	}

}