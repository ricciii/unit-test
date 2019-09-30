package com.ecc.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.Phaser;
 
public class RunnableHorseTest {
 
    @Test
    public void testRun() throws Exception{
    	Phaser phaser = new Phaser();
    	int distance = 200;
 		RunnableHorse horse = new RunnableHorse("Horse1", "Warcry1");
		horse.setDistanceToTravel(distance);
		horse.run();
		assertTrue(horse.getDistanceTraveled()>=distance);
    }
}