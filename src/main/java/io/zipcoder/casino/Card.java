package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card>{

    private String rank;
    private String suit; //H,C,S,D
    private static final ArrayList<String> ranks;
    private static final HashMap<String,String> suitSymbols;
    static {
        ranks = new ArrayList<String>(Arrays.asList(new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"}));
        suitSymbols = new HashMap<String, String>();
        suitSymbols.put("H","\\u2665");
        suitSymbols.put("S","\\u2660");
        suitSymbols.put("C","\\u2663");
        suitSymbols.put("D","\\u2666");
    }

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int compareTo (Card card2) {
        return Integer.compare(Card.ranks.indexOf(this.rank), Card.ranks.indexOf(card2.rank));
    }

    @Override
    public String toString() {
        return this.rank + suitSymbols.get(this.suit);
    }
}
