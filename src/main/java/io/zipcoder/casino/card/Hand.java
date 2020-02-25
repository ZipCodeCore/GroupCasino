package io.zipcoder.casino.card;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<>();
    }

    public void add(Card c){
        hand.add(c);
    }
}
