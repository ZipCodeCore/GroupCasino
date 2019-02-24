package io.zipcoder.casino.Casino.GameTest;

import io.zipcoder.casino.Cards.Games.Macao;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class MacaoTest {

    private Macao macao = new Macao();

    @Test
    public void ConstructorTest() {
        // Given macao data
        boolean expectedIsOver = false;
        boolean expectedGuestIsPlaying = true;
        boolean expectedCompIsPlaying = true;

        // When the data is retrieved from the game instance
        boolean actualIsOver = macao.getIsOver();
        boolean actualGuestIsPlaying = macao.getGuestStillPlaying();
        boolean actualCompIsPlaying = macao.getComputerStillPlaying();

        // Then you expect the given data to match the retrieved data
        Assert.assertEquals(expectedIsOver, actualIsOver);
        Assert.assertEquals(expectedGuestIsPlaying ,actualGuestIsPlaying);
        Assert.assertEquals(expectedCompIsPlaying, actualCompIsPlaying);
    }

    @Test
    public void getIsOverTest() {
        // Given an expected boolean exists
        boolean expected = true;

        // When the variable for 'is over' is set to the expected value
        macao.setIsOver(expected);

        // When we retrieve the variable for 'is over' from the game
        boolean actual = macao.getIsOver();

        // We expect the given data to match the retrieved data
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void setIsOverTest() {
        // Given an initial variable for 'is Over' (which is false upon construction)
        boolean initial = macao.getIsOver();

        // When we set the 'is Over' variable to true
        macao.setIsOver(true);

        // When we retrieve the 'is Over' variable from the game
        boolean changed = macao.getIsOver();

        // Then we expect the initial to be false and the changed variable to be true
        Assert.assertFalse(initial);
        Assert.assertTrue(changed);
    }

    @Test
    public void getGuestStillPlayingTest() {
        // Given an expected boolean exists
        boolean expected = true;

        // When the variable for 'guest still playing' is set to the expected value
        macao.setGuestStillPlaying(expected);

        // When we retrieve the variable for 'guest still playing' from the game
        boolean actual = macao.getGuestStillPlaying();

        // We expect the given data to match the retrieved data
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void setGuestStillPlayingTest() {
        // Given an initial variable for 'guest still playing' (which is true upon construction)
        boolean initial = macao.getGuestStillPlaying();

        // When we set the 'guest still playing' variable to true
        macao.setGuestStillPlaying(false);

        // When we retrieve the 'guest still playing' variable from the game
        boolean changed = macao.getGuestStillPlaying();

        // Then we expect the initial to be true and the changed variable to be false
        Assert.assertTrue(initial);
        Assert.assertFalse(changed);
    }

    @Test
    public void getComputerStillPlayingTest() {
        // Given an expected boolean exists
        boolean expected = true;

        // When the variable for 'computer still playing' is set to the expected value
        macao.setComputerStillPlaying(expected);

        // When we retrieve the variable for 'computer still playing' from the game
        boolean actual = macao.getComputerStillPlaying();

        // We expect the given data to match the retrieved data
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void setComputerStillPlayingTest() {
        // Given an initial variable for 'computer still playing' (which is true upon construction)
        boolean initial = macao.getComputerStillPlaying();

        // When we set the 'computer still playing' variable to true
        macao.setComputerStillPlaying(false);

        // When we retrieve the 'computer still playing' variable from the game
        boolean changed = macao.getComputerStillPlaying();

        // Then we expect the initial to be true and the changed variable to be false
        Assert.assertTrue(initial);
        Assert.assertFalse(changed);
    }

    @Test
    public void printGameInstructionsTest() {
        // Given the expected string
        String expected = "GAME: MACAO\nThe object of this game is to roll the die enough times to reach a total of 9 without going over.\nGood luck!\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // When the print game instructions method is called
        macao.printGameInstructions();
        String actual = outputStream.toString();

        // Then we expect the given data to match the retrieved data
        Assert.assertEquals(expected, actual);
    }
}
