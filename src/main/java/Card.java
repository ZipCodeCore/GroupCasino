public class Card {
    enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}
    enum Suit {HEART, DIAMOND, SPADE, CLUB}

    private Boolean faceDown;
    private Rank rank;
    private Suit suit;

    public Card(Boolean faceDown, Rank rank, Suit suit) {
        this.faceDown = faceDown;
        this.rank = rank;
        this.suit = suit;
    }

    public void setFaceDown() {
        this.faceDown = true;
    }

    public void setFaceUP() {
        this.faceDown = false;
    }

    public Boolean getFaceDown() {
        return faceDown;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getValue() {return "";}


    public void flip() {}

}
