package com.github.zipcodewilmington.casino.objects;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    private final int NUM_DECKS = 1;
    public LinkedList<Card> deck;

    public Deck(int NUM_DECKS) {
        deck = new LinkedList<>();
    }


    public void populateDeck() {
        CardRank[] ranks = {CardRank.TWO, CardRank.THREE, CardRank.FOUR,
                CardRank.FIVE, CardRank.SIX, CardRank.SEVEN, CardRank.EIGHT,
                CardRank.NINE, CardRank.TEN, CardRank.JACK, CardRank.QUEEN,
                CardRank.KING, CardRank.ACE};
        CardSuit[] suits = {CardSuit.CLUBS, CardSuit.DIAMONDS, CardSuit.HEARTS,
                CardSuit.SPADES};


        for (int i = 0; i < NUM_DECKS - 1; i++) {
            for (int j = 0; j < 52; i++)
                deck.add(new Card(ranks[i / 4], suits[i % 4]));
        }
    }


    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        return deck.pop();
    }


}
