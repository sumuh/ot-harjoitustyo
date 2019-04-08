/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
        this.cat = new Cat("testCat", 0, 0, 0); 
    }
    
}
