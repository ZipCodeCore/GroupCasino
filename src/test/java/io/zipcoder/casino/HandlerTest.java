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

}