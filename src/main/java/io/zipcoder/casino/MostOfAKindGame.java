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
        if (getDealerCount() > getPlayerCount()) {
            return doIWin;
        } else if (getPlayerCount() > getDealerCount()) {
            doIWin = true;
        }
        return doIWin;
    }
}
