/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import domain.Cat;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 *
 * @author Susanna Muhli
 */
public class FileCatDao implements CatDao {
    
    private File file;
    
    //create cat from the information in the file
    
    public FileCatDao(String filename) {
        try {
            this.file = new File(filename);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public Cat create(String name) {
        Cat createdCat = new Cat(name, 0, 0, 0);
        this.save(createdCat);
        return createdCat;
    }
    
    //save current cat in file
    @Override
    public void save(Cat saveCat) {
        try (FileWriter writer = new FileWriter(this.file)) {
            writer.write(saveCat.getName() + ";" + saveCat.getHunger() + ";" + saveCat.getBoredom() + ";" + saveCat.getFatigue());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public Cat getFromFile() {
        Cat cat = null;
        try {
            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine()) {
                String[] stats = scanner.nextLine().split(";");
                String name = stats[0];
                int hunger = Integer.parseInt(stats[1]);
                int boredom = Integer.parseInt(stats[2]);
                int fatigue = Integer.parseInt(stats[3]);
                cat = new Cat(name, hunger, boredom, fatigue);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cat;
    }
    
}
