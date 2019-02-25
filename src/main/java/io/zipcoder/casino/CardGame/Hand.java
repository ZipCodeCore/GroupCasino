package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.CardGame.Cards.Card;
import io.zipcoder.casino.CardGame.Cards.Deck;

import java.lang.reflect.Array;
import java.util.ArrayList;
gi
public class Hand {
    private int size;
    private int handValue;
    private ArrayList<Card> cards = new ArrayList<>();

    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void drawCard(Deck deck) {
         cards.add(deck.getCard(0));
         deck.removeCardFromDeck(0);
    }

    public ArrayList<Card> showMyCards() {
        return cards;
    }

    public void addCardsToHand(ArrayList<Card> cards){

        for (Card c : cards){
            this.cards.add(c);

        }
    }

    public void removeCardsFromHand(ArrayList<Card> cards) {
        for (Card c : cards) {
            this.cards.remove(c);
        }
    }

}


