package io.zipcoder.casino;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class RRGameTest{



    @Test
    public void roll() {
    public void testRoll() {
        int expected = DiceGame.roll(1, 6);
        }

        Assert.assertTrue((expected >=1 && expected <=6));

        }

    @Test
    public void getWager() {
    }

    @Test
    public void payOut() {
    }

    @Test
    public void startPlay() {
    }

    @Test
    public void endChoice() {
    }

    @Test
    public void roundOfPlay() {
    }

    @Test
    public void selectTargetNum() {
    }

    @Test
    public void evaluateResult() {
    }
}
