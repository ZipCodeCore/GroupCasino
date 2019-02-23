package io.zipcoder.casino.CardGame.Cards;
import java.util.Deque;

public class Deck {
    private Deque<Card> cards;
    private int size;

    public Deck() {
        createDeck();

    }

    public Card drawCard() {
        return cards.pop();

    }
    public Deque<Card> getDeck(){
        return cards;

    }
    public void shuffle() {
    }

    public void deal() {
    }

    private void createDeck() {
        for (Suit s : Suit.values()) {
            for (Face f : Face.values()) {
                cards.add(new Card(f,s));

            }
        }
    }
}


