/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.CatDao;

/**
 *
 * @author Susanna Muhli
 */
public class FakeCatDao implements CatDao {

    @Override
    public Cat create(String name) {
        Cat createdCat = new Cat(name, 0, 0, 0);
        return createdCat;
    }

    @Override
    public Cat getFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Cat cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
