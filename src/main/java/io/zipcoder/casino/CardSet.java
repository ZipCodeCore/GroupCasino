package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CardSet {

    private ArrayList<Card> cards;

    public CardSet(int numDecks) {
        //creates shuffled set of cards
        ArrayList<Card> cardSet = new ArrayList<Card>(numDecks * 52);
        if (numDecks > 0) {
            for (int i = 0; i < numDecks; i++) {
                for (String rank : Card.RANKS) {
                    for (String suit : Card.SUIT_SYMBOLS.keySet()) {
                        cardSet.add(new Card(rank, suit));
                    }
                }
            }
        }

        this.cards = cardSet;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int size() {
        return this.cards.size();
    }

    public Card removeFirstCard() {
        // removes first card!
        if (this.cards.size() > 0) {
            return this.cards.remove(0);
        } else {
            return null;
        }
    }

    public boolean removeCard(Card cardToRemove) {
        if (this.cards.size() > 0) {
            for (int i = 0; i < this.cards.size(); i++) {
                if (cardToRemove.strictEquals(this.cards.get(i))) {
                    this.cards.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void addCard(Card cardToAdd) {
        this.cards.add(cardToAdd);
    }

    public void sort() {
        Collections.sort(this.cards);
    }

    public void shuffle() {

        Collections.shuffle(this.cards);
        //ArrayList<Card> c = this.cards;
    }
}
