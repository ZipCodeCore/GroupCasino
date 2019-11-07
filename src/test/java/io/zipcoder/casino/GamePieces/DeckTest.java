package io.zipcoder.casino.GamePieces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void cardsLeft1() {
        Deck deck = new Deck();
        Integer expected = 52;
        Integer actual = deck.cardsLeft();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void cardsLeft2() {
        Deck deck = new Deck();
        Integer expected = 52;
        deck.draw();
        Integer actual = deck.cardsLeft() - 1;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shuffle() {
    }

    @Test
    public void draw() {
        Deck deck = new Deck();
        Integer expected = 52;
        deck.draw();
        Integer actual = deck.cardsLeft() - 1;

        Assert.assertEquals(expected,actual);
        }
    }
