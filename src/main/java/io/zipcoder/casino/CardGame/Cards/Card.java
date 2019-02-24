package io.zipcoder.casino.CardGame.Cards;

public class Card {
    private Face face;
    private Suit suit;
    private int value;

    public Card (Face face, Suit suit) {
        this.face = face;
        this.suit = suit;

    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public int getValue() {
        return value;
    }


    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}
