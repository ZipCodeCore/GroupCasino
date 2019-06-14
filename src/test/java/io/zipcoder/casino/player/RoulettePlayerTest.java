package io.zipcoder.casino.player;

import io.zipcoder.casino.player.RoulettePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoulettePlayerTest {
    private RoulettePlayer roulettePlayer;
    @Before
    public void setup() {
        this.roulettePlayer = new RoulettePlayer();
    }

    @Test
    public void cashoutTest() {
    this.roulettePlayer.cashout();
    Double actual = this.roulettePlayer.getAccount();
    Assert.assertEquals(2.0,actual.doubleValue(),0.0);
    }



}
