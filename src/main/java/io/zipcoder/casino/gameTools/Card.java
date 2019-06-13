package io.zipcoder.casino.gameTools;

public class Card {
    private CardValue cardValue;
    private Suit suit;

    public Card (CardValue cv, Suit s) {
        this.cardValue = cv;
        this.suit = s;
    }
    
    public CardValue getCardValue() {
        return cardValue;
    }

    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}
