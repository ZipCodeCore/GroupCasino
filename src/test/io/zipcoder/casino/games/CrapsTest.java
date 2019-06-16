package io.zipcoder.casino.games;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.zipcoder.casino.Handler;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

    Handler handler = new Handler();
    Player player = handler.createPlayer("", 1000.0);
    CrapsPlayer crapsPlayer = new CrapsPlayer(player);
    Craps craps = new Craps(crapsPlayer);


    @Test
    public void calcPayment() {
        Craps craps = new Craps();

        craps.setOdds(2.0);
        craps.data.setFirstLineBet(10.0);

        Double expected = 20.0;
        Double actual = craps.calcPayment(craps.getOdds(), craps.data.getFirstLineBet());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateAccount() {
        CrapsPlayer crapsPlayer = new CrapsPlayer();

        crapsPlayer.setAccount(10.0);
        Double expected = 10.0;
        Double actual = crapsPlayer.getAccount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void withdraw() {
        craps.withdraw(100.0);
        Double expected = 900.0;
        Double actual = player.getAccount();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void deposit() {
        craps.deposit(100.0);
        Double expected = 1100.0;
        Double actual = player.getAccount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void display() {

    }

    @Test
    public void hasMoenytoBet() {
        Boolean expected = true;
        Boolean actual = craps.hasMoenytoBet(50.0, player);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void stage0PlayPlay() {
        craps.stage0Play("play");

        Integer actual = 1;
        Integer expected = craps.data.getStage();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stage0PlayExit() {
        craps.stage0Play("exit");

        Boolean actual = false;
        Boolean expected = crapsPlayer.player.getPlaying();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stage0PlayInvalidInput() {
        craps.stage0Play("234234");

        Integer actual = 0;
        Integer expected = craps.data.getStage();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void stage1Play() {
        craps.data.setCurrentRoll(10);
        craps.data.setFirstLineBet(500.0);
//
        craps.stage1Play(10.0);

        Integer actual = 2;
        Integer expected = craps.data.getStage();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void stage1PlayCrap() {
        craps.data.setCurrentRoll(7);
        craps.stage1Play(10.0);

        Integer actual = 0;
        Integer expected = craps.data.getStage();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void stage1PlayCrapWin() {
        craps.data.setCurrentRoll(7);

        craps.stage1Play(10.0);

        Double actual = 1010.0;
        Double expected = player.getAccount();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void stage2PlayWinOnNumber() {
        craps.data.setOnNumber(8);
        craps.data.setCurrentRoll(8);
        craps.data.setFirstLineBet(10.0);
        craps.stage2Play(10.0, 10.0, 5);


        Double actual = 1100.0;
        Double expected = player.getAccount();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void stage2PlayWinField() {
        craps.data.setOnNumber(8);
        craps.data.setCurrentRoll(9);
        craps.stage2Play(10.0, 10.0, 9);


        Double actual = 1050.0;
        Double expected = player.getAccount();

        Assert.assertEquals(expected, actual);

    }

    //
    @Test
    public void stage2PlayCrapOut() {
        craps.data.setCurrentRoll(7);
        craps.stage2Play(10.0, 10.0, 5);

        Integer actual = 1;
        Integer expected = craps.data.getStage();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void stage2PlaywinwithOnNumber() {
        craps.data.setOnNumber(4);
        craps.data.setCurrentRoll(4);
        craps.data.setFirstLineBet(10.0);
        craps.stage2Play(100.0, 100.0, 9);


        Double actual = 1680.0;
        Double expected = player.getAccount();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void hasMoenytoBetFalse() {
        Boolean actual = false;
        Boolean expected = craps.hasMoenytoBet(100000.0, player);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasMoenytoBetTrue() {
        Boolean actual = true;
        Boolean expected = craps.hasMoenytoBet(10.0, player);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasMoenytoBetexcat() {
        Boolean actual = true;
        Boolean expected = craps.hasMoenytoBet(1000.0, player);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayCurrentState() {
        String actual =
                "*-----------------------------------*\nCurrent Balance: 1000.0\nPassline Bet: 0.0\nCome Out Bet: 0.0\nOn Number: null\nProp Bet Type: 0\nProb Bet: 0.0\n\n*-----------------------------------*\n";

        String expected = craps.displayCurrentState();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void displayWinningRoll() {
        craps.data.setCurrentRoll(9);

        String actual = craps.displayWinningRoll(10.0);
        String expected = "YOU ROLLED A 9 \n YOU WON 10!";


    }

    @Test
    public void resetFirstRoundState() {

        craps.stage1Play(100.0);


        Boolean expeceted1 = false;
        Boolean actual1 = craps.data.getComeFirstRound();

        craps.resetFirstRoundState();

        Boolean expeceted = true;
        Boolean actual = craps.data.getComeFirstRound();

        Assert.assertEquals(actual,expeceted);
        Assert.assertEquals(actual1,expeceted1);
    }


    @Test
    public void checkForPropBet() {


        Boolean actual1 = craps.checkForPropBet("yes");;
        Boolean expeceted = true;
        Assert.assertEquals(actual1,expeceted);

    }

    @Test
    public void checkForPropBetUppercase() {


        Boolean actual1 = craps.checkForPropBet("Yes");;
        Boolean expeceted = true;
        Assert.assertEquals(actual1,expeceted);

    }

    @Test
    public void checkForPropBetNum() {


        Boolean actual1 = craps.checkForPropBet("3258235");;
        Boolean expeceted = false;
        Assert.assertEquals(actual1,expeceted);

    }



    @Test
    public void keepPlayingOrQuit() {

    }
}