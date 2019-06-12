package io.zipcoder.casino.player;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class GoFishPlayer extends CardGamePlayer {


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

    @Override
    public void setAccount(Double account) {
        super.setAccount(account);
    }

}
