package dao;

import domain.Cat;

public interface CatDao {
    
    Cat create(String name);
    
    Cat getFromFile();
    
    void save(Cat cat);
    
}
