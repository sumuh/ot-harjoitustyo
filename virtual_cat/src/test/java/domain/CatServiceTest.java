/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Susanna Muhli
 */
public class CatServiceTest {
    
    FakeCatDao catDao;
    CatService catService;
    Cat cat;
    
    @Before
    public void setup() throws Exception {
        this.catDao = new FakeCatDao();
        this.catService = new CatService(catDao);
        this.cat = catDao.create("testCat");
        this.catService.save(cat);
    }
    
    @After
    public void teardown() {
        this.catDao.clearFile();
    }
    
    @Test
    public void createWorks() throws Exception {
        Cat cat = catService.create("name");
        assertEquals("name", cat.getName());
    }
    
    @Test
    public void saveAndGetFromFileWorks() throws Exception {
        Cat fileCat = catService.getCurrentCat();
        assertEquals("testCat", fileCat.getName());
    }
    
    @Test
    public void getCurrentCatThrowsException() {
        catDao.clearFile();
        assertEquals(null, catService.getCurrentCat());
    }
    
    @Test
    public void raiseCurrentCatStatsWork() {
        catService.raiseCurrentCatStats();
        assertEquals(1, catService.getCurrentCat().getHunger());
        assertEquals(1, catService.getCurrentCat().getBoredom());
        assertEquals(1, catService.getCurrentCat().getFatigue());
    }
    
    @Test
    public void raiseOneStatWorksWithHunger() {
        catService.raiseOneStat("Hunger");
        assertEquals(1, catService.getCurrentCat().getHunger());
        assertEquals(0, catService.getCurrentCat().getBoredom());
        assertEquals(0, catService.getCurrentCat().getFatigue());
    }
    
    @Test
    public void raiseOneStatWorksWithBoredom() {
        catService.raiseOneStat("Boredom");
        assertEquals(0, catService.getCurrentCat().getHunger());
        assertEquals(1, catService.getCurrentCat().getBoredom());
        assertEquals(0, catService.getCurrentCat().getFatigue());
    }
    
    @Test
    public void raiseOneStatWorksWithFatigue() {
        catService.raiseOneStat("Fatigue");
        assertEquals(0, catService.getCurrentCat().getHunger());
        assertEquals(0, catService.getCurrentCat().getBoredom());
        assertEquals(1, catService.getCurrentCat().getFatigue());
    }
    
//    @Test(expected = Exception.class)
//    public void raiseOneStatThrowsException() {
//        catDao.clearFile();
//        catService.raiseOneStat("Test");
//    }
    
    @Test
    public void feedWorks() {
        catService.raiseOneStat("Hunger");
        catService.feed();
        assertEquals(0, catService.getCurrentCat().getHunger());
    }
    
    @Test
    public void playWorks() {
        catService.raiseOneStat("Boredom");
        catService.play();
        assertEquals(0, catService.getCurrentCat().getBoredom());
    }
    
    @Test
    public void sleepWorks() {
        catService.raiseOneStat("Fatigue");
        catService.sleep();
        assertEquals(0, catService.getCurrentCat().getFatigue());
    }
}
