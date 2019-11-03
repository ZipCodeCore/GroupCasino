package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Menus.BlackjackMenu;
import io.zipcoder.casino.Player;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class BlackjackGameTest {

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
    @Parameters({"45.00,45.00", "0.00,0.00", "1000.00,1000.00", "23.00,23.00"})
    public void setMinBet(double input, double expected) {
        blackjackGame.setMinBet(input);
        Assert.assertEquals(expected, blackjackGame.getMinBet(), .01);
    }

    @Test
    @Parameters({"45.00,45.00", "0.00,0.00", "1000.00,1000.00", "23.00,23.00"})
    public void setMaxBet(double input, double expected) {
        blackjackGame.setMaxBet(input);
        Assert.assertEquals(expected, blackjackGame.getMaxBet(), .01);
    }

    @Test
    public void getName() {
        Assert.assertEquals("Blackjack", blackjackGame.getName());
    }

    @Test
    public void startPlay() {
    }

    @Test
    public void initialDealPlayerTest() {
        checkShoe();
        blackjackGame.initialDeal();
        ArrayList<BlackjackHand> allHands = blackjackGame.getHands();
        BlackjackHand playerHand = allHands.get(0);
        Assert.assertEquals(blackjackGame.getPlayer(), playerHand.getPlayer());
        ArrayList<Card> cards = playerHand.getCards().getCards();
        Assert.assertEquals(2, cards.size());
        Assert.assertNotEquals(cards.get(1), cards.get(0));
        System.out.println(cards.get(0).toString() + " " + cards.get(1).toString());
    }
    @Test
    public void initialDealDealerTest() {
        checkShoe();
        blackjackGame.initialDeal();
        ArrayList<BlackjackHand> allHands = blackjackGame.getHands();
        BlackjackHand playerHand = allHands.get(1);
        Assert.assertEquals(blackjackGame.getDealer(), playerHand.getPlayer());
        ArrayList<Card> cards = playerHand.getCards().getCards();
        Assert.assertEquals(2, cards.size());
        Assert.assertNotEquals(cards.get(1), cards.get(0));
        System.out.println(cards.get(0).toString() + " " + cards.get(1).toString());
    }

    @Test
    public void roundOfPlay() {
    }

    @Test
    public void endChoice() {
    }

    @Test
    public void checkShoe() {
        CardSet initialShoe = blackjackGame.getShoe();
        Assert.assertNull(initialShoe);
        blackjackGame.checkShoe();
        CardSet shoe = blackjackGame.getShoe();
        Assert.assertEquals(52*blackjackGame.getNumDecks(),shoe.size());
        for (int i = 1; i < 26*blackjackGame.getNumDecks(); i++){
            shoe.removeFirstCard();
            shoe = blackjackGame.getShoe();
            Assert.assertEquals(52*blackjackGame.getNumDecks()-i,shoe.size());
            blackjackGame.checkShoe();
        }
        shoe.removeFirstCard();
        shoe.removeFirstCard();
        blackjackGame.checkShoe();
        shoe = blackjackGame.getShoe();
        Assert.assertEquals(52*blackjackGame.getNumDecks(),shoe.size());
    }

    @Test
    public void getNewShoe() {
        CardSet shoe = blackjackGame.getNewShoe();
        Assert.assertEquals(52 * blackjackGame.getNumDecks(), shoe.size());
        CardSet shoe2 = blackjackGame.getNewShoe();
        Assert.assertFalse(shoe.getCards().get(0).strictEquals(shoe2.getCards().get(0))
                && shoe.getCards().get(1).strictEquals(shoe2.getCards().get(1))
                && shoe.getCards().get(2).strictEquals(shoe2.getCards().get(2)));
    }

    @Test
    public void calculateWinnings() {
    }
}