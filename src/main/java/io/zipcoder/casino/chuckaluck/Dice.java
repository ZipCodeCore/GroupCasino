package io.zipcoder.casino.chuckaluck;

import java.util.ArrayList;
import java.util.Random;

public class Dice {

    //declare a field of type Random named random


    private int numbersOfDice;
    Random random;
    private ArrayList<Integer> tossResults;
    private int roll;


    //create an empty constructor

    public Dice() {
        Random randomroll = new Random();
    }
    //in the body, set the field random to
    // a new Random instance

    public int roll() {
        return random.nextInt(6);
    }

    public void toss() {
        tossResults.clear();
        for (int i = 1; i <= numbersOfDice; i++) {
            tossResults.add(randomDiceToss());
        }
    }

    public Integer getSum() {
        Integer sum = 0;
        for (int result : tossResults) {
            sum = sum + result;
        }
        return sum;
    }

    private int randomDiceToss() {
        return random.nextInt(6);
    }

    public Integer[] getResults() {
        return getResults();

        //create a constructor that takes a Random
        //set the random to the field

        //create a method named roll that takes
        //no param and return an int
        //the method will call nextInt on random
        // the number should be between 1 - 6
    }

}