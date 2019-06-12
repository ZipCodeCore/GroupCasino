import java.util.ArrayList;

public class PokerPlayer extends Player implements Gambling {
    ArrayList<Integer> chips = new ArrayList<Integer>();
    Integer bet;
    Hand hand = new PokerHand();

    public PokerPlayer(Person p) {
        super(p);
    }


    public void leaveGame(){}
    public void call() {}
    public void check() {}
    public void fold() {}
    public void raise() {}
    public void makeBet() {}

    @Override
    public Integer bet() {
        return null;
    }
}
