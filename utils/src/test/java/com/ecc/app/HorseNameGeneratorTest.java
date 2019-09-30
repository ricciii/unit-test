package com.ecc.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
 
public class HorseNameGeneratorTest {
 
    @Test
    public void testGenerate() {
 		WarcryGenerator warcryGenerator = new WarcryGenerator();
		warcryGenerator.generate();
 		assertNotNull(warcryGenerator.getList());
    }

    @Test
    public void testGetList() {
 		HorseNameGenerator horseNameGenerator = new HorseNameGenerator();
		horseNameGenerator.generate();
 		assertNotNull(horseNameGenerator.getList());
    }
}