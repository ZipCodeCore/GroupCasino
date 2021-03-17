package io.zipcoder.casino.DiceGames.Dices;

import java.util.ArrayList;
import java.util.Random;

public class Dice {

    private int numOfDice;
    private int result;

    public Dice(int numOfDice){
        this.numOfDice = numOfDice;
    }

    public int rollDice(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
