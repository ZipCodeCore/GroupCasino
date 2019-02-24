package io.zipcoder.casino.Cards;

public enum Suit {
    SPADES(	"\u2660" ),
    HEARTS(	"\u2665" ),
    DIAMONDS( "\u2666" ),
    CLUBS( "\u2663" );

    private String stringRepresentation;

    Suit(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() { return this.stringRepresentation; }
}
