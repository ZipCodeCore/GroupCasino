package io.zipcoder.casino.DiceGames.Dices;

import java.util.ArrayList;
import java.util.Random;

public class Dice extends DiceGame {

    private int numOfDice;
    private int result;

    public Dice(int numOfDice){
        this.numOfDice = numOfDice;
    }

    public Dice() {

    }

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public int roll2Dices(){
            Random random2 = new Random();
            int dice1 = random2.nextInt(6) + 1;
            int dice2 = random2.nextInt(6) + 1;
            return dice1 + dice2;
    }

    public int roll2Dices2(){
        Random random2 = new Random();
        int dice1 = random2.nextInt(6) + 1;
        int dice2 = random2.nextInt(6) + 1;
        return dice1 + dice2;
    }


}
