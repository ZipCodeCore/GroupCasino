package io.zipcoder.casino.games;

import io.zipcoder.casino.Handler;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

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
        CrapsPlayer crapsPlayer = new CrapsPlayer();

        crapsPlayer.setAccount(10.0);
        Double expected = 10.0;
        Double actual = crapsPlayer.getAccount();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getOnNumber() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        craps.setOnNumber(10);

        Integer expected = 10;
        Integer actual = craps.getOnNumber();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setOnNumber() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        craps.setOnNumber(8);

        Integer expected = 8;
        Integer actual = craps.getOnNumber();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFirstLineBet() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        craps.setFirstLineBet(10.0);

        Double expected = 10.0;
        Double actual = craps.getFirstLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setFirstLineBet() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        craps.setFirstLineBet(10.0);

        Double expected = 10.0;
        Double actual = craps.getFirstLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSecondLineBet() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        craps.setSecondLineBet(10.0);

        Double expected = 10.0;
        Double actual = craps.getSecondLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setSecondLineBet() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        craps.setSecondLineBet(10.0);

        Double expected = 10.0;
        Double actual = craps.getSecondLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getOtherBet() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        craps.setFieldBet(10.0);

        Double expected = 10.0;
        Double actual = craps.getFieldBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setOtherBet() {
        Handler handler = new Handler();
        handler.createPlayer("", 100.0);
        Craps craps = new Craps();

        craps.setFieldBet(10.0);

        Double expected = 10.0;
        Double actual = craps.getFieldBet();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void withdraw() {
        Handler handler = new Handler();
        Player player = handler.createPlayer("", 1000.0);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        Craps craps = new Craps(crapsPlayer);

        craps.withdraw(100.0);
        Double expected = 900.0;
        Double actual = player.getAccount();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void deposit() {
        Handler handler = new Handler();
        Player player = handler.createPlayer("", 1000.0);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        Craps craps = new Craps(crapsPlayer);

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
        Handler handler = new Handler();
        Player player = handler.createPlayer("", 5.0);
        Craps craps = new Craps();

        Boolean expected = false;
        Boolean actual = craps.hasMoenytoBet(50.0, player);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void stage0PlayPlay() {
        Craps craps = new Craps();
        craps.stage0Play("");

        Integer actual = 1;
        Integer expected = craps.getStage();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stage0PlayExit() {
        Handler handler = new Handler();
        Player player = handler.createPlayer("", 1000.0);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        Craps craps = new Craps(crapsPlayer);

        craps.stage0Play("exit");

        Boolean actual = false;
        Boolean expected = crapsPlayer.player.getPlaying();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stage0PlayInvalidInput() {
        Handler handler = new Handler();
        Player player = handler.createPlayer("", 1000.0);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        Craps craps = new Craps(crapsPlayer);

        craps.stage0Play("234234");

        Integer actual = 0;
        Integer expected = craps.getStage();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void stage1Play() {
        Handler handler = new Handler();
        Player player = handler.createPlayer("", 1000.0);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        Craps craps = new Craps(crapsPlayer);

        craps.setCurrentRoll(10);
        craps.stage1Play(10.0);
        Integer currentRoll = craps.getCurrentRoll();

        Integer actual = 10;
        Integer expected = craps.getOnNumber();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void stage1PlayCrap() {
        Handler handler = new Handler();
        Player player = handler.createPlayer("", 1000.0);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        Craps craps = new Craps(crapsPlayer);

        craps.setCurrentRoll(2);
        craps.stage1Play(10.0);


        Integer actual = 0;
        Integer expected = craps.getStage();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void stage1PlayCrapWin() {
        Handler handler = new Handler();
        Player player = handler.createPlayer("", 10.0);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        Craps craps = new Craps(crapsPlayer);

        craps.setCurrentRoll(7);
        craps.stage1Play(10.0);


        Double actual = 30.0;
        Double expected = player.getAccount();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void stage2PlayWinOnNumber() {
        Handler handler = new Handler();
        Player player = handler.createPlayer("", 100.0);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        Craps craps = new Craps(crapsPlayer);

        craps.setOnNumber(8);
        craps.setCurrentRoll(8);
        craps.stage2Play(10.0, 10.0, 5);


        Double actual = 250.0;
        Double expected = player.getAccount();

        Assert.assertEquals(expected, actual);

    }

    //
    @Test
    public void stage2PlayCrapOut() {
        Handler handler = new Handler();
        Player player = handler.createPlayer("", 100.0);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        Craps craps = new Craps(crapsPlayer);

        craps.setCurrentRoll(7);
        craps.stage2Play(10.0, 10.0, 5);

        Integer actual = 0;
        Integer expected = craps.getStage();

        Assert.assertEquals(expected, actual);

    }
}