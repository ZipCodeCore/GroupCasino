package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class BlackjackNPCPlayer extends BlackjackPlayer {

    private int threshold;
    private boolean isDealer;
    private ArrayList<BlackjackHand> hands;
    private Player player;

    public BlackjackNPCPlayer(Player player, int threshold, boolean isDealer) {
        super(player);
        this.threshold = threshold;
        this.isDealer = isDealer;
    }

    public int getThreshold() {
        return threshold;
    }

    public boolean isDealer() {
        return isDealer;
    }

    public Player getPlayer() {
        return player;
    }


}
