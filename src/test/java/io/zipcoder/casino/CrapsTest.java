package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

    @Test
    public void getPot() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        int expected = 0;

        //When
        int actual = yahtzee.getPot();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addToPot() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        int expected = 5;

        //When
        yahtzee.addToPot(5);
        int actual = yahtzee.getPot();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clearPot() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        int expected = 0;
        yahtzee.addToPot(7);
        yahtzee.clearPot();

        //When
        int actual = yahtzee.getPot();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rollDice() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();

        //When
        int result = yahtzee.rollDice();

        //Then
        Assert.assertTrue(result > 0 && result < 7);
    }

    @Test
    public void checkWinner() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        boolean expected = false;

        //When
        boolean actual = yahtzee.checkWinner();

        //Then
        Assert.assertEquals(expected, actual);
    }
}
