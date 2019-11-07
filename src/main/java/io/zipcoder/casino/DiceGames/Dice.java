package io.zipcoder.casino.DiceGames;
import io.zipcoder.casino.Interfaces.GamblingGame;

import java.util.ArrayList;


public class Dice {

    // fields-----------------------------------------------------------------------------------------------------------

    private boolean kept;
    private int value;

    // constructor------------------------------------------------------------------------------------------------------

    public Dice(){
        kept = false;
        value = 0;
    }

    // methods----------------------------------------------------------------------------------------------------------

    public void rollDice(){
        this.value = (int)(Math.random() * ((6 - 1) + 1)) + 1;
    }

    public void keptOrRolled(){
        kept = !kept;
    }

    // getters and setters----------------------------------------------------------------------------------------------

    public boolean isKept() {
        return kept;
    }

    public void setKept(boolean kept) {
        this.kept = kept;
    }

    public int getValue() {
        return value;
    }

    // toString---------------------------------------------------------------------------------------------------------

    public String toString(){
        if(this.isKept()){
        return String.format(this.value + " : " + "Keep");
        }
        else{
            return String.format(this.value + " : " + "Re-roll");
        }
    }
    public String toString2(){
        if(this.isKept()){
            return "Keep";
        }
        else{
            return "Re-roll";
        }
    }

}

