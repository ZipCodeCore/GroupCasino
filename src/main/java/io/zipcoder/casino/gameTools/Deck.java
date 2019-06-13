package io.zipcoder.casino.gameTools;

import io.zipcoder.casino.player.CardGamePlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class Deck {
    Stack<Card> cardStack;
    public Deck() {
        this.cardStack = new Stack<Card>();
        for (CardValue c : CardValue.values()
             ) {
            for (Suit suit : Suit.values()
                 ) {
                Card card = new Card(c,suit);
                this.cardStack.add(card);
            }
        }
        Collections.shuffle(cardStack);

        System.out.println("FML");

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
