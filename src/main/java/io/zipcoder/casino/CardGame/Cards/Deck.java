


package io.zipcoder.casino.CardGame.Cards;


import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public ArrayList<Card> deck;
    private int size;

    public Deck() {
        deck = new ArrayList<Card>();
        createDeck();

    }

    public Card getCard(int cardIndex){
        return deck.get(cardIndex);

    }
    public void shuffle() {
        Collections.shuffle(deck);

    }

    public void removeCardFromDeck(int cardIndex) {
        deck.remove(cardIndex);
    }

    public int deckSize() {
        return deck.size();
    }

    public ArrayList<Card> deal (int numberOfCards) {
        ArrayList<Card> requestedCards = new ArrayList<Card>();
        for (int i = 0; i < numberOfCards; i++ ) {
            requestedCards.add(deck.get(i));
        }

        return requestedCards;

    }

    private void createDeck() {
        for (Suit s : Suit.values()) {
            for (Face f : Face.values()) {
                deck.add(new Card(f, s));


            }
        }
    }
}


