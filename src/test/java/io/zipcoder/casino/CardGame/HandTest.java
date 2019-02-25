package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.CardGame.Cards.Card;
import io.zipcoder.casino.CardGame.Cards.Deck;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class HandTest {

    @Before
    public void setUp() {
        Deck deck = new Deck(1);
        ArrayList<Card> cards = deck.deal(7);
    }


    @Test
    public void drawCard() {
        //GIVEN
        ArrayList<Card> cards = new ArrayList<>();



        //WHEN


        //THEN
    }

    @Test
    public void showMyCards() {

        //GIVEN
        ArrayList<Card> cards = new ArrayList<>();
        Deck deck = new Deck(1);



        //WHEN



        //THEN

    }

    @Test
    public void addCardsToHand() {
    }

    @Test
    public void removeCardsFromHand() {
    }
}