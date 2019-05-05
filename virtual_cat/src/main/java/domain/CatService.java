package domain;

import dao.CatDao;

/**
 *Luokka toimii ui:n ja dao:n välisenä kommunikaationa. Luokka tarjoaa metodit joita ui tarvitsee ja hyödyntää niissä dao:n metodeita.
 */
public class CatService {
    
    private CatDao catDao;
    
    /**
     * Konstruktori saa parametrina daon jonka metodeja se hyödyntää.
     * @param catDao Ui:ssa luotu dao
     * @throws Exception 
     */
    public CatService(CatDao catDao) throws Exception {
        this.catDao = catDao;
    }
    
    /**
     * Metodi palauttaa tällä hetkellä tiedostossa olevan kissan oliona.
     * @return tämänhetkinen kissaolio
     */
    public Cat getCurrentCat() {
        try {
            return this.catDao.getFromFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    /**
     * Metodi luo uuden kissan ja palauttaa sen.
     * @param name käyttäjän määrittelemä nimi
     * @return luotu kissa
     * @throws Exception 
     */
    public Cat create(String name) throws Exception {
        Cat createdCat = this.catDao.create(name);
        return createdCat;
    }
    
    /**
     * Tallentaa parametrina saadun kissan tiedostoon.
     * @param cat 
     */
    public void save(Cat cat) {
        try {
            this.catDao.save(cat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Nostaa kaikkia tiedostossa olevan kissan statseja yhdellä ja tallentaa uuden kissan tiedostoon.
     */
    public void raiseCurrentCatStats() {
        try {
            Cat newCat = getCurrentCat();
            newCat.raiseAllStats();
            save(newCat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    };
    
    
    /**
     * Nostaa parametrina annettua yksittäistä statsia yhdellä ja tallentaa uuden kissan tiedostoon.
     * @param stat määrittelee sen, mitä statsia nostetaan
     */
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
    
    /**
     * Ruokkii kissan ja tallentaa sen tiedostoon.
     */
    public void feed() {
        try {
            Cat newCat = getCurrentCat();
            newCat.feed();
            save(newCat);
        } catch (Exception e) {
            System.out.println(e.getMessage());   
        }
    }
    
    /**
     * Leikkii kissan kanssa ja tallentaa sen tiedostoon.
     */
    public void play() {
        try {
            Cat newCat = getCurrentCat();
            newCat.play();
            save(newCat);
        } catch (Exception e) {
            System.out.println(e.getMessage());   
        }
    }
    
    /**
     * Antaa kissan nukkua ja tallentaa sen tiedostoon.
     */
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
