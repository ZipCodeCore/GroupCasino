package io.zipcoder.casino.player;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class CardGamePlayer extends Player {
    public ArrayList<Card> hand;

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void endturn() {};

    public CardGamePlayer(){};

    public CardGamePlayer(String name, Double account) {
        super(name, account);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }


    @Override
    public Double getAccount() {
        return super.getAccount();
    }



}
