package io.zipcoder.casino.CardGames;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DeckTest {

    @Before
    public void setUp(){}

    @After
    public void tearDown(){}

    @Test
    public void getSize(){
        Deck newDeck = new Deck(1);
        Integer expected = 52;

        assertEquals(expected, newDeck.getSize());
    }

    @Test
    public void getSize2(){
        Deck newDeck = new Deck(4);
        Integer expected = 208;

        assertEquals(expected, newDeck.getSize());
    }

    @Test
    public void shuffleDeck(){
        Deck newDeck = new Deck(1);

        System.out.println(newDeck.shuffleDeck().toString());

    }








}