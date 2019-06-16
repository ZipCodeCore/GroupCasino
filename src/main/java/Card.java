public class Card {

    private Integer faceUp;
    private Rank rank;
    private Suit suit;

    public Card(Integer faceUp, Rank rank, Suit suit) {
        this.faceUp = faceUp;
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

    public Integer getRankNumber() {
        return rank.getRankNumber();
    }
    public Rank getRank() {return rank;}

    public Suit getSuit() {
        return suit;
    }

    public Integer getValue() {
        if (isFaceDownToEveryone() | isFaceUpToMe()) return 0;
        return getRankNumber();
    }


    public void flip() {
        if (isFaceDownToEveryone()) setFaceUpToEveryone();
        else if (isFaceUpToEveryone()) setFaceDownToEveryone();
        else if (isFaceUpToMe()) setFaceUpToEveryone();
    }

    @Override
    public String toString() {
        return rank.getRankString()+suit.getSuitImage();
    }
}
