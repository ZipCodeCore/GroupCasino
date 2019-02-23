package io.zipcoder.casino.Cards;

import java.util.*;

public class Deck
{
    private final static List<Card> COMPLETE_DECK = new ArrayList<Card>();
    static  {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                COMPLETE_DECK.add(new Card(suit, rank));
            }
        }
    }

    private Stack<Card> playDeck;
    public Deck () {
        playDeck = new Stack<Card>();
        playDeck.addAll(COMPLETE_DECK);
        Collections.shuffle(playDeck);
    }

    public List<Card> drawMultipleCards(int numberOfCards) {
        List<Card> newCards = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            newCards.add(playDeck.pop());
        }
        return newCards;
    }

    public Card drawCard() {
        return playDeck.pop();
    }

}
