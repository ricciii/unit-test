package com.ecc.app;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
	
	private static final int MINIMUM_DISTANCE = 200;
	private static final int MINIMUM_HORSES = 2;
	private static final int MAXIMUM_HORSES = Runtime.getRuntime().availableProcessors();

	private int trackDistance=0;
	private int numOfHorses=0;
	private InputProvider scanner;

	public App() {
		this.scanner = new ScannerUtil();
	}

	public App(InputProvider scanner) {
		this.scanner = scanner;
	}

	public void start() {
		
		HorseNameGenerator nameGenerator = new HorseNameGenerator();
		nameGenerator.generate();
		WarcryGenerator warcryGenerator = new WarcryGenerator();
		warcryGenerator.generate();
		
		int distance;
		do {
			System.out.print("Enter racetrack distance: ");
			distance = scanner.getInt();
			if(distance < MINIMUM_DISTANCE) {
				System.out.println("Distance should be greater than: " + MINIMUM_DISTANCE + ". Input again.");
			}
		} while(distance < MINIMUM_DISTANCE);
		
		int numberOfHorses;
		RacingHorseGenerator raceHorseGenerator = new RacingHorseGenerator(nameGenerator.getList(), warcryGenerator.getList());
		ArrayList<RunnableHorse> horses;
		int numOfHealthyHorses;

		boolean done = false;
		do {
			System.out.print("Enter number of Horses: ");
			numberOfHorses = scanner.getInt();
			if(numberOfHorses > MAXIMUM_HORSES) {
				System.out.println("Horses should be less than: " + MAXIMUM_HORSES + ". Input again.");
			} else {
				raceHorseGenerator.generate(numberOfHorses);
				horses = raceHorseGenerator.getHorses();
				numOfHealthyHorses = (int) horses.stream()
						.filter(horse -> horse.isHealthy()==true)
						.count();
				if(numOfHealthyHorses < MINIMUM_HORSES) {
					System.out.println("\nHealthy horses should be greater than: " + MAXIMUM_HORSES + ". Input again.");
				} else {
					RaceTrack raceTrack = new RaceTrack(horses, distance);
					raceTrack.race();
					done = true; 
				}
			}
		} while(!done);
	}
}