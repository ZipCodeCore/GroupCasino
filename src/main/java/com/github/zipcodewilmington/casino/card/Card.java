package com.github.zipcodewilmington.casino.card;

public class Card {
    private cardValue cardValue;
    private suitValue suitValue;

    public Card(suitValue suitValue, cardValue cardValue){
        this.cardValue = cardValue;
        this.suitValue = suitValue;
    }

    public String toString(){
        return this.suitValue.toString() + "-" + this.cardValue.toString();
    }

    public cardValue getCardValue(){
        return this.cardValue;
    }

}
