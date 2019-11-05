package io.zipcoder.casino.DiceGames;

import io.zipcoder.casino.Interfaces.GamblingGame;

import java.util.ArrayList;

public abstract class Dice implements GamblingGame {

    public static ArrayList<Integer> dealerDice = new ArrayList<Integer>(5);
    public static ArrayList<Integer> playerDice = new ArrayList<Integer>(5);
    public static ArrayList<Integer> heldDice = new ArrayList<Integer>(5);
    public static Integer numOfDice = 0;


    public Dice(){}

    public int diceValue(){return 0;}

    public static void createDiceAndroll(int[]numberOfDice){ }
}

