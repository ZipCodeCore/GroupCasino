package io.zipcoder.casino.CardsAndDice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class Deck {
    private final static List<Card> COMPLETE_DECK = new ArrayList<Card>();
    private final static Card cardBack = new Card(null, null);
    private Stack<Card> playDeck;

    static  {

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                COMPLETE_DECK.add(new Card(suit, rank));
            }
        }
    }
    public static Card getCardBack() {
        return cardBack;
    }

    public Deck() {

        playDeck = new Stack<>();
        playDeck.addAll(COMPLETE_DECK);
        Collections.shuffle(playDeck);

    }

    public List<Card> drawMultipleCards(int numberOfCards) {
        List<Card> newCards = new ArrayList<Card>();
        for (int i = 0; i < numberOfCards; i++) {
            newCards.add(playDeck.pop());
        }
        return newCards;
    }

    public Card drawCard() {
        return playDeck.pop();
    }
    public int cardsLeft() { return playDeck.size(); }

    public Stack<Card> getPlayDeck() {
        return playDeck;
    }
}
