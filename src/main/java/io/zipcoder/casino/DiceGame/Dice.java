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


    public int getValue() {
        return value;
    }

    int rollDice(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
