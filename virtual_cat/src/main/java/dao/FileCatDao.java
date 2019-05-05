package dao;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import domain.Cat;

/**
 *Luokka huolehtii kissan tietojen tallentamisesta tiedostoon. Luokka toteuttaa CatDao-rajapinnan.
 */
public class FileCatDao implements CatDao {
    
    private String file;
    
    /**
     * Konstruktori saa parametrina tiedoston nimen ja asettaa sen oliomuuttujan nimeksi. 
     * @param filename kertoo tiedoston nimen, johon kissan tiedot halutaan tallentaa
     */
    public FileCatDao(String filename) {
        try {
            this.file = filename;
        } catch (Exception e) {
            System.out.println(e.getMessage() + "virhe");
        }
    }
    
    /**
     * Luo kissan annetun nimen perusteella ja asettaa alkustatseiksi nollat sekä tallentaa uuden kissan tiedostoon.
     * @param name käyttäjän syöttämä nimi
     * @return luotu kissa
     */
    @Override
    public Cat create(String name) {
        Cat createdCat = new Cat(name, 0, 0, 0);
        this.save(createdCat);
        return createdCat;
    }
    
    /**
     * Tallentaa parametrina saadun kissan tiedostoon.
     * @param saveCat kissa joka halutaan tallentaa
     */
    @Override
    public void save(Cat saveCat) {
        try (FileWriter writer = new FileWriter(new File(this.file))) {
            writer.write(saveCat.getName() + ";" + saveCat.getHunger() + ";" + saveCat.getBoredom() + ";" + saveCat.getFatigue());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Palauttaa tämänhetkisen tiedostossa olevan kissan. Jos tiedosto on tyhjä, palauttaa null.
     * @return tiedostosta löytynyt kissa tai null
     */
    @Override
    public Cat getFromFile() {
        Cat cat = null;
        try {
            Scanner scanner = new Scanner(new File(this.file));
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
