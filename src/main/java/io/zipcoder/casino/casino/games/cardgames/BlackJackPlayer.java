package io.zipcoder.casino.casino.games.cardgames;

import io.zipcoder.casino.casino.Player;
import io.zipcoder.casino.casino.Profile;
import io.zipcoder.casino.casino.games.cardgames.cardutilities.Card;

import java.util.List;

public class BlackJackPlayer extends Player {

    public BlackJackPlayer(Profile profile){
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
