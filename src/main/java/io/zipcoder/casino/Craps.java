package io.zipcoder.casino;

public class Craps extends DiceGame {
    int gameRound;
    String passOrNot = "";

    public void addToPot(int numOfChips) {
        pot += numOfChips;
    }

    public int getPot() {
        return pot;
    }
}
