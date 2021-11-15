package com.github.zipcodewilmington.casino.games.gameUtils;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Deck {
//    List<Card> deckList = new ArrayList<>();

    //reset deck

    //shuffle cards

    //draw a card - must be stack method
    Stack<Cards> cardDeck = new Stack<>();

    public Deck() {
        for(Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardDeck.push(new Cards(suit,rank));
            }
        }
    }

}
