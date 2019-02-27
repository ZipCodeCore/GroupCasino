package io.zipcoder.casino.casino.GameTest;

import io.zipcoder.casino.casino.games.dicegames.diceutilities.LoadedDice;
import org.junit.Assert;
import org.junit.Test;

public class LoadedDiceTest {

    @Test
    public void rollTest() {
        // Given a set of loaded dice exist and we expect a roll of 5
        LoadedDice dice = new LoadedDice(5);
        int expected = 5;

        // When we roll the loaded die
        int actual = dice.roll();

        // Then we expect the given value and retrieved to be the same
        Assert.assertEquals(expected, actual);

    }
}
