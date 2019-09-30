package com.ecc.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.concurrent.Phaser;

public class RacingHorseGenerator {

	private ArrayList<RunnableHorse> horses;
	private ArrayList<String> horseNameList;
	private ArrayList<String> warcryList; 
	private int numOfHorses;

	public RacingHorseGenerator(ArrayList<String> horseNameList, ArrayList<String> warcryList) {
		this.horseNameList = horseNameList;
		this.warcryList = warcryList;
	}
	
	public void generate(int numOfHorses) {
		this.horses = new ArrayList<RunnableHorse>();
		// try {
		Collections.shuffle(this.horseNameList);
		Collections.shuffle(this.warcryList);
		int i=0;
		System.out.println();
		while(i<numOfHorses) {
			if((((i>=this.horseNameList.size())==true)||((i>=this.warcryList.size())==true))==true) {
				if((((i>=this.horseNameList.size())==true)&&((i>=this.warcryList.size())==true))==true) {
					this.horses.add(new RunnableHorse("Horse #"+i, "Warcry #"+(i+1)));
					System.out.printf("%-20s %-20s %-20s\n","Horse "+(i+1)+": ", 
						"Horse #"+(i+1), "Healthy: "+this.horses.get(i).isHealthy());
				} else if((i>=this.horseNameList.size())==true) {
					this.horses.add(new RunnableHorse("Horse #"+i, this.warcryList.get(i)));
					System.out.printf("%-20s %-20s %-20s\n","Horse "+(i+1)+": ", 
						"Horse #"+(i+1), "Healthy: "+this.horses.get(i).isHealthy());
				} else {
					this.horses.add(new RunnableHorse(this.horseNameList.get(i), "Warcry #"+(i+1)));
					System.out.printf("%-20s %-20s %-20s\n","Horse "+(i+1)+": ", 
						this.horseNameList.get(i), "Healthy: "+this.horses.get(i).isHealthy());
				}
			} else {
				this.horses.add(new RunnableHorse(this.horseNameList.get(i), this.warcryList.get(i)));
				System.out.printf("%-20s %-20s %-20s\n","Horse "+(i+1)+": ", 
					this.horseNameList.get(i), "Healthy: "+this.horses.get(i).isHealthy());
			}
			i++;
		}
		// } catch(Exception exception) {
		// 	System.out.println(exception);
		// }
	}

	public ArrayList<String> getHorseNameList() {
		return this.horseNameList;
	}

	public ArrayList<String> getWarcryList() {
		return this.warcryList;
	}

	public ArrayList<RunnableHorse> getHorses() {
		return this.horses;
	}
}