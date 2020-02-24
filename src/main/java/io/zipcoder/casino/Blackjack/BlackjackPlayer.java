package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class BlackjackPlayer {

    private ArrayList<BlackjackHand> hands;
    private Player player;

    public BlackjackPlayer(Player player) {
        this.player = player;
        this.hands = new ArrayList<BlackjackHand>();
    }

    public ArrayList<BlackjackHand> getHands() {
        return hands;
    }

    public Player getPlayer() {
        return player;
    }

    public void addHand(BlackjackHand hand) {
        hands.add(hand);
    }

    public void removeHand(BlackjackHand hand) {
        hands.remove(hand);
    }


}
