package com.github.zipcodewilmington.casino.player;

import com.github.zipcodewilmington.casino.card.Card;
import com.github.zipcodewilmington.casino.card.Hand;

import java.util.ArrayList;

public class WarPlayer extends Player {
    Player player;
    Hand hand;

    public WarPlayer(Player player) {
        this.player = player;
    }

    public WarPlayer() {

    }

    public void setWarHand(Hand hand) {
        this.hand = hand;
    }

    public Hand getWarHand() {
        return this.warHand;

    public Player WarPlayer() {
        return this.player;
    }
}
