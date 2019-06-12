package io.zipcoder.casino.games;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsTest {


    @Test
    public void calcPayment() {
        Craps craps = new Craps();

        craps.setOdds(2.0);
        craps.setFirstLineBet(10.0);

        Double expected = 20.0;
        Double actual = craps.calcPayment(craps.odds, craps.getFirstLineBet());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateAccount() {
    }

    @Test
    public void nextTurn() {
    }

    @Test
    public void endGame() {
    }

    @Test
    public void getResults() {
    }

    @Test
    public void display1() {
    }

    @Test
    public void getOn() {
    }

    @Test
    public void setOn() {
    }

    @Test
    public void getOnNumber() {
    }

    @Test
    public void setOnNumber() {
    }

    @Test
    public void getFirstLineBet() {
    }

    @Test
    public void setFirstLineBet() {
    }

    @Test
    public void getSecondLineBet() {
    }

    @Test
    public void setSecondLineBet() {
    }

    @Test
    public void getOtherBet() {
    }

    @Test
    public void setOtherBet() {
    }
}