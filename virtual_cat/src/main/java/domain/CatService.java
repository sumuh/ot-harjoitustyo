/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.IOException;
import dao.FileCatDao;
import dao.CatDao;

/**
 *
 * @author Susanna Muhli
 */
public class CatService {
    
    //this class manages stats etc
    
    private CatDao catDao;
    
    public CatService(CatDao catDao) throws Exception {
        this.catDao = catDao;
//        if (catDao.getFromFile() != null) {
//            this.currentCat = catDao.getFromFile();
//        }
    }
    
    public Cat getCurrentCat() {
        try {
            return this.catDao.getFromFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public Cat create(String name) throws Exception {
        Cat createdCat = this.catDao.create(name);
        //this.currentCat = createdCat;
        return createdCat;
    }
    
    public void save(Cat cat) {
        try {
            this.catDao.save(cat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void raiseCurrentCatStats() {
        try {
            Cat newCat = getCurrentCat();
            newCat.raiseStats();
            save(newCat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    };
    
    
    
}
