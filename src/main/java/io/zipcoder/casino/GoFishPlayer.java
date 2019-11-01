package io.zipcoder.casino;

import java.util.ArrayList;

public class GoFishPlayer {

    private CardSet hand;
    private Player player;

    public GoFishPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public CardSet getHand() {
        return hand;
    }
}
