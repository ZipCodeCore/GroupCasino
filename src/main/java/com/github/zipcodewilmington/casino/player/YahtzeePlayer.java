package com.github.zipcodewilmington.casino.player;

public class YahtzeePlayer extends Player {

    Player player;

    public YahtzeePlayer(Player player) {
        this.player = player;
    }

    public YahtzeePlayer() {
    }

    public Player getPlayer() {
        return this.player;
    }

}
