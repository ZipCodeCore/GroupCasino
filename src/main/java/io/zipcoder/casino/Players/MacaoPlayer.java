package io.zipcoder.casino.Players;

import io.zipcoder.casino.Cards.Dice;

import java.util.ArrayList;

public class MacaoPlayer extends Player {

    private int roll;
    private int cumulativeRoll;
    private ArrayList<Integer> diceRolls;

    public MacaoPlayer() {
        this.roll = 0;
        this.cumulativeRoll = 0;
        this.diceRolls = new ArrayList<Integer>();
    }

    public MacaoPlayer(Profile profile) {
        super(profile);
        this.roll = 0;
        this.cumulativeRoll = 0;
        this.diceRolls = new ArrayList<Integer>();
    }

    public Profile getProfile() {
        return super.getProfile();
    }

    public int getRoll() {
        return roll;
    }

    public int getCumulativeRoll() {
        return cumulativeRoll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
        this.cumulativeRoll += roll;
        diceRolls.add(roll);
    }

//    public int[] getDiceArray() {
//        int[] diceArray = new int[diceRolls.size()];
//        for (int i = 0; i < diceArray.length; i++) {
//            diceArray[i] = diceRolls.get(i);
//            }
//        return diceArray;
//    }


    public ArrayList<Integer> getDiceRolls() {
        return diceRolls;
    }

    public void setCumulativeRoll(int roll) {
        this.cumulativeRoll = roll;
    }
}


