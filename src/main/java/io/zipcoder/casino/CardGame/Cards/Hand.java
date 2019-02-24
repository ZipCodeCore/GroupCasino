package io.zipcoder.casino.CardGame.Cards;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    private int size;
    private int handValue;
    private ArrayList<Card> hand;
    private Deck deck;

    public Hand(Card cards) {
        deck = new Deck();
        hand = new ArrayList<Card>();


    }


    public void drawCard() {
         hand.add(deck.getCard(0));
         deck.removeCardFromDeck(0);

    }

}
