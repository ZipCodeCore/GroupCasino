package io.zipcoder.casino.RR;

import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Interfaces.GamblingGame;

public class RRGame extends DiceGame implements GamblingGame {

    private String name = "Russian Dice Roulette";

    public String getName() {
        return name;
    }

    @Override
    public double getWager() {
        return 0.0;
    }

    @Override
    public void payOut(double amount) {

    }

    @Override
    public void startPlay() {

    }

    @Override
    public void endChoice() {

    }

    @Override
    public void roundOfPlay() {

    }

    public int selectTargetNum () {
        return 0;
    }

    public boolean evaluateResult (int target, int roll) {
        return false;
    }


}