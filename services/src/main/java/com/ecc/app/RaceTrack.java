package com.ecc.app;

import java.util.ArrayList;
import java.util.concurrent.Phaser;

public class RaceTrack {
	private ArrayList<RunnableHorse> raceHorses;
	private Phaser phaser = new Phaser();
	private Ranker ranker = new Ranker();
	private int trackDistance;
	final private int distanceToStartingLine=10; 

	public RaceTrack(ArrayList<RunnableHorse> raceHorses, int trackDistance) {
		this.raceHorses = raceHorses;
		this.trackDistance = trackDistance;
		for(RunnableHorse horse: raceHorses) {
			horse.setDistanceToTravel(this.trackDistance);
			horse.setPhaser(this.phaser);
			horse.setRanker(this.ranker);
			horse.setDistanceToStartingLine(this.distanceToStartingLine);
		}
	}

	// public RaceTrack(ArrayList<RunnableHorse> raceHorses) {
	// 	for(RunnableHorse horse: raceHorses) {
	// 		horse.setPhaser(this.phaser);
	// 		horse.setRanker(this.ranker);
	// 		horse.setDistanceToStartingLine(this.distanceToStartingLine);
	// 	}
	// }

	// public RaceTrack(int trackDistance) {
	// 	this.trackDistance = trackDistance;
	// 	this.raceHorses = new ArrayList<RunnableHorse>();
	// }

	// public void addHorse(RunnableHorse raceHorse) {
	// 	raceHorse.setDistanceToStartingLine(this.distanceToStartingLine);
	// 	this.raceHorses.add(raceHorse);
	// }

	// public void addHorses(ArrayList<RunnableHorse> raceHorses) {
	// 	this.raceHorses = raceHorses;
	// 	for(RunnableHorse horse: raceHorses) {
	// 		horse.setDistanceToTravel(this.trackDistance);
	// 		horse.setPhaser(this.phaser);
	// 		horse.setRanker(this.ranker);
	// 		horse.setDistanceToStartingLine(this.distanceToStartingLine);
	// 	}
	// }

	public ArrayList<RunnableHorse> getRaceHorses() {
		return this.raceHorses;
	}

	// public void setTrackDistance(int trackDistance) {
	// 	this.trackDistance = trackDistance;
	// }
	
	public void race() {
		System.out.printf("%-20s %-10s %-10s %-20s %-20s %-20s\n", "Name:", "Speed:", "Remaining:",
			"Status:", "Warcry:", "Iteration - Time:\n");
		this.raceHorses.parallelStream()
			.filter(horse -> horse.isHealthy()==true)
			.forEach(horse -> horse.run());
		this.ranker.displayRanking();
	}

}