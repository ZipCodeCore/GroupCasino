package io.zipcoder.casino;

import io.zipcoder.casino.DiceGame;

import java.util.ArrayList;

public class MostOfAKindGame extends DiceGame {
    ArrayList<Integer> dealerHand;
    int dealerCount;
    int playerCount;

    public void addToPot(int numOfChips) {
        pot += numOfChips;
    }

    public int getPot() {
        return pot;
    }

    public int getDealerCount() {
        return dealerCount;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public boolean checkWinner() {
        boolean doIWin = false;
        if (getPlayerCount() > getDealerCount()) {
            doIWin = true;
        } else if (getDealerCount() > getPlayerCount()) {
            doIWin = false;
        }
        return doIWin;
    }

    public void addToPlayerCount(int numOfSameNum) {
        playerCount += numOfSameNum;
    }

    public void addToDealerCount(int numOfSameNum) {
        dealerCount += numOfSameNum;
    }
}
