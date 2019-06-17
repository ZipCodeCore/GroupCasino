package io.zipcoder.casino.player;
import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.games.GoFish;
import io.zipcoder.casino.gameTools.Card;


import java.util.ArrayList;

public class GoFishPlayer extends CardGamePlayer {
    String name;
    Integer score;

    public GoFishPlayer(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public GoFishPlayer() {}

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    public GoFishPlayer(Player player) {
        super(player);
        score = 0;
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
