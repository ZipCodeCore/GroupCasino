package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.Blackjack.BlackjackHand;
import io.zipcoder.casino.Blackjack.BlackjackPlayer;

public class NPCBlackjackHand extends BlackjackHand {

    public NPCBlackjackHand(double bet, BlackjackPlayer player) {
        super(bet, player);
    }

    @Override
    public int playChoice() {
        return 0;
    }

}
