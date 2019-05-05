package domain;

/**
 * Luokka hallinnoi kissaa ja sen statseja
 */
public class Cat {
    
    private String name;
    private int hunger;
    private int boredom;
    private int fatigue;
    
    /**
     * Luo kissan nimen ja aloitusstatsien perusteella.
     * @param name
     * @param hunger
     * @param boredom
     * @param fatigue 
     */
    public Cat(String name, int hunger, int boredom, int fatigue) {
        this.name = name;
        this.hunger = hunger;
        this.boredom = boredom;
        this.fatigue = fatigue;
    }
    
    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getFatigue() {
        return fatigue;
    }
    
    /**
     * Metodi kasvattaa kaikkkia kissan statseja yhdellä.
     */
    public void raiseAllStats() {
        this.raiseHunger();
        this.raiseBoredom();
        this.raiseFatigue();
    }
    
    /**
     * Metodi kasvattaa nälän arvoa yhdellä, jos tämänhetkinen arvo on pienempi kuin sata.
     */
    public void raiseHunger() {
        if (this.hunger < 100) {
            this.hunger++;
        }
    }
    
    /**
     * Metodi kasvattaa tylsistymisen arvoa yhdellä, jos tämänhetkinen arvo on pienempi kuin sata.
     */
    public void raiseBoredom() {
        if (this.boredom < 100) {
            this.boredom++;
        }
    }
    
    /**
     * Metodi kasvattaa väsymyksen arvoa yhdellä, jos tämänhetkinen arvo on pienempi kuin sata.
     */
    public void raiseFatigue() {
        if (this.fatigue < 100) {
            this.fatigue++;
        }
    }
    
    /**
     * Metodi ruokkii kissan eli resettaa nälän nollaan.
     */
    public void feed() {
        this.hunger = 0;
    }
    
    /**
     * Metodi leikkii kissan kanssa eli resettaa tylsistymisen nollaan.
     */
    public void play() {
        this.boredom = 0;
    }
    
    /**
     * Metodi antaa kissan nukkua eli resettaa väsymyksen nollaan.
     */
    public void sleep() {
        this.fatigue = 0;
    }
    
}
