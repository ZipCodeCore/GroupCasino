package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.Blackjack.BlackjackHand;
import io.zipcoder.casino.Blackjack.BlackjackPlayer;
import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;

public class NPCBlackjackHand extends BlackjackHand {

    public NPCBlackjackHand(double bet, BlackjackPlayer player, Card card1, Card card2) {
        super(bet, player, card1, card2);
    }

    @Override
    public int playChoice(CardSet shoe) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        if (this.getValue() <= ((BlackjackNPCPlayer) this.getPlayer()).getThreshold()) {
            int val = hit(shoe.removeFirstCard());
            if (val != 0) {
                return -1;
            } else {
                return 0;
            }
        }
            return this.getValue();
    }

}
