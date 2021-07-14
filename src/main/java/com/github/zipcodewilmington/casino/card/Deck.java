package com.github.zipcodewilmington.casino.card;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public void buildDeck(){
        for(suitValue cardSuit: suitValue.values()){
            for(cardValue cardValue : cardValue.values()){
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    public void shuffle(){
        ArrayList<Card> tempD = new ArrayList<>();
        Random random = new Random();
        int randomIndex = 0;
        int originSize = this.cards.size();
        for(int i = 0; i < originSize; i++){
            randomIndex = random.nextInt((originSize - 1) + 1); //rand.nextInt((max-min) + 1) + min;
            tempD.add(this.cards.get(randomIndex));
            this.cards.remove(randomIndex);
        }
        this.cards=tempD;
    }
}
