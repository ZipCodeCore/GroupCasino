package io.zipcoder.casino.player;

import io.zipcoder.casino.Handler;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() {
        Player player = new Player("bob" , 100.0);
        Assert.assertEquals("bob", player.getName());
    }

    @Test
    public void setName() {
        Player player = new Player();
        player.setName("bob");
        Assert.assertEquals("bob", player.getName());
    }

    @Test
    public void getAccount() {
        Player player = new Player("bob", 10000.0);
        Double expected = 10000.0;
        Double actual = player.getAccount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setAccount() {
        Player player = new Player();
        player.setAccount(100.0);
        Double expected = 100.0;
        Double actual = player.getAccount();
        Assert.assertEquals(expected, actual);
    }
}