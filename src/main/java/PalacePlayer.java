public class PalacePlayer implements Dealer{

    Hand hand;

    public PalacePlayer(Person player) {

        this.hand = new PalaceHand();
    }


    @Override
    public Card dealCard() {
        return null;
    }

    @Override
    public void shuffle() {

    }
}
