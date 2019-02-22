package io.zipcoder.casino.Models;

public class Card {
    enum Suit {HEARTS,SPADES,DIAMONDS,CLUBS};

    private Suit cardSuit;
    private Long value;

    public Long getValue() {
        return this.value;
    }

    public void setCardSuit(Suit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public Suit getCardSuit() {
        return cardSuit;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
