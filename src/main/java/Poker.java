import java.util.ArrayList;
import java.util.List;

public class Poker extends CardGame{

    List<Card> communityCard;
 //   List<PokerTurn> turns;
    Integer pool;

    public Poker(PokerPlayer[] players) {
        super(players, 1);
//        turns = new ArrayList<>();
    }

    public Boolean didWin(Player player) {return false;}
    public Boolean isSomeoneWon() {return false;}

    public void playGame() {
        while (!isSomeoneWon()) {


            // while no one wins
            // create Turn
        }

    }

    public void startBetting () {
        // loop {
        // next person choose from fold, call, raise
        //  end loop if both condition are met
        // 1. everyone who is not folded bet same amount
        // 2. everyone acted
        //    OR
        //  number of folded player == players.size-1 (the one left wins)
        // }
        while (true)
        {
            if(onePlayerStanding() || everyoneDoneBet())
            {
                break;
            }
        }
    }

    private Boolean onePlayerStanding() {
        return true;
    }

    private Boolean everyoneDoneBet() {
        return true;
    }

    public void endOfGame() {
        // change seat if keep playing??
    }

}
