package io.zipcoder.casino;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.zipcoder.casino.DiceGame.Craps;
import io.zipcoder.casino.DiceGame.CrapsPlayer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//Given
//When
//Then


public class CrapsTest {

    private Craps craps;
    private Player player = new Player("Jimmy", 1000);
    private CrapsPlayer crapsPlayer;

    @Before
    public void setup() {
        this.craps = new Craps(player);
        crapsPlayer = craps.getCrapsPlayer();
    }


    @After
    public void tearDown() {
        craps = null;

    }

    @Test
    public void passLineBetTest() {
        //Given
        Double expected = 100.0;
        Double amount = 100.0;

        //When
        craps.passLineBet(amount);
        Double actual = craps.getPassLinePot();

        // Then
        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void passLineOddsBet() {
//    }
//
//    @Test
//    public void comeLineBet() {
//    }
//
//    @Test
//    public void comeLineOddsBet() {
//    }
//
//    @Test
//    public void hardWayBet() {
//    }

    @Test
    public void fieldBetTest() {
        //Given
        Double expected = 100.0;
        Double amount = 100.0;

        //When
        craps.fieldBet(amount);
        Double actual = craps.getFieldBet();

        // Then
        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void placeLineBet() {
//    }

    @Test
    public void askForBet() {
    }

    @Test
    public void clearPassLinePot() {
    }

    @Test
    public void clearfieldPot() {
        Double expected = 0.0;

        craps.fieldBet(100.0);
        craps.clearfieldPot();

        Double actual = craps.getFieldBet();
        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void clearComeLinePot() {
//    }

    @Test
    public void printWallet() {
        Double expected = 1000.0;

        Double actual = player.getWallet();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void checkSetPointOn() {
        craps.setPointOn();

        Assert.assertTrue(craps.getPointOn());
    }

    @Test
    public void checkSetPointOff() {
        craps.setPointOff();

        Assert.assertFalse(craps.getPointOn());
    }

    @Test
    public void checkFieldBetWinner() {
        Double expected = 1100.0;
        craps.fieldBet(100.0);

        craps.checkFieldBetWinner(2, 100.0);
        Double actual = crapsPlayer.getWallet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkFieldBetWinner2() {
        Double expected = 900.0;
        craps.fieldBet(100.0);

        craps.checkFieldBetWinner(1, 100.0);
        Double actual = crapsPlayer.getWallet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPassLineBetWinner() {
        Double expected = 1100.0;
        craps.passLineBet(100.0);

        craps.checkPassLineBetWinner(7, 100.0);
        Double actual = crapsPlayer.getWallet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPassLineBetWinner2() {
        Double expected = 900.0;
        craps.passLineBet(100.0);

        craps.checkPassLineBetWinner(12, 100.0);
        Double actual = crapsPlayer.getWallet();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void checkPassLineBetWinner3() {
        Double expected = 900.0;
        craps.passLineBet(100.0);
        int expectedPoint = 4;

        craps.checkPassLineBetWinner(4, 100.0);
        Double actual = crapsPlayer.getWallet();

        int actualPoint = craps.getPointNumber();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedPoint, actualPoint);
    }


    @Test
    public void checkPassLineBetPhase2() {
        Double expected = 1100.0;
        craps.passLineBet(100.0);
        craps.setPointNumber(4);
        int expectedPoint = 4;

        craps.checkPassLineBetPhase2(4, 100.0);
        Double actual = crapsPlayer.getWallet();

        int actualPoint = craps.getPointNumber();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedPoint, actualPoint);
    }

    @Test
    public void rollDice() {
    }

}
