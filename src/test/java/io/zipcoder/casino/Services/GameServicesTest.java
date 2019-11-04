package io.zipcoder.casino.Services;

import io.zipcoder.casino.Blackjack.BlackjackGame;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameServicesTest {

    private Player player;
    private BlackjackGame blackjackGame;
    private GameServices gameServices;
    @Before
    public void setUp() throws Exception {
        player = new Player ("Jeff", "Steinbeck", 35, 200.00);
        gameServices = new GameServices();
    }

    @Test
    public void getWagerTest() {
        Assert.assertFalse(gameServices.getWager(300.00, player));
    }

    @Test
    public void getWagerTest2() {
        Assert.assertTrue(gameServices.getWager(100.00, player));
        Assert.assertEquals(100.00, player.getBalance(), .01);
    }

    @Test
    public void getWagerTest3() {
        Assert.assertTrue(gameServices.getWager(199.00, player));
        Assert.assertEquals(1.00, player.getBalance(), .01);
    }

    @Test
    public void payOut() {
        gameServices.payOut(100.00, player);
        Assert.assertEquals(300.00, player.getBalance(), .01);
    }

    @Test
    public void payOut2() {
        gameServices.payOut(0.00, player);
        Assert.assertEquals(200.00, player.getBalance(), .01);
    }
}