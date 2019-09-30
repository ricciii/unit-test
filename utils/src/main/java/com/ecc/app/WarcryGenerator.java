package com.ecc.app;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class WarcryGenerator {
	private ArrayList<String> warcryList;

	public ArrayList<String> getList() {
		return this.warcryList;
	}

	public void generate() {
		this.warcryList = new ArrayList<String>();
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("warcries.txt");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	 		String line;
			this.warcryList.add(null);
			while((line = bufferedReader.readLine()) != null) {
	 			if(this.warcryList.contains(line) == false) {
	 				this.warcryList.add(line);
	 			}
	 		}
		} catch(FileNotFoundException fileNotFoundError) {
	 		System.out.println(fileNotFoundError);
		} catch(IOException ioError) {
			System.out.println(ioError);
		} catch(NullPointerException nullPointerError) {
			System.out.println(nullPointerError);
		}
	}
}