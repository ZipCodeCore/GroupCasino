import java.util.ArrayList;
import java.util.List;

public class Poker extends CardGame {

    List<Card> communityCard;
 //   List<PokerTurn> turns;
    Integer pool = 0;
    Integer lastBet = 0;
    List<PokerPlayer> pokerPlayerList;  // to store all player
    Console console;

    public Poker(PokerPlayer[] players, Console console) {
        super(players, 1);
        this.console = console;
        pokerPlayerList = new ArrayList<>();
        /* TODO: after the changes of Players array to Single player, store the
        *  TODO: player to list and make some poker AI into the list
        * */
    }

    public Boolean didWin(Player player) {return false;}

    public void playGame() {
        while (!onePlayerStanding() && !showDownTime()) {
            determineTurnToPlay();
        }
        PokerPlayer winner = showDown();
        awardPool(winner);
        endOfGame();
    }

    private void determineTurnToPlay() {
        if(communityCard.size() == 0)
            preFlop();
        else
            postFlop();

    }

    private void preFlop() {
        // small blind
        // big blind
        // distribute hand
        // startBetting
        // flop
    }


    private void postFlop() {
        // startBetting
        // add card
    }

    private PokerPlayer showDown() {
        // compare communityCard + player hand against list
        // return winner
        return null;
    }

    private Boolean showDownTime() {
        return communityCard.size() >= 5;
    }

    public void startBetting () {
        // loop {
        // next person choose from fold, call, raise
        //  end loop if both condition are met
        // everyone who is not folded bet same amount
        //    OR
        //  number of folded player == players.size-1 (the one left wins)
        // }
        lastBet = 0;
        while (true)
        {
            playersChooseAction(lastBet);
            if(onePlayerStanding() || everyoneBetSame())
                break;
        }
    }

    private void playersChooseAction(Integer lastBet) {
        for (PokerPlayer pokerPlayer : pokerPlayerList)
            if (!pokerPlayer.isFolded())
                updatePool(pokerPlayer.getBetFromAction(console, lastBet));

    }

    private void updatePool(Integer betFromAction) {
        if (betFromAction != null) {
            pool += betFromAction;
            lastBet = betFromAction;
        }

    }

    private Boolean isNPC(PokerPlayer player) {
        return player instanceof PokerNPC;
    }

    private Boolean onePlayerStanding() {
        Integer numOfFoldedPlayer = 0;
        for (PokerPlayer pokerPlayer : pokerPlayerList)
            if (pokerPlayer.isFolded())
                numOfFoldedPlayer++;

        return numOfFoldedPlayer == pokerPlayerList.size()-1;
    }

    private Boolean everyoneBetSame() {
        return true;
    }

    private void awardPool(PokerPlayer winner) {
        winner.addChips(pool);
        pool = 0;
    }


    public void endOfGame() {
        // ask if keep playing
        // if keep playing
        // reset bet
        // change seat
        // call playGame
    }

    public void resetLastBet() {lastBet = 0;}
}
