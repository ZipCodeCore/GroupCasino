package io.zipcoder.casino.Cards;

import java.util.ArrayList;
import java.util.Arrays;
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
        return rank.toString().toLowerCase() + " of " + suit.toString().toLowerCase();
    }

    public String printCard() {
        String top = rank.getStringRepresentation();
        String bottom = rank.getStringRepresentation();
        //Add on lines to non-10 ranks to make all the cards evenly sized.
        if (!rank.equals(Rank.TEN)) {
            top += "\u2501";
            bottom = "\u2501" + bottom;
        }
        String fullCard = String.format("%s\u2501\u2501\u2513\n\u2503   \u2503\n\u2503 %s \u2503\n\u2503   \u2503\n\u2517\u2501\u2501%s",
                top, suit.getStringRepresentation(), bottom);
        return fullCard;
    }

    public static String printAllCards(Card... cards) {
        return printAllCards(new ArrayList<>(Arrays.asList(cards)));
    }


    public static String printAllCards(List<Card> cards) {
        StringBuilder allCardsPrinted = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (Card card : cards) {
                if(card.getSuit() != null) {
                    allCardsPrinted.append(card.splitCard()[i]);
                } else {
                    allCardsPrinted.append(printCardBack()[i]);
                }
            }
            allCardsPrinted.append("\n");
        }
        return allCardsPrinted.toString();
    }
    private String[] splitCard() {
        return printCard().split("\n");
    }

    private static String[] printCardBack() {
        return new String[]{"\u250F\u2501\u2501\u2501\u2513", "\u2503\u0220  \u2503", "\u2503 \u0244 \u2503",
        "\u2503  \u0297\u2503", "\u2517\u2501\u2501\u2501\u251B"};
    }


    public int compareTo(Card otherCard) {
        int rankCompare = otherCard.getRank().compareTo(rank) * 2;
        int suiteCompare = 0;
        if (rankCompare == 0) {
            suiteCompare = otherCard.getSuit().compareTo(suit);
        }
        return rankCompare + suiteCompare;
    }

    public boolean equalRank(Card otherCard) {
        return otherCard.getRank().toString().equals(rank.toString());
    }
    public static boolean equalRank(List<Card> otherCards) {
        for (int i = 0; i < otherCards.size() - 1; i++) {
            String currentRank = otherCards.get(i).getRank().toString();
            String nextRank = otherCards.get(i+1).getRank().toString();
            if(!currentRank.equals(nextRank)) {
                return false;
            }
        }
        return true;
    }

}
