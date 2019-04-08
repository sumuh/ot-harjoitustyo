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
    private Cat currentCat;
    
    public CatService(CatDao catDao) throws Exception {
        this.catDao = catDao;
        if (catDao.getFromFile() != null) {
            this.currentCat = catDao.getFromFile();
        }
    }
    
    public void setCurrentCat(Cat cat) {
        this.currentCat = cat;
    }
    
    public Cat getCurrentCat() throws Exception{
        return this.catDao.getFromFile();
    }
    
    public Cat create(String name) throws Exception {
        Cat createdCat = this.catDao.create(name);
        this.currentCat = createdCat;
        return createdCat;
    }
    
    public void save() throws Exception {
        this.catDao.save(currentCat);
    }
    
}
