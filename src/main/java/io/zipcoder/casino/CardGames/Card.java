package io.zipcoder.casino.CardGames;

import java.util.HashMap;
import java.util.Collections;


public class Card {

    private Suit suit;
    private Rank rank;


    public Card() {

    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString() {

        return String.format("%s of %s \n\n", rank, suit.toString().toLowerCase());
    }

    public HashMap<Rank, Integer> blackJackCardRank = new HashMap() {{

        put(Rank.TWO, 2);
        put(Rank.THREE, 3);
        put(Rank.FOUR, 4);
        put(Rank.FIVE, 5);
        put(Rank.SIX, 6);
        put(Rank.SEVEN, 7);
        put(Rank.EIGHT, 8);
        put(Rank.NINE, 9);
        put(Rank.TEN, 10);
        put(Rank.ACE, 11);
        put(Rank.JACK, 10);
        put(Rank.QUEEN, 10);
        put(Rank.KING, 10);
    }};


}
