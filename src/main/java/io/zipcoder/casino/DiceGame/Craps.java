package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.GamblingGame;

public class Craps extends DiceGame implements GamblingGame {
    private double pot;
    private int buttonNumber;
    private CrapsPlayer crapsPlayer;

    public void play() {
    }

    public void walkAway() {

    }

    public double payout() {
        return 0;
    }

    public void takeBet(double amount) {
    }


}
