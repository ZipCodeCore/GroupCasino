import java.util.ArrayList;
import java.util.List;

public class Poker extends CardGame{

    List<Card> communityCard;
    List<PokerTurn> turns;
    Integer pool;

    public Poker(PokerPlayer[] players) {
        super(players, 1);
        turns = new ArrayList<>();
    }

    public Boolean didWin(Player player) {return false;}
    public Boolean isSomeoneWon() {return false;}

    public void playGame() {
        while (!isSomeoneWon()) {
            PokerTurn turn = new PokerTurn();

            // while no one wins
            // create Turn
        }

    }
    public void endOfGame() {
        // change seat if keep playing??
    }

    public List<PokerTurn> getPlayHistory()
    {
        return turns;
    }
}
