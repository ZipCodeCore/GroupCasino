public class Card {

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

    public Integer getRank() {
        return rank.getRankNumber();
    }

    public Suit getSuit() {
        return suit;
    }

    public Integer getValue() {return 0;}


    public void flip() {}

}
