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
            newCat.raiseAllStats();
            save(newCat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    };
    
    public void raiseOneStat(String stat) {
        try {
            if (stat.equals("Hunger")) {
                Cat newCat = getCurrentCat();
                newCat.raiseHunger();
                save(newCat);
            } else if (stat.equals("Boredom")) {
                Cat newCat = getCurrentCat();
                newCat.raiseBoredom();
                save(newCat);
            } else if (stat.equals("Fatigue")) {
                Cat newCat = getCurrentCat();
                newCat.raiseFatigue();
                save(newCat);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void feed() {
        try {
            Cat newCat = getCurrentCat();
            newCat.feed();
            save(newCat);
        } catch (Exception e) {
            System.out.println(e.getMessage());   
        }
    }
    
    public void play() {
        try {
            Cat newCat = getCurrentCat();
            newCat.play();
            save(newCat);
        } catch (Exception e) {
            System.out.println(e.getMessage());   
        }
    }
    
    public void sleep() {
        try {
            Cat newCat = getCurrentCat();
            newCat.sleep();
            save(newCat);
        } catch (Exception e) {
            System.out.println(e.getMessage());   
        }
    }
    
    
}
