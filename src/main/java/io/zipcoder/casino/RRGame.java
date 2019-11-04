package io.zipcoder.casino;

import sun.jvm.hotspot.utilities.Assert;

public class RRGame extends DiceGame implements GamblingGame {


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

           public int testRoll() {
            int expected = DiceGame.roll(1, 6);
        }

        Assert.assertTrue((expected >=1 && expected <=6));

    }
    }

    public int selectTargetNum () {
        return 0;
    }

    public boolean evaluateResult (int target, int roll) {
        return false;
    }


}