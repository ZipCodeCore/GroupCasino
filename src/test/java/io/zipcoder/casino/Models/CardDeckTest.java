package io.zipcoder.casino.Models;

import org.junit.Assert;
import org.junit.Test;

import static java.util.Collections.shuffle;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Stack;

public class CardDeckTest {





    @Test
    public void shuffleDeck1() {
        CardDeck deck1 = new CardDeck();


        Card card1 = deck1.peekAtTopCard();

        Stack deck2 = deck1.shuffleDeck();

        Card card2 = (Card) deck2.peek();

        Assert.assertNotEquals(card1.getValue(),card2.getValue());
    }


    @Test
    public void peekAtTopCard() {
            CardDeck deck = new CardDeck();

             Card card1 = deck.peekAtTopCard();
        Card card2 = deck.dealNextCard();

        Assert.assertEquals(card1, card2);
    }


    @Test
    public void dealNextCard() {

        CardDeck deck = new CardDeck();

        Card card1 = deck.peekAtTopCard();
        Card card2 = deck.dealNextCard();

        Assert.assertEquals(card2, card1);
    }
}