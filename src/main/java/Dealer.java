

public interface Dealer {
    public static Hand dealPokerHand() { return new PokerHand();}
    public static Hand dealPalaceHand() { return new PalaceHand();}
    public static Hand dealBlackJackHand() {return new BlackJackHand();}
    public static Card dealCard(Integer numberOfCards) { return new Card();}
    public static void shuffle() {}


}
