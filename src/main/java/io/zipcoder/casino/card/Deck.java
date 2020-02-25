package io.zipcoder.casino.card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    Stack<Card> deck;
    ArrayList<Card> deckToShuffle;

    public Deck() {
        this.deck = new Stack<>();
    }

    public void createDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                if (i == 0) {
                    Card c = new Card("Spades", j);
                    deck.push(c);
                } else if (i == 1) {
                    Card c = new Card("Hearts", j);
                    deck.push(c);
                } else if (i == 2) {
                    Card c = new Card("Clubs", j);
                    deck.push(c);
                } else {
                    Card c = new Card("Diamonds", j);
                    deck.push(c);
                }
            }
        }
    }

    public Stack<Card> getDeck() {
        return deck;
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    public Card popCard() {
        return deck.pop();
    }

    public void printDeck() {
        System.out.println(deck);
        System.out.println(deckToShuffle);
    }

    public void stackToArray() {
        deckToShuffle = new ArrayList(deck);
    }

    public ArrayList<Card> getTempArrayList() {
        return deckToShuffle;
    }

    public void shuffle() {
        Collections.shuffle(deckToShuffle);
    }

    public void arrayListToStack() {
        deck.addAll(deckToShuffle);
    }

    public Card peekStack() {
        return deck.peek();
    }

}

