package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.CardGame.Hand;
import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Player;

public class BlackjackPlayer implements GamblingPlayer {
    private String name;
    private double wallet;
    private Hand hand;
    private Player player;

    public BlackjackPlayer(Player player) {
    }

    public double bet(double amount) {
        return 0;
    }

    public void collect(double amount) {
    }

    public void hit() {
    }

    public void stand() {
    }

    public void doubleDown() {
    }

    public void split() {
    }

    public int sumOfHand(Hand hand) {
        return 0;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

}
