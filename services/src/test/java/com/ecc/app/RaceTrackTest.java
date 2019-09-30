package com.ecc.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.Phaser;
import java.util.ArrayList;
 
public class RaceTrackTest {
 
    @Test
    public void testRace() throws Exception {
    	int distance = 300;
    	ArrayList<RunnableHorse> horses = new ArrayList<RunnableHorse>();
 		horses.add(new RunnableHorse("Horse1", "Warcry1"));
 		horses.add(new RunnableHorse("Horse2", "Warcry2"));
 		horses.add(new RunnableHorse("Horse3", "Warcry3"));
 		horses.add(new RunnableHorse("Horse4", "Warcry4"));
 		RaceTrack raceTrack = new RaceTrack(horses, distance);
 		raceTrack.race();
		int healthy = (int) raceTrack.getRaceHorses().stream()
						.filter(horse -> horse.isHealthy() == true)
						.count();
 		int completed = (int) raceTrack.getRaceHorses().stream()
							.filter(horse -> horse.getDistanceTraveled()>=distance)
							.count();
		assertEquals(healthy, completed);
    }
}