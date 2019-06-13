package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    @Test
    public void rollDice() {
        Dice dice = new Dice();
        Integer result = dice.rollDice();

        Assert.assertTrue(result <= 12 && result >=2);
    }
}