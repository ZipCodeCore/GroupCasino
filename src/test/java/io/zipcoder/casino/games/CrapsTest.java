package io.zipcoder.casino.games;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.zipcoder.casino.Handler;
import io.zipcoder.casino.player.Player;
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
        Craps craps = new Craps();

        craps.getCrapsPlayer().setAccount(10.0);
        Double expected = 10.0;
        Double actual = craps.getCrapsPlayer().getAccount();

        Assert.assertEquals(expected, actual);
    }



    @Test
    public void getOnNumber() {
        Handler handler = new Handler();
        handler.createPlayer("bob" , 100.0);
        Craps craps = new Craps();

        craps.setOnNumber(10);

        Integer expected = 10;
        Integer actual = craps.getOnNumber();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setOnNumber() {
        Handler handler = new Handler();
        handler.createPlayer("bob" , 100.0);
        Craps craps = new Craps();

        craps.setOnNumber(8);

        Integer expected = 8;
        Integer actual = craps.getOnNumber();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFirstLineBet() {
        Handler handler = new Handler();
        handler.createPlayer("bob" , 100.0);
        Craps craps = new Craps();

        craps.setFirstLineBet(10.0);

        Double expected = 10.0;
        Double actual = craps.getFirstLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setFirstLineBet() {
        Handler handler = new Handler();
        handler.createPlayer("bob" , 100.0);
        Craps craps = new Craps();

        craps.setFirstLineBet(10.0);

        Double expected = 10.0;
        Double actual = craps.getFirstLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSecondLineBet() {
        Handler handler = new Handler();
        handler.createPlayer("bob" , 100.0);
        Craps craps = new Craps();

        craps.setSecondLineBet(10.0);

        Double expected = 10.0;
        Double actual = craps.getSecondLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setSecondLineBet() {
        Handler handler = new Handler();
        handler.createPlayer("bob" , 100.0);
        Craps craps = new Craps();

        craps.setSecondLineBet(10.0);

        Double expected = 10.0;
        Double actual = craps.getSecondLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getOtherBet() {
        Handler handler = new Handler();
        handler.createPlayer("bob" , 100.0);
        Craps craps = new Craps();

        craps.setOtherBet(10.0);

        Double expected = 10.0;
        Double actual = craps.getOtherBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setOtherBet() {
        Handler handler = new Handler();
        handler.createPlayer("bob" , 100.0);
        Craps craps = new Craps();

        craps.setOtherBet(10.0);

        Double expected = 10.0;
        Double actual = craps.getOtherBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stage0Play() {
    }

    @Test
    public void stage1PlayLost() {
        Craps craps = new Craps();
        Integer roll = 2;


    }

    @Test
    public void stage2Play() {
    }

    @Test
    public void stage3Play() {
    }

    @Test
    public void withdraw() {
    }

    @Test
    public void deposit() {
    }
}