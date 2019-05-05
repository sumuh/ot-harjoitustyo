package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CatTest {
    
    Cat cat;
    
    @Before
    public void setUp() {
        this.cat = new Cat("catName", 0, 0, 0);
    }
    
    @Test
    public void constructorSetsNameRight() {
        assertEquals("catName", cat.getName());
    }
    
    @Test
    public void constructorSetsCorrectStats() {
        assertEquals(0, cat.getHunger());
        assertEquals(0, cat.getBoredom());
        assertEquals(0, cat.getFatigue());
    }
    
    @Test
    public void raiseStatsWorksWithZeroStats() {
        cat.raiseAllStats();
        assertEquals(1, cat.getHunger());
        assertEquals(1, cat.getBoredom());
        assertEquals(1, cat.getFatigue());
    }
    
    @Test
    public void raiseStatsWorksWithFullStats() {
        for (int i = 0; i < 101; i++) {
            cat.raiseAllStats();
        }
        assertEquals(100, cat.getHunger());
        assertEquals(100, cat.getBoredom());
        assertEquals(100, cat.getFatigue());
    }
    
    @Test
    public void raiseHungerWorksWithZeroHunger() {
        cat.raiseHunger();
        assertEquals(1, cat.getHunger());
        assertEquals(0, cat.getBoredom());
        assertEquals(0, cat.getFatigue());
    }
    
    @Test
    public void raiseBoredomWorksWithZeroBoredom() {
        cat.raiseBoredom();
        assertEquals(0, cat.getHunger());
        assertEquals(1, cat.getBoredom());
        assertEquals(0, cat.getFatigue());
    }
    
    @Test
    public void raiseFatigueWorksWithZeroFatigue() {
        cat.raiseFatigue();
        assertEquals(0, cat.getHunger());
        assertEquals(0, cat.getBoredom());
        assertEquals(1, cat.getFatigue());
    }
    
    @Test
    public void raiseHungerWorksWithFullStats() {
        for (int i = 0; i < 101; i++) {
            cat.raiseHunger();
        }
        assertEquals(100, cat.getHunger());
        assertEquals(0, cat.getBoredom());
        assertEquals(0, cat.getFatigue());
    }
    
    @Test
    public void raiseBoredomWorksWithFullBoredom() {
        for (int i = 0; i < 101; i++) {
            cat.raiseBoredom();
        }
        assertEquals(0, cat.getHunger());
        assertEquals(100, cat.getBoredom());
        assertEquals(0, cat.getFatigue());
    }
    
    @Test
    public void raiseFatigueWorksWithFullFatigue() {
        for (int i = 0; i < 101; i++) {
            cat.raiseFatigue();
        }
        assertEquals(0, cat.getHunger());
        assertEquals(0, cat.getBoredom());
        assertEquals(100, cat.getFatigue());
    }
    
    @Test
    public void feedWorks() {
        for (int i = 0; i < 20; i++) {
            cat.raiseHunger();
        }
        cat.feed();
        assertEquals(0, cat.getHunger());
    }
    
    @Test
    public void playWorks() {
        for (int i = 0; i < 20; i++) {
            cat.raiseBoredom();
        }
        cat.play();
        assertEquals(0, cat.getBoredom());
    }
    
    @Test
    public void sleepWorks() {
        for (int i = 0; i < 20; i++) {
            cat.raiseFatigue();
        }
        cat.sleep();
        assertEquals(0, cat.getFatigue());
    }
    
    
    
}
