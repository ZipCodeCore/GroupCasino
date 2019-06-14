package io.zipcoder.casino.games;

import io.zipcoder.casino.Handler;
import io.zipcoder.casino.games.Craps;
import io.zipcoder.casino.games.CrapsDataHandler;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {
CrapsDataHandler data = new CrapsDataHandler();

    @Test
    public void calcPayment() {
        Craps craps = new Craps();

        craps.setOdds(2.0);
        data.setFirstLineBet(10.0);

        Double expected = 20.0;
        Double actual = craps.calcPayment(craps.getOdds(), data.getFirstLineBet());

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
        Handler handler = new Handler();
        Player player = handler.createPlayer("", 1000.0);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        Craps craps = new Craps(crapsPlayer );

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
        Handler handler = new Handler();
        Player player = handler.createPlayer("", 1000.0);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        Craps craps = new Craps(crapsPlayer);
        craps.stage0Play("play");

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

        data.setCurrentRoll(10);
        craps.stage1Play(100.0);

        Integer actual = 2;
        Integer expected = craps.getStage();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void stage1PlayCrap() {
        Handler handler = new Handler();
        Player player = handler.createPlayer("", 1000.0);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        Craps craps = new Craps(crapsPlayer);

        data.setCurrentRoll(7);
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

        data.setCurrentRoll(7);
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

        data.setOnNumber(8);
        data.setCurrentRoll(8);
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

        data.setCurrentRoll(7);
        craps.stage2Play(10.0, 10.0, 5);

        Integer actual = 0;
        Integer expected = craps.getStage();

        Assert.assertEquals(expected, actual);

    }
}