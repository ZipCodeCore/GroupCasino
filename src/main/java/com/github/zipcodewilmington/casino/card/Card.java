package com.github.zipcodewilmington.casino.card;

public class Card {
    private CardValue cardValue;
    private SuitValue suitValue;

    public Card(SuitValue suitValue, CardValue cardValue){
        this.cardValue = cardValue;
        this.suitValue = suitValue;
    }

    public String toString(){
        return this.suitValue.toString() + "-" + this.cardValue.toString();
    }

    public CardValue getCardValue(){
        return this.cardValue;
    }

}
