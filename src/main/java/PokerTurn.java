public class PokerTurn extends Turn {
    public Boolean validMove() {return false;}


    public void startBetting () {
        // loop {
    // next person choose from fold, call, raise
    //  end loop if both condition are met
    // 1. everyone who is not folded bet same amount
    // 2. everyone acted
    //    OR
    //  number of folded player == players.size-1 (the one left wins)
    // }
    }
}

// First turn
// next person small blind
// next person big blind
// distribute two card for each player
// startBetting()
// set 3 card on communityCard (flop)
// startBetting()
// add a card
// startBetting()
/// add a card
// startBetting()

