/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualcat.domain;

/**
 *
 * @author Susanna Muhli
 */
public class Cat {
    
    private String name;
    private int hunger;
    private int boredom;
    private int fatigue;
    
    public Cat(String name) {
        this.name = name;
        this.hunger = 0;
        this.boredom = 0;
        this.fatigue = 0;
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
    
}
