package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.utilities.Console;

public class NPCBlackjackHand extends BlackjackHand {

    private Console console = new Console(System.in, System.out);

    public NPCBlackjackHand(double bet, BlackjackPlayer player, Card card1, Card card2) {
        super(bet, player, card1, card2);
    }

    @Override
    public int playChoice(CardSet shoe) {
        console.sleep(500);
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
