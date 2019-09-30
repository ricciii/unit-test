package com.ecc.app;

import java.util.Optional;
import java.util.concurrent.Phaser;
import java.util.Random;

public class RunnableHorse extends Horse {
	
	private int currentSpeed;
	private int distanceToTravel;
	private int distanceToStartingLine = 0;
	private int distanceTraveled = 0;
	private static Ranker ranker;
	private Phaser phaser;

	public RunnableHorse(String name, String warcry) {
		super(name, warcry);
	}

	public RunnableHorse() {

	}

	public int getDistanceTraveled() {
		return this.distanceTraveled;
	}

	public void setDistanceToTravel(int distanceToTravel) {
		this.distanceToTravel = distanceToTravel;
	}

	public void setDistanceToStartingLine(int distanceToStartingLine) {
		this.distanceToStartingLine = distanceToStartingLine;
	}

	public void setPhaser(Phaser phaser) {
		this.phaser = phaser;
	}

	public void setRanker(Ranker ranker) {
		this.ranker = ranker;
	}

	public void run() {
		if(this.phaser!=null) {
			this.phaser.register();
		}
		boolean completed=false;
		Random random = new Random();
		int i = 1;
		try {
			while (completed == false) {
				if(distanceTraveled >= distanceToStartingLine) {
					System.out.printf("%-20s %-10s %-10s %-20s %-20s %-20s\n", super.getName(), "0", 
						"0", "Starting line", "", "i: " + (i++) + "-" + System.currentTimeMillis());
					completed=true;
				} else {
					System.out.printf("%-20s %-10s %-10s %-20s %-20s %-20s\n", super.getName(), 
						this.currentSpeed, this.distanceToStartingLine-distanceTraveled, "Running", "",
						"i: " + (i++) + "-" + System.currentTimeMillis());
					this.currentSpeed = 1 + random.nextInt(10);
					distanceTraveled += this.currentSpeed;
				}
			}
			i=1;
			this.currentSpeed=0;
			distanceTraveled=0;
			if(this.phaser!=null) {
				phaser.arriveAndAwaitAdvance();
			}
			System.out.println(super.getName() + " has left the starting line!");
			//Thread.sleep(500);
			completed=false;
			while (completed == false) {
				if(distanceTraveled >= this.distanceToTravel) {
					completed=true;
					System.out.printf("%-20s %-10s %-10s %-20s %-20s %-20s\n", super.getName(), "0", 
						"0", "Arrived", super.getWarcry(), 
						"i: " + (i++) + "-" + System.currentTimeMillis());				
				} else {
					System.out.printf("%-20s %-10s %-10s %-20s %-20s %-20s\n", super.getName(), 
						this.currentSpeed, this.distanceToTravel-distanceTraveled, "Running", "", 
						"i: " + (i++) + "-" + System.currentTimeMillis());
					this.currentSpeed = 1 + random.nextInt(10);
					distanceTraveled += this.currentSpeed;
				}
				//Thread.sleep(500);
			}
			if(this.phaser!=null) {
				this.phaser.arriveAndDeregister();
			}
			if(this.ranker!=null) {
				this.ranker.rank(super.getName());
			}
        } catch(Exception exception) {
			System.out.println(exception);
		}
	}
}