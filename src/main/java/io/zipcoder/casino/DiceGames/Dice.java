package io.zipcoder.casino.DiceGames;

import io.zipcoder.casino.Interfaces.GamblingGame;

import java.util.ArrayList;

public class Dice implements GamblingGame {


    public static ArrayList<Integer> playerDice = new ArrayList<Integer>(5);

    public static Integer numOfDice = 0;

    public Dice(int numOfDice){}



    public int diceValue(){return 0;}

    public static void roll(int[]numberOfDice){

    }

    public void distributeWinnings(){

    }
}

