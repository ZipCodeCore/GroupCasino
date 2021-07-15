package com.github.zipcodewilmington.casino.games.CardGame;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void shuffle() {
    }

    @Test
    void getSize() {
        Stack<Card> cardDeck = new Stack<>();
        Card card = new Card(FaceValueOfCard.EIGHT,Suit.Clubs);
        cardDeck.add(card);
        Assert.assertEquals(1,cardDeck.size());
    }

    @Test
    void dealCards() {
    }

    @Test
    void drawCard() {
    }

    @Test
    void setDeck() {
    }
}