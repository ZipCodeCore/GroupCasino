package io.zipcoder.casino.Players;

import io.zipcoder.casino.Cards.Card;

import java.util.List;

public class CardPlayer extends Player {
    private List<Card> hand;

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

}
