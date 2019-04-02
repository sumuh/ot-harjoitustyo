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

import virtual_cat.logic.Cat;

/**
 *
 * @author Susanna Muhli
 */
public class CatTest {
    
    Cat cat;
    
    @Before
    public void setUp() {
        this.cat = new Cat("catName");
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
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
