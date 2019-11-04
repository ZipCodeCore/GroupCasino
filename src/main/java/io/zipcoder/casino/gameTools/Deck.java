package io.zipcoder.casino.gameTools;

import io.zipcoder.casino.player.CardGamePlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class Deck {


    private Stack<Card> cardStack;
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
    }


    public void shuffle () {
        Collections.shuffle(cardStack);
    };

    public void deal (Integer numOfCards, CardGamePlayer player) {
        ArrayList<Card> result = new ArrayList<Card>();
        for (int i = 0; i < numOfCards ; i++) {
            result.add(cardStack.pop());
            player.setHand(result);
        }
    }

    public void dealSingleCard(CardGamePlayer player) {
        Card card = cardStack.pop();
        ArrayList<Card> hand;
        hand = player.getHand();
        hand.add(card);
        player.setHand(hand);

    }

    public void setDeck(Stack<Card> cardStack) {
        this.cardStack = cardStack;
    }
    public Stack<Card> getDeck() {
        return cardStack;
    }


}
