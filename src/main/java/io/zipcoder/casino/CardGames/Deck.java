package io.zipcoder.casino.CardGames;
import java.util.Random;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    public Deck () {
        this.cards = new ArrayList<Card>();
    }
    public void newFullDeck() {
        for (Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()){
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    public String toString() {
        String listOutput = "";
        int i = 0;
        for (Card aCard : this.cards) {
            listOutput += "\n" + " " + aCard.toString();
        }
        return listOutput;
    }
    public void shuffleDeck() {
        ArrayList<Card> temporaryDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomSpot = 0;
        int originSize = this.cards.size();
        for (int i = 0; i < originSize; i++) {
            randomSpot = random.nextInt((this.cards.size() - 1) +1);
            temporaryDeck.add(this.cards.get(randomSpot));
            this.cards.remove(randomSpot);
        }
        this.cards = temporaryDeck;
    }
    public void removeCard(int i) {
        this.cards.remove(i);
    }
    public Card getCard(int i) {
        return this.cards.get(i);
    }
    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }
    public void drawFrom(Deck fromDeck) {
        this.cards.add(fromDeck.getCard(0));
        fromDeck.removeCard(0);
    }





}
