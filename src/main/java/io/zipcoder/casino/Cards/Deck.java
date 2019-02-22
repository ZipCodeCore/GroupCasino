package io.zipcoder.casino.Cards;

import java.util.ArrayList;
import java.util.List;

public class Deck
{
    private final static List<Card> COMPLETE_DECK = new ArrayList<Card>();
    private List<Card> playDeck;
    static  {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                COMPLETE_DECK.add(new Card(suit, rank));
            }
        }
    }

    public Deck () {
        playDeck = new ArrayList<Card>(COMPLETE_DECK);
    }

}
