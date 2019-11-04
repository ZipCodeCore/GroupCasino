package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Blackjack.BlackjackGame;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackjackMenuTest {

    private BlackjackMenu blackjackMenu;
    private BlackjackGame blackjackGame;
    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("William", "Adama", 45, 300.00);
        blackjackGame = new BlackjackGame(0.0, 0.0, player);
        blackjackMenu = new BlackjackMenu(blackjackGame);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Blackjack Menu",blackjackMenu.getName());
    }

    @Test
    public void handleChoiceTest1() {
        Assert.assertEquals(0.00,blackjackGame.getMinBet(), .01);
        Assert.assertEquals(0.00,blackjackGame.getMaxBet(), .01);
    }

    @Test
    public void handleChoiceTest2() {
        blackjackMenu.handleChoice(1);
        Assert.assertEquals(5.00,blackjackGame.getMinBet(), .01);
        Assert.assertEquals(25.00,blackjackGame.getMaxBet(), .01);
    }

    @Test
    public void handleChoiceTest3() {
        blackjackMenu.handleChoice(2);
        Assert.assertEquals(20.00,blackjackGame.getMinBet(), .01);
        Assert.assertEquals(100.00,blackjackGame.getMaxBet(), .01);
    }

    @Test
    public void handleChoiceTest4() {
        blackjackMenu.handleChoice(3);
        Assert.assertEquals(50.00,blackjackGame.getMinBet(), .01);
        Assert.assertEquals(250.00,blackjackGame.getMaxBet(), .01);
    }
}