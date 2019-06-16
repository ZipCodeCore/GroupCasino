import java.util.ArrayList;

public enum PokerHandRank {

    ROYAL_FLUSH     (1),
    STRAIGHT_FLUSH  (2),
    FOUR_OF_A_KIND  (3),
    FULL_HOUSE      (4),
    FLUSH           (5),
    STRAIGHT        (6),
    THREE_OF_A_KIND (7),
    TWO_PAIR        (8),
    PAIR            (9),
    HIGH_CARD       (10);

    final public Integer rank;

    PokerHandRank(Integer rank) {
        this.rank = rank;
    }

    public static PokerHandRank determineHand() {
        return ROYAL_FLUSH;
    }

    public Boolean isFlush(ArrayList<Card> cards)
    {
        return false;
    }

    public Integer getRank() {return rank;}

    public Boolean isContainRoyalFlush(ArrayList<Card> cards) {

        return false;
    };
}
