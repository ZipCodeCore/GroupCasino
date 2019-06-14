package io.zipcoder.casino.player.gameTools;

import com.sun.source.tree.AssertTree;
import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.gameTools.CardValue;
import io.zipcoder.casino.gameTools.Deck;
import io.zipcoder.casino.gameTools.Suit;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    Deck deck = new Deck();

    @Test
    public void getCardValueAce() {
        Card card = deck.getDeck().pop();
        Assert.assertEquals("Ace", CardValue.Ace.name());
    }
    @Test
    public void getCardValueTwo() {
        Card card = deck.getDeck().pop();
        Assert.assertEquals("Two",CardValue.Two.name());
    }

    @Test
    public void getSuitSpades() {
        Card card = deck.getDeck().pop();
        Assert.assertEquals("Spades", Suit.Spades.name());
    }
    @Test
    public void getSuitHearts() {
        Card card = deck.getDeck().pop();
        Assert.assertEquals("Hearts",Suit.Hearts.name());
    }
    @Test
    public void checkObjectTest(){
        Object card = deck.getDeck().pop();
        Assert.assertTrue(card instanceof Card);
    }

}