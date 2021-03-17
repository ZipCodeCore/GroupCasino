package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public abstract class CardGame implements GamblingGame {
    ArrayList<String> playersHand;
    ArrayList<String> dealersHand;
    ArrayList<String> deck;
    String[] ranks;
    String[] suits;

    public CardGame() {

        this.deck = new ArrayList<String>(52);
        // Set zeroth element to null to indicate an unused element (only valid ranks from 1-13)
        this.ranks = new String[]{null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        this.suits = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};
        this.playersHand = new ArrayList<String>();
        this.dealersHand = new ArrayList<String>();
    }

    public ArrayList<String> getDeck() {
        return this.deck;
    }

    public ArrayList<String> getPlayersHand() {
        return this.playersHand;
    }

    public ArrayList<String> getDealersHand() {
       return this.dealersHand;
    }

    public void createNewDeck() {
        for (int suit = 0; suit <=3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.deck.add(this.ranks[rank] + " of " + this.suits[suit]);
            }
        }
    }

    public void shuffleCards() {
        ArrayList<String> temp = new ArrayList<String>(52);
        while(!this.deck.isEmpty()) {
            int randCard = (int) (Math.random() * deck.size());
            temp.add(this.deck.get(randCard));
            this.deck.remove(randCard);
        }
        this.deck = temp;
    }

    public void dealCards(int numberOfCards) {
        int i = 0;
        while (i < numberOfCards * 2) {
            if (i < numberOfCards) {
                this.playersHand.add(this.deck.get(i));
            } else if (i >= numberOfCards) {
                this.dealersHand.add(this.deck.get(i));
            }
            this.deck.remove(i);
            i++;
        }
    }
    
}
