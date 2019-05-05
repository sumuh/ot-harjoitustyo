package domain;

import dao.CatDao;
import java.util.ArrayList;
import java.util.List;

public class FakeCatDao implements CatDao {
    
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
