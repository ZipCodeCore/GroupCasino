package io.zipcoder.casino.DiceGames;

import io.zipcoder.casino.GamblingGame;

import java.util.ArrayList;

public abstract class DiceGame implements GamblingGame {
    private int totalNumOfDice;
    public ArrayList<Integer> playerDiceHand = new ArrayList<Integer>();
    public int pot = 0;
    
    public void addToPot() {
    }

    public void clearPot() {
        pot = 0;
    }

    public int getPot() {
        return pot;
    }

    public boolean checkWinner() {
        return false;
    }

    public int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
}
