package io.zipcoder.casino;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Deck;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Logger;


public class DeckTest {

    private static final Logger LOGGER = Logger.getLogger(DeckTest.class.getName());


    @Test
    public void testCreateDeck() {
        Deck deck = new Deck();

        Integer expected = 52;

        deck.createDeck();
        Integer actual = deck.getDeck().size();

        Assert.assertEquals(expected, actual);
        LOGGER.info("\n" + actual);
    }

    @Test
    public void testGetDeck() {
        Deck deck = new Deck();
        deck.createDeck();

        Assert.assertFalse(deck.isEmpty());
        Assert.assertTrue(!deck.isEmpty());
    }

    @Test
    public void testPopCard() {
        Deck deck = new Deck();
        deck.createDeck();

        deck.popCard();
        Integer actualDeckSize = deck.getDeck().size();
        Integer remainingCards = 51;
        Assert.assertEquals(remainingCards, actualDeckSize);
    }

    @Test
    public void testPrintDeck() {
        Deck deck = new Deck();
        deck.createDeck();
        deck.printDeck();
    }

    @Test
    public void testShuffleDeck() {
        Deck deck = new Deck();
        deck.createDeck();
        deck.stackToArray();
        deck.shuffle();
        deck.arrayListToStack();
        deck.printDeck();
    }

    @Test
    public void testStackToArray() {
        Deck deck = new Deck();
        deck.createDeck();
        deck.stackToArray();

        Integer actual = deck.getTempArrayList().size();
        Integer expected = 52;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrintShuffledStack() {
        Deck deck = new Deck();
        deck.createDeck();
        deck.stackToArray();
        deck.shuffle();
        deck.arrayListToStack();

        LOGGER.info("\n" + deck.peekStack());
    }

}
