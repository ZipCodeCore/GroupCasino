package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.CardGame.Cards.Card;
import io.zipcoder.casino.CardGame.Cards.Deck;

import java.util.ArrayList;

public class Hand {
    private int size;
    private int handValue;
    private ArrayList<Card> cards = new ArrayList<>();
    private Deck deck = new Deck(1);




    public Hand(ArrayList<Card> cards) {




    }


    public void drawCard() {
         cards.add(deck.getCard(0));
         deck.removeCardFromDeck(0);

    }


}


