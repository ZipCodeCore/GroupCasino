package io.zipcoder.casino.casino.games.cardgames.cardutilities;

public enum Suit {
    SPADES(	"\u2664" ),
    HEARTS(	"\u2661" ),
    DIAMONDS( "\u2662" ),
    CLUBS( "\u2667" );

    private String stringRepresentation;

    Suit(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() { return this.stringRepresentation; }
}
