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
}
