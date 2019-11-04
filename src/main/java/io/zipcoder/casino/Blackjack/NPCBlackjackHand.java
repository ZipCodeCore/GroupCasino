package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.Blackjack.BlackjackHand;
import io.zipcoder.casino.Blackjack.BlackjackPlayer;
import io.zipcoder.casino.Card;

public class NPCBlackjackHand extends BlackjackHand {

    public NPCBlackjackHand(double bet, BlackjackPlayer player, Card card1, Card card2) {
        super(bet, player, card1, card2);
    }

    @Override
    public int playChoice() {
        return 0;
    }

}
