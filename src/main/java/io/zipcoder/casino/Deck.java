package io.zipcoder.casino;

import io.zipcoder.casino.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    Stack<Card> card = new Stack<Card>();

    public void shuffle () {
        Collections.shuffle(card);
    };

    public ArrayList<Card> deal (Integer numOfCards, Player player) {
        return null;
    }
}
