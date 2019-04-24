/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Cat;
import java.io.File;
import java.io.FileWriter;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author Susanna Muhli
 */
public class CatDaoTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File catfile;
    CatDao dao;
    
    @Before
    public void setUp() throws Exception {
        catfile = testFolder.newFile("testfile_cats.txt");
        
        try (FileWriter file = new FileWriter(catfile.getAbsolutePath())) {
            file.write("testname;0;0;0");
        }
        
        dao = new FileCatDao(catfile.getAbsolutePath());
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
