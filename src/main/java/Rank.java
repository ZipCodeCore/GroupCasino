public enum Rank {
    ACE   (1, "A"),
    TWO   (2, "2"),
    THREE (3, "3"),
    FOUR  (4, "4"),
    FIVE  (5, "5"),
    SIX   (6, "6"),
    SEVEN (7, "7"),
    EIGHT (8, "8"),
    NINE  (9, "9"),
    TEN   (10, "10"),
    JACK  (11, "J"),
    QUEEN (12, "Q"),
    KING  (13, "K"),
    P     (14, "P");

    public Integer getRankNumber() {
        return rankNumber;
    }

    public String getRankString() {
        return rankString;
    }

    private final Integer rankNumber;
    private final String rankString;

    Rank(Integer rankNumber, String rankString) {
        this.rankNumber = rankNumber;
        this.rankString = rankString;
    }
}
