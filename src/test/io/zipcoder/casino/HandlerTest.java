package io.zipcoder.casino;

import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;


public class HandlerTest {



    @Test
    public void createPlayer() {
        Handler handler = new Handler();
        Player player;
        String name = "bob";
        Double account = 100.0;

        player = handler.createPlayer(name, account);

        Assert.assertEquals("bob", player.getName());

    }


    @Test
    public void testAccountInputneg() {
        Handler handler = new Handler();
        Boolean actual = handler.testAccountInput(-2445.0);
        Boolean expeceted = false;

        Assert.assertEquals(expeceted,actual);
    }

    @Test
    public void testAccountInputOver() {
        Handler handler = new Handler();
        Boolean actual = handler.testAccountInput(Double.MAX_VALUE+10);
        Boolean expeceted = false;

        Assert.assertEquals(expeceted,actual);
    }

    @Test
    public void testAccountInputHappy() {
        Handler handler = new Handler();
        Boolean actual = handler.testAccountInput(1000.0);
        Boolean expeceted = true;

        Assert.assertEquals(expeceted,actual);
    }
}