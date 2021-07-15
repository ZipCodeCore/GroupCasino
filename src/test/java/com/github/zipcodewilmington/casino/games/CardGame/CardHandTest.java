package com.github.zipcodewilmington.casino.games.CardGame;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CardHandTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void displayHand() {
        ArrayList<Card> card= new ArrayList<>();
        Deck deck = new Deck(1);
        card = deck.dealCards(1);

        CardHand cardHand = new CardHand(card);


        Assert.assertEquals(cardHand.displayHand(),cardHand.displayHand());
    }
}