package io.zipcoder.casino.card;

public class Card implements Comparable<Card>{
    private String suit;
    private Integer rank;

    public Card(String suit, Integer rank){
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        if (this.getRank() == 1) {
            if (this.getSuit() == "Hearts") {
                return "Ace of ♥";
            } else if (this.getSuit() == "Spades") {
                return "Ace of ♠";
            } else if (this.getSuit() == "Clubs") {
                return "Ace of ♣";
            } else {
                return "Ace of ♦";
            }
        } else if (this.getRank() > 1 && this.getRank() < 11) {
            if (this.getSuit() == "Hearts") {
                return this.getRank() + " of ♥";
            } else if (this.getSuit() == "Spades") {
                return this.getRank() + " of ♠";
            } else if (this.getSuit() == "Clubs") {
                return this.getRank() + " of ♣";
            } else {
                return this.getRank() + " of ♦";
            }
        } else if (this.getRank() == 11) {
            if (this.getSuit() == "Hearts") {
                return "Jack of ♥";
            } else if (this.getSuit() == "Spades") {
                return "Jack of ♠";
            } else if (this.getSuit() == "Clubs") {
                return "Jack of ♣";
            } else {
                return "Jack of ♦";
            }
        } else if (this.getRank() == 12) {
            if (this.getSuit() == "Hearts") {
                return "Queen of ♥";
            } else if (this.getSuit() == "Spades") {
                return "Queen of ♠";
            } else if (this.getSuit() == "Clubs") {
                return "Queen of ♣";
            } else {
                return "Queen of ♦";
            }
        } else if (this.getRank() == 13) {
            if (this.getSuit() == "Hearts") {
                return "King of ♥";
            } else if (this.getSuit() == "Spades") {
                return "King of ♠";
            } else if (this.getSuit() == "Clubs") {
                return "King of ♣";
            } else {
                return "King of ♦";
            }
        }
        return "Error";
    }

    @Override
    public int compareTo(Card c){
        return this.getRank().compareTo(c.getRank());
    }
}
