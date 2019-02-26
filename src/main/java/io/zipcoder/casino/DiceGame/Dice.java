package io.zipcoder.casino.DiceGame;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    private int numberOfDice;
    private int value;

    public Dice(int numberOfDice){
        this.numberOfDice = numberOfDice;
    }

    public Dice(int numberOfDice, int value){
        this.numberOfDice = numberOfDice;
        this.value = value;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    int rollDice(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
