package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Player;

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
