package com.ecc.app;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class HorseNameGenerator {
	private ArrayList<String> horseNameList; 

	public void generate() {
		this.horseNameList = new ArrayList<String>();
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("horseNames.txt");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	 		String line;
			while((line = bufferedReader.readLine()) != null) {
	 			if(this.horseNameList.contains(line) == false) {
	 				this.horseNameList.add(line);
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

	public ArrayList<String> getList() {
		return this.horseNameList;
	}
}