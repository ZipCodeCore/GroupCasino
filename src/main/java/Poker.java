import java.util.ArrayList;
import java.util.List;

public class Poker extends CardGame{

    List<Card> communityCard;
    List<PokerTurn> turns;
    Integer pool;

    public Poker(Player[] players) {
        super(players, 1);
        turns = new ArrayList<>();
    }


    public Boolean didWin(Player player) {return false;}
    public void playGame() {
        // while no no one wins

    }
    public void endOfGame() {}
}
