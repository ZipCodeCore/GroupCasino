package io.zipcoder.casino.Cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Deck {
    private final static List<Card> COMPLETE_DECK = new ArrayList<Card>();
    private Stack<Card> playDeck;

    static {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                COMPLETE_DECK.add(new Card(suit, rank));
            }
        }
    }

    public Deck() {

        playDeck = new Stack<Card>();
        playDeck.addAll(COMPLETE_DECK);

    }


    public Card getCard() {

        return playDeck.pop();
    }


}