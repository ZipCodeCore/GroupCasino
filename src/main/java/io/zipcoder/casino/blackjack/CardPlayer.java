package io.zipcoder.casino.blackjack;

import io.zipcoder.casino.Player;

import java.util.ArrayList;
import java.util.List;

//extends from the player
public class CardPlayer extends Player {
    //create a field of type List<Card> named hand

    // create a method named add that takes a
    // card and add it to the list cards
    // it does not return anything

    //create a method named getHand that takes
    // in no param and return the player hand


    List<Card> hand = new ArrayList<Card>();

    public CardPlayer(String name) {
        super(name);
    }

    public CardPlayer(String name, double money) {
        super(name, money);
    }


    public void add(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {

        return hand;

    }
}