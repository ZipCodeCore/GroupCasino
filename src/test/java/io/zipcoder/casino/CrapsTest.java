package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

    //SuperClass tests
    @Test
    public void getPot() {
        //Given
        Craps craps = new Craps();
        int expected = 0;

        //When
        int actual = craps.getPot();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addToPot() {
        //Given
        Craps craps = new Craps();
        int expected = 5;

        //When
        craps.addToPot(5);
        int actual = craps.getPot();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clearPot() {
        //Given
        Craps craps = new Craps();
        int expected = 0;
        craps.addToPot(7);
        craps.clearPot();

        //When
        int actual = craps.getPot();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rollDice() {
        //Given
        Craps craps = new Craps();

        //When
        int result = craps.rollDice();

        //Then
        Assert.assertTrue(result > 0 && result < 7);
    }


    //Unique to Craps
    @Test
    public void setGameRound() {
        //Given
        Craps craps = new Craps();
        int expected = 1;

        //When
        craps.setGameRound(1);
        int actual = craps.getGameRound();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setGetPointer() {
        //Given
        Craps craps = new Craps();
        int expected = 8;

        //When
        craps.setPointer(8);
        int actual = craps.getPointer();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setGetBetStatus() {
        //Given
        Craps craps = new Craps();
        String expected = "Pass";

        //When
        craps.setBetStatus("Pass");
        String actual = craps.getBetStatus();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sumOfDice() {
        //Given
        Craps craps = new Craps();

        //When
        int actual = craps.sumOfDice();

        //Then
        Assert.assertTrue(actual > 1 && actual < 13);
    }

    //Round One Pass Outcomes
    @Test
    public void playerWinsRoundOnePass() {
        //Given
        Craps craps = new Craps();
        int expected = 1;
        craps.setBetStatus("Pass");

        //When
        int dieSum = 7;
        int actual = craps.checkWinnerRoundOne(dieSum);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerLosesRoundOnePass() {
        //Given
        Craps craps = new Craps();
        int expected = 2;
        craps.setBetStatus("Pass");

        //When
        int dieSum = 2;
        int actual = craps.checkWinnerRoundOne(dieSum);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerRollsAgainPass() {
        //Given
        Craps craps = new Craps();
        int expected = 3;
        craps.setBetStatus("Pass");

        //When
        int dieSum = 4;
        int actual = craps.checkWinnerRoundOne(dieSum);

        //Then
        Assert.assertEquals(expected, actual);
    }

    //Round One Not Pass Outcomes
    @Test
    public void playerWinsRoundOneNotPass() {
        //Given
        Craps craps = new Craps();
        int expected = 1;
        craps.setBetStatus("Not Pass");

        //When
        int dieSum = 2;
        int actual = craps.checkWinnerRoundOne(dieSum);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerLosesRoundOneNotPass() {
        //Given
        Craps craps = new Craps();
        int expected = 2;
        craps.setBetStatus("Not Pass");

        //When
        int dieSum = 7;
        int actual = craps.checkWinnerRoundOne(dieSum);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerRollsAgainRoundOneNotPass() {
        //Given
        Craps craps = new Craps();
        int expected = 3;
        craps.setBetStatus("Not Pass");

        //When
        int dieSum = 9;
        int actual = craps.checkWinnerRoundOne(dieSum);

        //Then
        Assert.assertEquals(expected, actual);
    }

    //Round Two Pass Outcomes
    @Test
    public void playerWinsRoundTwoPass() {
        //Given
        Craps craps = new Craps();
        int expected = 1;
        craps.setBetStatus("Pass");
        craps.setPointer(10);

        //When
        int dieSum = 10;
        int actual = craps.checkWinnerRoundTwo(dieSum);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerLosesRoundTwoPass() {
        //Given
        Craps craps = new Craps();
        int expected = 2;
        craps.setBetStatus("Pass");
        craps.setPointer(10);

        //When
        int dieSum = 7;
        int actual = craps.checkWinnerRoundTwo(dieSum);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerRollsAgainRoundTwoPass() {
        //Given
        Craps craps = new Craps();
        int expected = 3;
        craps.setBetStatus("Pass");
        craps.setPointer(10);

        //When
        int dieSum = 4;
        int actual = craps.checkWinnerRoundTwo(dieSum);

        //Then
        Assert.assertEquals(expected, actual);
    }

    //Round Two Not Pass Outcomes
    @Test
    public void playerWinsRoundTwoNotPass() {
        //Given
        Craps craps = new Craps();
        int expected = 1;
        craps.setBetStatus("Not Pass");
        craps.setPointer(10);

        //When
        int dieSum = 7;
        int actual = craps.checkWinnerRoundTwo(dieSum);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerLosesRoundTwoNotPass() {
        //Given
        Craps craps = new Craps();
        int expected = 2;
        craps.setBetStatus("Not Pass");
        craps.setPointer(10);

        //When
        int dieSum = 10;
        int actual = craps.checkWinnerRoundTwo(dieSum);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerRollsAgainRoundTwoNotPass() {
        //Given
        Craps craps = new Craps();
        int expected = 3;
        craps.setBetStatus("Not Pass");
        craps.setPointer(10);

        //When
        int dieSum = 11;
        int actual = craps.checkWinnerRoundTwo(dieSum);

        //Then
        Assert.assertEquals(expected, actual);
    }

}
