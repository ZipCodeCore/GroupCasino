

public interface Dealer {
    public  Hand dealRound(Integer numberOfCards, Boolean faceDown);
    public  Hand dealHand(Integer numberOfC );
    public  Card dealCard(Integer numberOfCards);
    public  void shuffle();


}
