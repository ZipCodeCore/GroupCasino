public enum Rank {
    ACE   (1, "A", "\u24b6"),
    TWO   (2, "2", "\u2461"),
    THREE (3, "3", "\u2462"),
    FOUR  (4, "4", "\u2463"),
    FIVE  (5, "5", "\u2464"),
    SIX   (6, "6", "\u2465"),
    SEVEN (7, "7", "\u2466"),
    EIGHT (8, "8", "\u2467"),
    NINE  (9, "9","\u2468"),
    TEN   (10, "10", "\u2469"),
    JACK  (11, "J", "\u24bf"),
    QUEEN (12, "Q", "\u24c6"),
    KING  (13, "K", "\u24c0");

    public Integer getRankNumber() {
        return rankNumber;
    }

    public String getRankString() {
        return rankString;
    }
    public String getRankImage() { return rankImage; }

    private final Integer rankNumber;
    private final String rankString;
    private final String rankImage;

    Rank(Integer rankNumber, String rankString, String rankImage) {
        this.rankNumber = rankNumber;
        this.rankString = rankString;
        this.rankImage = rankImage;

    }
}
