package io.zipcoder.casino;

import io.zipcoder.casino.DiceGames.Craps;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.Player.PlayerFactory;
import org.junit.Assert;
import org.junit.Test;


public class CrapsTest {
    Player gerg = PlayerFactory.createPlayer("gerg", 500);
    Craps craps = new Craps(gerg);

    //SuperClass tests
    @Test
    public void getPot() {
        //Given
        int expected = 0;

        //When
        int actual = craps.getPot();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addToPot() {
        //Given
        int expected = 5;

        //When
        craps.addToPot(5);
        int actual = craps.getPot();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerBalanceAfterBet() {
        //Given
        gerg.setChipBalance(50);
        int expected = 40;

        //When
        craps.addToPot(10);
        int actual = gerg.getChipBalance();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clearPot() {
        //Given
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

        //When
        int result = craps.rollDice();

        //Then
        Assert.assertTrue(result > 0 && result < 7);
    }


    //Unique to Craps
    @Test
    public void setGameRound() {
        //Given
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
        String expected = "PASS";

        //When
        craps.setBetStatus("Pass");
        String actual = craps.getBetStatus();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void betStatusTwo() {
        //Given
        String expected = "NOT PASS";

        //When
        craps.setBetStatus("NoT paSS");
        String actual = craps.getBetStatus();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sumOfDice() {
        //Given

        //When
        craps.sumOfDice();
        int actual = craps.currentSum;


        //Then
        Assert.assertTrue(actual > 1 && actual < 13);
    }

    @Test
    public void getCurrentSum() {
        //Given
        craps.currentSum = 10;
        int expected = 10;

        //When
        int actual = craps.getCurrentSum();

        //Then
        Assert.assertEquals(expected, actual);
    }

    //Round One Pass Outcomes
    @Test
    public void playerWinsRoundOnePass() {
        //Given
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
