package com.github.zipcodewilmington.casino.models;

import java.util.*;

public class Card {
    List<Integer> cardPool;
    Integer numberOfCards; // The deck will be made of

    public Card () {
        this.numberOfCards = 52;
        this.cardPool = new ArrayList<>();
        this.createDeck(numberOfCards);
    }

    // Alter the loop to provide the correct amount of 10's
    // Jack/Queen/King
    // Should have 16 - 10 values in a 52 deck

    public List<Integer> createDeck (Integer numberOfCards) {
        for (int i = 0; i <= 4; i++) {
            for (int j = 2; j < (numberOfCards / 4); j++) {
                this.cardPool.add(j);
            }
        }
        return this.cardPool;
    }

    public void polishDeck () {
        for (int i = 0; i < this.cardPool.size(); i++) {
            if (this.cardPool.get(i) > 11) {
                this.cardPool.set(i, 10);
            }
        }
    }

    public void shuffleDeck () {
        Collections.shuffle(this.cardPool);
    }

    public List<Integer> getCardPool() {
        return cardPool;
    }

    public void setCardPool(List<Integer> cardPool) {
        this.cardPool = cardPool;
    }

    public Integer getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(Integer numberOfCards) {
        this.numberOfCards = numberOfCards;
    }
}
