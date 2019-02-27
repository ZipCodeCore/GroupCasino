package io.zipcoder.casino.Players;

import java.util.ArrayList;

public class MacaoPlayer extends Player {

    private int roll;
    private int cumulativeRoll;
    private ArrayList<Integer> diceRolls;

    public MacaoPlayer() {
        this.roll = 0;
        this.cumulativeRoll = 0;
        this.diceRolls = new ArrayList<>();
    }

    public MacaoPlayer(Profile profile) {
        super(profile);
        this.roll = 0;
        this.cumulativeRoll = 0;
        this.diceRolls = new ArrayList<>();
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



    public ArrayList<Integer> getDiceRolls() {
        return diceRolls;
    }

    public void setCumulativeRoll(int roll) {
        this.cumulativeRoll = roll;
    }
}


