package io.zipcoder.casino.games;

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
        craps.data.setFirstLineBet(10.0);
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
}