package models.hands;

import models.gamecomponents.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BlackjackHand extends Hand {
    Integer handValue;
    Map<String, Integer> valueMap = new HashMap();

    public BlackjackHand(Card... cards) {
        this.hand = new ArrayList();
    }

    public String getHand() {
        return hand.toString();
    }

    public Integer getHandValue() {
        return handValue;
    }

    public Integer calculateHandValue() {
        return null;
    }

    public Integer getcardValue(String cardValue) {
        return valueMap.get(cardValue);
    }

    public Boolean checkForBust() {
        return null;
    }

    public Integer changeAceValue() {
        return null;

    }
}
