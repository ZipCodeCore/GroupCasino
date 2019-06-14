import java.util.ArrayList;

public class BlackJack_Player extends Player implements Gambling {
    ArrayList<Integer> chips = new ArrayList<Integer>();
    private Person player;
    Integer bet;
    Hand hand = new BlackJackHand();

    public BlackJack_Player(Person player) {
        super(player);
    }

    public Boolean didWin(){ return false;}
    public void makeMove(){}
    public void leaveGame(){}
    public void split() {}
    public void hitOrStay() {}
    public void doubleDown() {}

    @Override
    public Integer bet(Integer numOfChipsToBet) {
        return null;
    }
}
