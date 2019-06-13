package io.zipcoder.casino.gameTools;

import io.zipcoder.casino.player.CardGamePlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    Stack<Card> cardStack;
    public Deck() {
        this.cardStack = new Stack<Card>();
        for (CardValue card : CardValue.values()
             ) {
            for (Suit suit : Suit.values()
                 ) {
                cardStack.add(new Card(card,suit));
            }
        }
    }



    public Stack<Card> getCardStack() {
        return cardStack;
    }

    public void shuffle () {
        Collections.shuffle(cardStack);
    };

    public ArrayList<Card> deal (Integer numOfCards, CardGamePlayer player) {
        return null;
    }

    public void dealSingleCard(CardGamePlayer player) { }


}
