package com.github.zipcodewilmington.casino.card;

import java.util.ArrayList;

public class Hand {
private ArrayList<Card> hand;

    public Hand() {

        hand = new ArrayList<>();

    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getHand() {

        return hand;
    }
    public void removeHand(Card i){

        hand.remove(i);
    }
    public void clear(Card i){

        hand.clear();
    }
    public  void add(Card i) {

        hand.add(i);
    }

}
