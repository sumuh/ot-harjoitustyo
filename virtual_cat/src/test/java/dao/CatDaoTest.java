package dao;

import domain.Cat;
import java.io.File;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class CatDaoTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File catfile;
    CatDao dao;
    
    @Before
    public void setUp() throws Exception {
        catfile = testFolder.newFile("testfile_cats.txt");
        dao = new FileCatDao(catfile.getAbsolutePath());
        dao.create("testname");
    }
    
    @Test
    public void catIsReadCorrectlyFromFile() {
        Cat cat = dao.getFromFile();
        assertEquals("testname", cat.getName());
        assertEquals(0, cat.getHunger());
        assertEquals(0, cat.getBoredom());
        assertEquals(0, cat.getFatigue());
    }
    
}
