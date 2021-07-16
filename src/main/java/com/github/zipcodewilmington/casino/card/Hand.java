package com.github.zipcodewilmington.casino.card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    //private ArrayList<Card> hand;
    private Deck hand;

    public Hand() {
        hand = new Deck();
        //hand = new ArrayList<>();
    }

//    public void setHand(ArrayList<Card> hand) {
//        this.hand = hand;
//    }

    public void setHand(Deck hand) {
        this.hand = hand;
    }

//    public ArrayList<Card> getHand() {
//
//        return hand;
//    }

    public Deck getHand() {

        return hand;
    }


    public Card drawSingleCard() {
        return this.hand.drawCard();
    }

    public void removeCard(Card card) {
        this.hand.cardRemove(card);
    }

//    public void removeHand(Card i){
//        hand.remove(i);
//    }
//
//    public void clear(Card i){
//        hand.clear();
//    }
//
//    public  void add(Card i) {
//        hand.add(i);
//    }

}
