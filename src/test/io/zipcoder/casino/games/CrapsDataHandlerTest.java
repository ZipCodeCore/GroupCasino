package io.zipcoder.casino.games;

import io.zipcoder.casino.Handler;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsDataHandlerTest {
    CrapsDataHandler data = new CrapsDataHandler();

    @Test
    public void getOnNumber() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        data.setOnNumber(10);

        Integer expected = 10;
        Integer actual = data.getOnNumber();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setOnNumber() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        data.setOnNumber(8);

        Integer expected = 8;
        Integer actual = data.getOnNumber();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFirstLineBet() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        data.setFirstLineBet(10.0);

        Double expected = 10.0;
        Double actual = data.getFirstLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setFirstLineBet() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        data.setFirstLineBet(10.0);

        Double expected = 10.0;
        Double actual = data.getFirstLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSecondLineBet() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        data.setSecondLineBet(10.0);

        Double expected = 10.0;
        Double actual = data.getSecondLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setSecondLineBet() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        data.setSecondLineBet(10.0);

        Double expected = 10.0;
        Double actual = data.getSecondLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getOtherBet() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        data.setFieldBet(10.0);

        Double expected = 10.0;
        Double actual = data.getFieldBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setOtherBet() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        data.setFieldBet(10.0);

        Double expected = 10.0;
        Double actual = data.getFieldBet();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getFirstLineOdds() {
        data.setFirstLineOdds(10.0);
         Double actual = data.getFirstLineOdds();
         Double expected = 10.0;

         Assert.assertEquals(expected,actual);
    }

    @Test
    public void setFirstLineOdds() {
        data.setFirstLineOdds(10.0);
        Double actual = data.getFirstLineOdds();
        Double expected = 10.0;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getSecondLineOdds() {
        data.setSecondLineOdds(10.0);
        Double actual = data.getSecondLineOdds();
        Double expected = 10.0;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setSecondLineOdds() {
        data.setSecondLineOdds(10.0);
        Double actual = data.getSecondLineOdds();
        Double expected = 10.0;

        Assert.assertEquals(expected,actual);
    }

}