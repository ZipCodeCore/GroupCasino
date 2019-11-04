package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.CardGame.Cards.Card;
import io.zipcoder.casino.CardGame.Cards.Deck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class HandTest {

    Deck deck;
    ArrayList<Card> cards;

    @Before
    public void setUp() {
        deck = new Deck(1);
        cards = deck.deal(7);
    }


    @Test
    public void drawCard() {
        //GIVEN
        Hand hand = new Hand(cards);
        int expected = hand.getSize();



        //WHEN
        hand.drawCard(deck);
        int actual = hand.getSize();


        //THEN
        Assert.assertNotEquals(expected, actual);
    }


    @Test
    public void addCardsToHand() {
        //GIVEN
        Hand hand = new Hand(cards);
        int expected = hand.getSize();

        //WHEN
        hand.addCardsToHand(cards);
        int actual = hand.getSize();

        //THEN
        Assert.assertNotEquals(expected, actual);

    }

    @Test
    public void removeCardsFromHand() {

        //GIVEN
        Hand hand = new Hand(cards);
        int expected = hand.getSize();

        //WHEN
        hand.removeCardsFromHand(cards);
        int actual = hand.getSize();

        //THEN
        Assert.assertNotEquals(expected, actual);
    }


}