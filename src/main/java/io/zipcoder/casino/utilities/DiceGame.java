package io.zipcoder.casino.utilities;

import java.util.ArrayList;

public abstract class DiceGame implements GamblingGame {
    private int totalNumOfDice;
    ArrayList<Integer> playerDiceHand;
    int pot = 0;
    
    public void addToPot(int numOfChips) {
        pot += numOfChips;
    }

    public void clearPot() {
        pot = 0;
    }

    public int winsPot() {
        return pot;
    }

    public boolean checkWinner() {
        return false;
    }

    public int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
}
