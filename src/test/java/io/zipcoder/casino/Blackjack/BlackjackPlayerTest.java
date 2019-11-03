package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackjackPlayerTest {

    private Player player;
    private BlackjackPlayer blackjackPlayer;

    @Before
    public void setUp() throws Exception {
        player = new Player ("Steve", "Rondinaro", 56, 400.00);
        blackjackPlayer = new BlackjackPlayer(player);
    }

    @Test
    public void getPlayerTest() {
        Assert.assertEquals(player, blackjackPlayer.getPlayer());
        Assert.assertEquals(400.00, blackjackPlayer.getPlayer().getBalance(),.01);
    }

    @Test
    public void addHandTest1() {
        BlackjackHand blackjackHand = new BlackjackHand(45.00, blackjackPlayer);
        Assert.assertTrue(blackjackPlayer.getHands().size() == 0);
        Assert.assertFalse(blackjackPlayer.getHands().contains(blackjackHand));
        blackjackPlayer.addHand(blackjackHand);
        Assert.assertTrue(blackjackPlayer.getHands().size() == 1);
        Assert.assertTrue(blackjackPlayer.getHands().contains(blackjackHand));
    }

    @Test
    public void addHandTest2() {
        BlackjackHand blackjackHand = new BlackjackHand(45.00, blackjackPlayer);
        blackjackPlayer.addHand(blackjackHand);
        BlackjackHand blackjackHand2 = new BlackjackHand(55.00, blackjackPlayer);
        blackjackPlayer.addHand(blackjackHand2);
        Assert.assertTrue(blackjackPlayer.getHands().size() == 2);
        Assert.assertTrue(blackjackPlayer.getHands().contains(blackjackHand2));
        Assert.assertTrue(blackjackPlayer.getHands().contains(blackjackHand));
    }

    @Test
    public void removeHandTest() {
        BlackjackHand blackjackHand = new BlackjackHand(45.00, blackjackPlayer);
        blackjackPlayer.addHand(blackjackHand);
        BlackjackHand blackjackHand2 = new BlackjackHand(55.00, blackjackPlayer);
        blackjackPlayer.addHand(blackjackHand2);
        Assert.assertTrue(blackjackPlayer.getHands().size() == 2);
        Assert.assertTrue(blackjackPlayer.getHands().contains(blackjackHand2));
        Assert.assertTrue(blackjackPlayer.getHands().contains(blackjackHand));
        blackjackPlayer.removeHand(blackjackHand);
        Assert.assertTrue(blackjackPlayer.getHands().size() == 1);
        Assert.assertTrue(blackjackPlayer.getHands().contains(blackjackHand2));
        Assert.assertFalse(blackjackPlayer.getHands().contains(blackjackHand));
        blackjackPlayer.removeHand(blackjackHand2);
        Assert.assertTrue(blackjackPlayer.getHands().size() == 0);
        Assert.assertFalse(blackjackPlayer.getHands().contains(blackjackHand2));
        Assert.assertFalse(blackjackPlayer.getHands().contains(blackjackHand));
    }
}