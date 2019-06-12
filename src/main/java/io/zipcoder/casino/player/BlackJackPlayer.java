package io.zipcoder.casino.player;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Deck;


import java.util.ArrayList;

public class BlackJackPlayer extends Player implements GamblerInterface {
     ArrayList<Card> hand;

    public BlackJackPlayer(){
        super();
        this.hand = new ArrayList<Card>();

    }
    public void bet(Integer bet) {
    }

    public void betType (String betType) {
    }

    public void cashout() {
    }
}
