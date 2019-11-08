package io.zipcoder.casino.GamePieces;

public class Card implements Comparable<Card> {
    private Suit suit;
    private CardValue cardValue;

    public Card (CardValue cardValue, Suit suit){
        this.cardValue= cardValue;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;

    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.cardValue.getValue(), o.cardValue.getValue());
    }
}
