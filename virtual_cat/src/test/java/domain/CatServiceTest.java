/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
        this.catDao.clearFile();
    }
    
    @Test
    public void createWorks() throws Exception {
        Cat cat = catService.create("name");
        assertEquals("name", cat.getName());
    }
    
    @Test
    public void saveAndGetFromFileWorks() throws Exception {
        catService.save(cat);
        Cat fileCat = catService.getCurrentCat();
        assertEquals("testCat", fileCat.getName());
    }
    
    @Test
    public void getCurrentCatReturnsNullIfFileIsEmpty() {
        assertEquals(null, catService.getCurrentCat());
    }
    
}
