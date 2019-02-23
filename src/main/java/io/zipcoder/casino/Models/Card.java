package io.zipcoder.casino.Models;

public class Card {




    public enum Suit {HEARTS,SPADES,DIAMONDS,CLUBS};
    public enum Integer {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN , KING};

    protected Suit cardSuit;
    protected Integer value;






    public Card() {

    }

    public Card(Suit cardSuit, Integer value) {
        this.cardSuit = cardSuit;
        this.value = value;
    }


    public Integer getValue() {

        return value;
    }


    public Suit getCardSuit() {

        return cardSuit;
    }

    public Suit setCardSuit(Suit cardSuit) {
        this.cardSuit = cardSuit;
        return cardSuit;
    }


    public Integer setValue(Integer value) {
        this.value = value;
        return value;
    }





}
