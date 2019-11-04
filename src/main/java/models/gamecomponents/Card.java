package models.gamecomponents;

public class Card extends GameComponent{
    private CardSuit suit;
    private CardValue cardValue;

    public Card() {

    }

    public CardSuit getSuit()
    {
        return suit;
    }

    public void setSuit(CardSuit suit)
    {
        this.suit = suit;
    }

    public CardValue getCardValue()
    {
        return cardValue;
    }

    public void setCardValue(CardValue cardValue)
    {
        this.cardValue = cardValue;
    }
}
