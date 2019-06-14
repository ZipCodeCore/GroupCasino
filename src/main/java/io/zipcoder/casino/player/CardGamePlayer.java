package io.zipcoder.casino.player;


import io.zipcoder.casino.gameTools.Card;

import java.util.ArrayList;


public class CardGamePlayer {
    private Player player;
    private ArrayList<Card> hand;

    public CardGamePlayer (Player player) {
        this.player = player;

    }


    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void endturn() {};

    public CardGamePlayer(){};

    public String getName() {
        return player.getName();
    }


    public void setName(String name) {
        player.setName(name);
    }



    public Double getAccount() {
        return player.getAccount();
    }



}
