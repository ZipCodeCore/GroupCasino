package io.zipcoder.casino;

import io.zipcoder.casino.DiceGame;

import java.util.ArrayList;
import java.util.Collection;

public class MostOfAKindGame extends DiceGame {
    ArrayList<Integer> dealerHand = new ArrayList<Integer>();
    int playerNumToMatch;
    int dealerNumToMatch;
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

    public void makeDealerHand(int numOfDice) {
        int i = 0;
        while (i < numOfDice) {
            dealerHand.add(rollDice());
            i++;
        }
    }

    public void makePlayerHand(int numOfDice) {
        int i = 0;
        while (i < numOfDice) {
            playerDiceHand.add(rollDice());
            i++;
        }
    }

    public Collection<Integer> getDealerHand() {
        return this.dealerHand;
    }

    public Collection<Integer> getPlayerHand() {
        return this.playerDiceHand;
    }

}
