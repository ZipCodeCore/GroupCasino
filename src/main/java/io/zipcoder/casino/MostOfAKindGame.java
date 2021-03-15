package io.zipcoder.casino;

import io.zipcoder.casino.DiceGame;

public class MostOfAKindGame extends DiceGame {
    public void addToPot(int numOfChips) {
        pot += numOfChips;
    }

    public int getPot() {
        return pot;
    }
}
