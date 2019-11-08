package io.zipcoder.casino.Games;

import io.zipcoder.casino.Games.Craps.Craps;
import io.zipcoder.casino.PlayerCreation.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CrapsTest {

    Craps craps;
    Player player;


    @Test
    public void rollTest() {

        String input = "\n\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        craps = new Craps();

        int roll = craps.roll();
        Assert.assertTrue(roll > 1 && roll < 13);
    }

    @Test
    public void playAgainTest() {

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        craps = new Craps();

        Assert.assertTrue(craps.playAgain());

    }

    @Test
    public void playAgainTest2() {

        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        craps = new Craps();

        Assert.assertFalse(craps.playAgain());

    }
}