package io.zipcoder.casino;

import io.zipcoder.casino.player.CardGamePlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    public Stack<Card> getDeck() {
        return deck;
    }

    Stack<Card> deck = new Stack<Card>();

    public void shuffle () {
        Collections.shuffle(deck);
    };

    public ArrayList<Card> deal (Integer numOfCards, CardGamePlayer player) {
        return null;
    }

    public void dealSingleCard(CardGamePlayer player) { }


}
