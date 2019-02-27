package io.zipcoder.casino.Casino.GameTest;

import io.zipcoder.casino.CardsAndDice.LoadedDice;
import org.junit.Assert;
import org.junit.Test;

public class LoadedDiceTest {

    @Test
    public void rollTest() {
        // Given a set of loaded dice exist and we expect a roll of 6
        LoadedDice dice = new LoadedDice();
        int expected = 5;

        // When we roll the loaded die
        int actual = dice.roll();

        // Then we expect the given value and retrieved to be the same
        Assert.assertEquals(expected, actual);

    }
}
