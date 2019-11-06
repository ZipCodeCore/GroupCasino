package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoFishPlayerTest {

    private Player player;
    private GoFishPlayer goFishPlayer;

    @Before
    public void before() {
        player = new Player("Scrubby", "Bubbles", 7, 6);
        goFishPlayer = new GoFishPlayer(player);
    }

    @Test
    public void getPlayerTest() {
        Assert.assertEquals(player, goFishPlayer.getPlayer());
        Assert.assertEquals(6, goFishPlayer.getPlayer().getBalance(),.01);


    }
    @Test
    public void getPlayerNameTest(){

    }
}
