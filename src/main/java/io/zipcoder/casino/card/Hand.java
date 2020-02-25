package io.zipcoder.casino.card;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;


    public Hand(){
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void add(Card c){
        hand.add(c);
    }

    public void remove(Card c){
        hand.remove(c);
    }

    public void clear(){
        hand.clear();
    }

    public boolean contains(Card c){
        return hand.contains(c);
    }
}
