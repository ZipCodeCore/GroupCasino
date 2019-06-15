package io.zipcoder.casino.player;

import io.zipcoder.casino.player.RoulettePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoulettePlayerTest {
    private RoulettePlayer roulettePlayer;
    @Before
    public void setup() {
        String name = "";
        Double account = 0.0;
        this.roulettePlayer = new RoulettePlayer(name,account);
    }

    @Test
    public void cashoutTest() {
    this.roulettePlayer.cashout();
    Double actual = this.roulettePlayer.getAccount();

    Assert.assertEquals(0.0,actual.doubleValue(),0.0);
    }



}
