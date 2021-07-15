package com.github.zipcodewilmington.casino.player;

import com.github.zipcodewilmington.casino.card.Hand;

public class WarPlayer extends Player {

    Player player;
    Hand hand = new Hand();

    public WarPlayer(Player player) {
        this.player = player;
    }

    public WarPlayer() {

    }

    public Hand getHand() {
        return hand.getHand();
    }

    public Player WarPlayer() {
        return this.player;
    }
}
