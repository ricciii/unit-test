package com.ecc.app;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
	
	private int trackDistance=0;
	private int numOfHorses=0;

	public static void main(String[] args) {
		int minimumTrackDistance = 200;
		int minimumHorses = 2;
		int maximumHorses = Runtime.getRuntime().availableProcessors();
		App app = new App();
		Scanner scanner;
		HorseNameGenerator nameGenerator = new HorseNameGenerator();
		nameGenerator.generate();
		WarcryGenerator warcryGenerator = new WarcryGenerator();
		warcryGenerator.generate();
		do {
			try {
				System.out.print("Enter racetrack distance: ");
				scanner = new Scanner(System.in);
				app.setTrackDistance(scanner);
				if(app.getTrackDistance()<minimumTrackDistance) {
					System.out.println("Minimum distance is: " + minimumTrackDistance);
				}
			} catch(Exception exception) {
				System.out.println("Wrong input, please try again.");
			}
		} while(app.getTrackDistance()<minimumTrackDistance);
		int numOfHealthyHorses=0;
		RacingHorseGenerator raceHorseGenerator = new RacingHorseGenerator(nameGenerator.getList(), warcryGenerator.getList());
		ArrayList<RunnableHorse> horses;
		do {
			try {
				System.out.print("Enter number of horses: ");
				scanner = new Scanner(System.in);
				app.setNumOfHorses(scanner);
				raceHorseGenerator.generate(app.getNumOfHorses());
				horses = raceHorseGenerator.getHorses();
				numOfHealthyHorses = (int) horses.stream()
						.filter(horse -> horse.isHealthy()==true)
						.count();
				if(app.getNumOfHorses()>maximumHorses) {
					System.out.println("Max horses: " + maximumHorses);
				} else if(numOfHealthyHorses<minimumHorses) {
					System.out.println("Minimum healthy horses: " + minimumHorses);
				}
			} catch(Exception exception) {
				System.out.println("Wrong input, please try again.");
			}
		} while(numOfHealthyHorses<minimumHorses);
		RaceTrack raceTrack = new RaceTrack(raceHorseGenerator.getHorses(), app.getTrackDistance());
		raceTrack.race(); 
	}

	public void setTrackDistance(Scanner scanner) throws Exception {
		this.trackDistance = scanner.nextInt();	
	}

	public int getTrackDistance() {
		return this.trackDistance;
	}

	public void setNumOfHorses(Scanner scanner) throws Exception {
		this.numOfHorses = scanner.nextInt();	
	}

	public int getNumOfHorses() {
		return this.numOfHorses;
	}
}