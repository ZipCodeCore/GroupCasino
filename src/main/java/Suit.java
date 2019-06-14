public enum Suit {
    DIAMOND ("Diamonds", "\u2666"),
    HEART   ("Hearts", "\u2665"),
    SPADE   ("Spades", "\u2660"),
    CLUB    ("Clubs", "\u2663");

    public String getSuitString() {
        return suitString;
    }

    public String getSuitImage() {
        return suitImage;
    }

    private final String suitString;
    private final String suitImage;
    Suit(String suitString, String suitImage) {
        this.suitImage = suitImage;
        this.suitString = suitString;
    }
}
