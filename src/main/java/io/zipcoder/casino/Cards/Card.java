package io.zipcoder.casino.Cards;

public class Card implements Comparable<Card>{

    private Suit suit;
    private Rank rank;

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

        return rank + " of " + suit;
    }

    public int compareTo(Card otherCard) {
        return otherCard.getRank().compareTo(rank);
    }

    public boolean equalRank(Card otherCard) {
        return otherCard.getRank() == rank;
    }
}
