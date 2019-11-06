package io.zipcoder.casino.CardGames;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class DeckTest {

    @Before
    public void setUp(){}

    @After
    public void tearDown(){}

    @Test
    public void testDealCards(){
        Deck newDeck = new Deck(1);
        List<Card> cardList = new ArrayList<>();
        cardList = newDeck.dealCards(2);

        int expected = 2;
        int actual = cardList.size();

        Assert.assertEquals(expected,actual);
    }
}