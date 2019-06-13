package io.zipcoder.casino.player;

import io.zipcoder.casino.Handler;
import io.zipcoder.casino.games.Craps;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsPlayerTest {

    @Test
    public void getName() {
        Handler handler = new Handler();
        CrapsPlayer crapsPlayer = new CrapsPlayer();
        crapsPlayer.setName("bob");

        String actual = crapsPlayer.getName();
        String expected =  "bob";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setName() {
        Handler handler = new Handler();
        CrapsPlayer crapsPlayer = new CrapsPlayer();
        crapsPlayer.setName("bob");

        String actual = crapsPlayer.getName();
        String expected =  "bob";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAccount() {
        Handler handler = new Handler();
        CrapsPlayer crapsPlayer = new CrapsPlayer();
        crapsPlayer.getAccount();

        Double actual = 0.0;
        Double expected = crapsPlayer.getAccount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setAccount() {
        Handler handler = new Handler();
        CrapsPlayer crapsPlayer = new CrapsPlayer();
        crapsPlayer.getAccount();

        Double actual = 0.0;
        Double expected = crapsPlayer.getAccount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void betFirstLine() {
        Handler handler = new Handler();

        Craps craps = new Craps();
        craps.getCrapsPlayer().bet(10.0);

        Double actual = 10.0;
        Double expected = craps.getFirstLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void betSecondLine() {
        Handler handler = new Handler();

        Craps craps = new Craps();
        craps.getCrapsPlayer().bet(10.0);

        Double actual = 10.0;
        Double expected = craps.getSecondLineBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void betOther() {
        Handler handler = new Handler();

        Craps craps = new Craps();
        craps.getCrapsPlayer().bet(10.0);

        Double actual = 10.0;
        Double expected = craps.getOtherBet();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void cashout() {
        Handler handler = new Handler();
        Player player = handler.createPlayer("bob", 10000.0);
        Craps craps = new Craps();
        craps.getCrapsPlayer().bet(10.0);
        craps.getCrapsPlayer().cashout();

        Boolean actual = player.getPlaying();

        Assert.assertEquals(false, actual);
    }
}