package com.ecc.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
 
public class WarcryGeneratorTest {
 
    @Test
    public void testGenerate() {
 		WarcryGenerator warcryGenerator = new WarcryGenerator();
		warcryGenerator.generate();
 		assertNotNull(warcryGenerator.getList());
    }

    @Test
    public void testGetList() {
 		WarcryGenerator warcryGenerator = new WarcryGenerator();
		warcryGenerator.generate();
 		assertNotNull(warcryGenerator.getList());
    }
}