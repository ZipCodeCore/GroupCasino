package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class MostOfAKindTests {

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
    public void addToPlayerCount() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.addToPlayerCount(3);
        int expected = 3;

        //When
        int actual = yahtzee.getPlayerCount();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkWinnerDealer() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.addToPlayerCount(3);
        yahtzee.addToDealerCount(4);

        //When
        boolean actual = yahtzee.checkWinner();

        //Then
        Assert.assertFalse(actual);
    }

    @Test
    public void checkWinnerPlayer() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();
        yahtzee.addToPlayerCount(4);
        yahtzee.addToDealerCount(2);

        //When
        boolean actual = yahtzee.checkWinner();

        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void makeDealerHand() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();

        //When
        yahtzee.makeDealerHand(5);
        int actual = yahtzee.getDealerHand().size();

        //Then
        Assert.assertEquals(5, actual);
    }

    @Test
    public void makePlayerHand() {
        //Given
        MostOfAKindGame yahtzee = new MostOfAKindGame();

        //When
        yahtzee.makePlayerHand(5);
        int actual = yahtzee.getPlayerHand().size();

        //Then
        Assert.assertEquals(5, actual);
    }

}
