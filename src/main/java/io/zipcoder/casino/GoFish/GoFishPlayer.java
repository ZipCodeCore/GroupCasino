package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class GoFishPlayer {

    private ArrayList<GoFishRound>hands;
    private Player player;

    public GoFishPlayer(Player player){
        this.player = player;
        this.hands = new ArrayList<GoFishRound>();
    }

    public ArrayList<GoFishRound>getHands() {
        return hands;
    }
    public Player getPlayer() {
        return player;
    }
    public void addHand(GoFishRound hand){
        hands.add(hand);
    }
    public void removeHand(GoFishRound hand){
        hands.remove(hand);
    }


}
