package com.github.zipcodewilmington.casino.player;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer {

    Player player;
    private int bet;

    public SlotsPlayer(Player player) {
        this.player = player;
    }

    public SlotsPlayer() {
    }

    public Player getPlayer() {
        return this.player;
    }

    public void updatePlayerBalance() {
        player.setPlayerBalance(player.getPlayerBalance() + bet);
    }
}