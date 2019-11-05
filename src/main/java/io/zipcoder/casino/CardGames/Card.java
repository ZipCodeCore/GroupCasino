package io.zipcoder.casino.CardGames;

public class Card {

    private Suit suit;
    private Rank rank;


    public Card(){

    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString() {

        return String.format("%s of %s", rank, suit);
    }
}
