package io.zipcoder.casino.DiceGames;
import io.zipcoder.casino.Interfaces.GamblingGame;

import java.util.ArrayList;


public class Dice {
    private boolean kept;
    private int value;

    public Dice(){
        kept = false;
        value = 0;
    }
    public void rollDice(){
        this.value = (int)(Math.random() * ((6 - 1) + 1)) + 1;
    }

    public void keptOrRolled(){
        kept = !kept;
    }

    public boolean isKept() {
        return kept;
    }

    public void setKept(boolean kept) {
        this.kept = kept;
    }

    public int getValue() {
        return value;
    }
    public String toString(){
        return String.format("Value: %d  : Keeping: %b", value, kept);
    }

    public static ArrayList<Integer> playerDice = new ArrayList<Integer>(5);

    public static Integer numOfDice = 0;

    public Dice(int numOfDice){}



    public int diceValue(){return 0;}

    public static void roll(int[]numberOfDice){

    }

    public void distributeWinnings(){

    }
}

