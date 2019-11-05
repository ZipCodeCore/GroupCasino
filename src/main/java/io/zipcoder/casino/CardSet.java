package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CardSet {

    private ArrayList<Card> cards;

    public CardSet(int numDecks) {
        //creates shuffled set of cards
        ArrayList<Card> cardSet = new ArrayList<Card>(numDecks * 52);
        if (numDecks > 0) {
            for (int i = 0; i < numDecks; i++) {
                for (String rank : Card.RANKS) {
                    for (String suit : Card.SUIT_SYMBOLS.keySet()) {
                        cardSet.add(new Card(rank, suit));
                    }
                }
            }
        }

        this.cards = cardSet;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int size() {
        return this.cards.size();
    }

    public Card removeFirstCard() {
        // removes first card!
        if (this.cards.size() > 0) {
            return this.cards.remove(0);
        } else {
            return null;
        }
    }

    public ArrayList<Card> removeRank(String rankToRemove) {
        ArrayList<Card> foundCards = new ArrayList<Card>();
        if (this.cards.size() > 0) {
            for (int i = 0; i < this.cards.size(); i++) {
                if (rankToRemove.equals(this.cards.get(i).getRank())) {
                    foundCards.add(this.cards.get(i));
                    this.cards.remove(i);
                    i--;
                }
            }
        }
        return foundCards;
    }

    public void addCard(Card cardToAdd) {
        this.cards.add(cardToAdd);
    }

    public void addCards(ArrayList<Card> cardsToAdd) {
        for (Card card : cardsToAdd) {
            this.cards.add(card);
        }
    }

    public void clear() {
        this.cards.clear();
    }

    public void sort() {
        Collections.sort(this.cards);
    }

    public void shuffle() {

        Collections.shuffle(this.cards);
        //ArrayList<Card> c = this.cards;
    }


    public String toASCII() {
        int numCards = this.size();
        String[] emptyArray = new String[numCards+1];
        Arrays.setAll(emptyArray,(index) -> "");

        String output = String.join("\u250C-------\u2510 ", emptyArray);
        output += "\n";
        for (Card card : this.cards) {
            if (card.getRank().length() == 1) {
                output += String.format("| %s     | ", card.getRank());
            } else {
                output += String.format("|%s     | ", card.getRank());
            }
        }
        output += "\n";
        output += String.join("|       | ", emptyArray);
        output += "\n";
        for (Card card : this.cards) {
            output += String.format("|   %s   | ", Card.SUIT_SYMBOLS.get(card.getSuit()));
        }
        output += "\n";
        output += String.join("|       | ", emptyArray);
        output += "\n";
        for (Card card : this.cards) {
            if (card.getRank().length() == 1) {
                output += String.format("|     %s | ", card.getRank());
            } else {
                output += String.format("|     %s| ", card.getRank());
            }
        }
        output += "\n";
        output += String.join("\u2514-------\u2518 ", emptyArray);
        output += "\n";
        return output;
    }

    public String toASCIISuite() {
        int numCards = this.size();
        String[] emptyArray = new String[numCards+1];
        Arrays.setAll(emptyArray,(index) -> "");

        String output = toASCII();
        output += " ";
        output += String.join("\u2514-------\u2518 ", emptyArray);
        output += "\n";
        output += "  ";
        output += String.join("\u2514-------\u2518 ", emptyArray);
        output += "\n";
        return output;
    }
}
