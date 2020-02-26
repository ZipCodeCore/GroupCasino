package io.zipcoder.casino.GameClasses.DiceGames;

import java.util.Random;

public class Dice {
    Integer numOfDice;

    public Dice(Integer numberOfDice){
        this.numOfDice = numberOfDice;
    }

    public Integer rollAndSum(Dice dice){
        Integer sumOfDice = 0;
        Random random = new Random();
        for (int i = 0; i < numOfDice; i++) {
            sumOfDice+= random.nextInt(6)+1;
        }
        return sumOfDice;
    }

    public Integer rollAndSumWithSeed(Dice dice,Integer seed){
        Integer sumOfDice = 0;
        Random random = new Random(seed);
        for (int i = 0; i < numOfDice; i++) {
            sumOfDice+= random.nextInt(6)+1;
        }
        return sumOfDice;
    }
}
