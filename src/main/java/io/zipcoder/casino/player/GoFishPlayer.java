package io.zipcoder.casino.player;

import io.zipcoder.casino.games.GoFish;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class GoFishPlayer extends CardGamePlayer {
    Player player;

    public GoFishPlayer() {}

    public GoFishPlayer(Player player) {
        this.player = player;
    }

    public void endturn() {};

    @Override
    public ArrayList<Card> getHand() {
        return super.getHand();
    }

    @Override
    public void setHand(ArrayList<Card> hand) {
        super.setHand(hand);
    }

    @Override
    public Double getAccount() {
        return super.getAccount();
    }

}
