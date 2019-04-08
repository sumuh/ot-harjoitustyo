/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Susanna Muhli
 */
public class Cat {
    
    private String name;
    private int hunger;
    private int boredom;
    private int fatigue;
    
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
    
    public void raiseStats() {
        if (this.hunger < 100) {
            this.hunger++;
        }
        if (this.boredom < 100) {
            this.boredom++;
        }
        if (this.fatigue < 100) {
            this.fatigue++;
        }
    }
    
}
