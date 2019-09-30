package com.ecc.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertThrows;
 
public class RacingHorseGeneratorTest {
 
    @Test()
    public void testGenerate() {

    	ArrayList<String> names = new ArrayList<String>();
    	names.add("Name1");
    	names.add("Name2");
    	ArrayList<String> warcries = new ArrayList<String>();
    	//RacingHorseGenerator generatorError = new RacingHorseGenerator(names, warcries);
    	//assertThrows(Exception.class, () -> {generatorError.generate(2);});
    	warcries.add("Warcry1");
    	warcries.add("Warcry2");
    	warcries.add("Warcry3");
 		RacingHorseGenerator generator = new RacingHorseGenerator(names, warcries);
 		generator.generate(2);
 		assertNotNull(generator.getHorses());
 		assertEquals(2,generator.getHorses().size());
 		generator.generate(3);
 		assertNotNull(generator.getHorses());
 		assertEquals(3,generator.getHorses().size());
 		names.add("Name3");
 		names.add("Name4");
 		generator.generate(4);
 		assertNotNull(generator.getHorses());
 		assertEquals(4,generator.getHorses().size());
 		generator.generate(100);
 		assertNotNull(generator.getHorses());
 		assertEquals(100,generator.getHorses().size());
 		
    }
}