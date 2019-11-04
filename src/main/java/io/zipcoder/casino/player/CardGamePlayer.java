package io.zipcoder.casino.player;


import io.zipcoder.casino.gameTools.Card;

import java.util.ArrayList;


public class CardGamePlayer {
    private Player player;
    private ArrayList<Card> hand;
    private Integer score;
    private String name;


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }



    public CardGamePlayer (Player player) {
        this.player = player;
    }
    public CardGamePlayer () {

    }
        public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void endturn() {};

    public CardGamePlayer(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return player.getName();
    }


    public void setName(String name) {
        player.setName(name);
    }

    public void setAccount(Double balance) {
        player.setAccount(balance);
    }

    public Double getAccount() {
        return player.getAccount();
    }



}
