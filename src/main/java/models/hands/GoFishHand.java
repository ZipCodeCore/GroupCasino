package models.hands;

import models.gamecomponents.Card;

import java.util.ArrayList;

public class GoFishHand extends Hand {


    public GoFishHand(Card... cards) {
        this.hand = new ArrayList();

    }

    public Boolean checkForSet() {
        return null;
    }

    public Boolean addCardToSet(Card card) {
        return null;
    }
}
