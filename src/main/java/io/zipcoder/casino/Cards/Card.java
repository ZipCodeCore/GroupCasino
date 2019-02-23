package io.zipcoder.casino.Cards;

import java.util.List;

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
        return "|" + rank.toString().toLowerCase() + " of " + suit.toString().toLowerCase();
    }

    public int compareTo(Card otherCard) {
        return otherCard.getRank().compareTo(rank);
    }

    public boolean equalRank(Card otherCard) {
        return otherCard.getRank() == rank;
    }

    public static boolean equalRank(List<Card> otherCards) {
        for (int i = 0; i < otherCards.size() - 1; i++) {
            if(!otherCards.get(i).equalRank(otherCards.get(i+1))) {
                return false;
            }
        }
        return true;
    }

    public int getRankValue() {
        return rank.returnPrimaryRankValue();
    }
}
