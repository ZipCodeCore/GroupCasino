package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Player;

public class GoFishNPC {
    private CardSet hand;
    private Player player;

    public GoFishNPC (Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public CardSet getHand() {
        return hand;
    }
}
