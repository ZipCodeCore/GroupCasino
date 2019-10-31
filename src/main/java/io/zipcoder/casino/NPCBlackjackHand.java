package io.zipcoder.casino;

public class NPCBlackjackHand extends BlackjackHand {

    public NPCBlackjackHand(double bet, BlackjackPlayer player) {
        super(bet, player);
    }

    @Override
    public int playLoop() {
        return 0;
    }

}
