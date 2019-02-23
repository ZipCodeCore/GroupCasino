package io.zipcoder.casino.CardGame.Cards;

public class Card {
    private Face face;
    private Suit suit;

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

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}
