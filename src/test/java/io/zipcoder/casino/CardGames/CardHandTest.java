package io.zipcoder.casino.CardGames;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.ArrayList;
import java.util.List;

public class CardHandTest {


    @Test
    public void testCardHand() {
        ArrayList<Card> dealtCards = new ArrayList<>();
        Deck newDeck = new Deck(1);
        dealtCards = newDeck.dealCards(2);

        CardHand testCardHand = new CardHand(dealtCards);

        int expected = 2;
        int actual = testCardHand.userHand.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDisplayHand() {
        ArrayList<Card> dealtCards = new ArrayList<>();
        Deck newDeck = new Deck(1);
        dealtCards = newDeck.dealCards(2);

        CardHand testCardHand = new CardHand(dealtCards);
        String actual = testCardHand.displayHand();
        String expected = "[KING of DIAMONDS \n, QUEEN of DIAMONDS \n]";

        Assert.assertEquals(expected,actual);
    }

}