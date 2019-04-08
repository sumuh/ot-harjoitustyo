package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import domain.Cat;

/**
 *
 * @author Susanna Muhli
 */
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
        cat.raiseStats();
        assertEquals(1, cat.getHunger());
        assertEquals(1, cat.getBoredom());
        assertEquals(1, cat.getFatigue());
    }
    
    @Test
    public void raiseStatsWorksWithFullStats() {
        for (int i = 0; i < 101; i++) {
            cat.raiseStats();
        }
        assertEquals(100, cat.getHunger());
        assertEquals(100, cat.getBoredom());
        assertEquals(100, cat.getFatigue());
    }
    
    
    
}
