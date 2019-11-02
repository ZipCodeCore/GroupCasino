package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card>{

    private String rank;
    private String suit; //H,C,S,D
    public static final ArrayList<String> RANKS;
    public static final HashMap<String,String> SUIT_SYMBOLS;
    static {
        RANKS = new ArrayList<String>(Arrays.asList(new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"}));
        SUIT_SYMBOLS = new HashMap<String, String>();
        SUIT_SYMBOLS.put("H","\u2665");
        SUIT_SYMBOLS.put("S","\u2660");
        SUIT_SYMBOLS.put("C","\u2663");
        SUIT_SYMBOLS.put("D","\u2666");
    }

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int compareTo (Card card2) {
        return Integer.compare(Card.RANKS.indexOf(this.rank), Card.RANKS.indexOf(card2.rank));
    }

    public boolean equals (Card card2) {
        if (this.compareTo(card2) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean strictEquals (Card card2) {
        if (this.compareTo(card2) == 0 && this.suit == card2.suit) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.rank + SUIT_SYMBOLS.get(this.suit);
    }
}
