public class PalacePlayer implements Dealer{

    Hand hand;

    public PalacePlayer(Person player) {

        this.hand = new PalaceHand();
    }

    @Override
    public Hand dealRound(Integer numberOfCards, Boolean faceDown) {
        return null;
    }

    @Override
    public Hand dealHand(Integer numberOfC) {
        return null;
    }

    
    @Override
    public Card dealCard(Integer numberOfCards) {
        return null;
    }

    @Override
    public void shuffle() {

    }
}
