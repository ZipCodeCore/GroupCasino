package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public abstract class CardGame implements GamblingGame {

    Stack deckOfCards;
    ArrayList<String> playersHand;
    ArrayList<String> dealersHand;
    ArrayList<String> deck;


    public CardGame() {
        this.deck = new ArrayList<String>(52);
    }

    public void createNewDeck() {
        String[] suits = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};
        // Set zeroth element to null to indicate an unused element (only valid ranks from 1-13)
        String[] ranks = new String[]{null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (int suit = 0; suit <=3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.deck.add(ranks[rank] + " of " + suits[suit]);
            }
        }
    }

    public void shuffleCards() {
        ArrayList<String> temp = new ArrayList<String>();
        while(!this.deck.isEmpty()) {
            int randCard = (int) (Math.random() * deck.size());
            temp.add(deck.get(randCard));
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
        }
    }

    public void skipDeal() {
        // ???
    }
    
}
