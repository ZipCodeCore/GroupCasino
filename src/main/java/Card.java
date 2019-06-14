public class Card {

    private Integer faceUp;
    private Rank rank;
    private Suit suit;

    public Card(Integer faceDown, Rank rank, Suit suit) {
        this.faceUp = faceDown;
        this.rank = rank;
        this.suit = suit;
    }

    public void setFaceDownToEveryone() {
        this.faceUp = -1;
    }
    public void setFaceUpToMe() {
        this.faceUp = 0;
    }
    public void setFaceUpToEveryone() {
        this.faceUp = 1;
    }
    public Boolean isFaceDownToEveryone() {
        return (faceUp == -1);
    }
    public Boolean isFaceUpToMe() {
        return (faceUp == 0);
    }
    public Boolean isFaceUpToEveryone() {
        return (faceUp == 1);
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
