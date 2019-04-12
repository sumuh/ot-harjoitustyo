/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.CatDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Susanna Muhli
 */
public class FakeCatDao implements CatDao {
    
    //simulates the file that normal dao uses
    List<Cat> fakeFile;
    
    public FakeCatDao() {
        fakeFile = new ArrayList<>();
    }
    
    public void clearFile() {
        this.fakeFile.clear();
    }

    @Override
    public Cat create(String name) {
        Cat createdCat = new Cat(name, 0, 0, 0);
        return createdCat;
    }

    @Override
    public Cat getFromFile() {
        return this.fakeFile.get(0);
    }

    @Override
    public void save(Cat cat) {
        this.fakeFile.add(cat);
    }
    
}
