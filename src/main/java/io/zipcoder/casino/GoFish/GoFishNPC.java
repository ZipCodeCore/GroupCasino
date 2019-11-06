package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class GoFishNPC extends GoFishPlayer{

    private Player opponent;
    private ArrayList<GoFishRound>hands;

    public GoFishNPC (Player opponent) {
        super(opponent);

    }

    public Player getPlayer(){
        return opponent;
    }


}
