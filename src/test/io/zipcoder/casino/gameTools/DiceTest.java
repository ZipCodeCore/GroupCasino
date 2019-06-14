package io.zipcoder.casino.gameTools;

import io.zipcoder.casino.gameTools.Dice;
import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    @Test
    public void rollDice() {
        Dice dice = new Dice();
        Integer result = dice.rollDice();

        Assert.assertTrue(result <= 12 && result >=2);
    }


}