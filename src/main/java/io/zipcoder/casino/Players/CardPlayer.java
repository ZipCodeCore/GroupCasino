package io.zipcoder.casino.Players;

import io.zipcoder.casino.Cards.Card;

import java.util.List;

public class CardPlayer extends Player {

    public CardPlayer(Profile profile){
        super(profile);
    }

    private List<Card> hand;

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {

        this.hand = hand;
    }

    public Profile getProfile(){
       return super.getProfile();
    }

    public int getBalance(){
        return getProfile().getBalance();
    }
    public void setBalance(int newBalance){
        getProfile().setBalance(newBalance);
    }

}
