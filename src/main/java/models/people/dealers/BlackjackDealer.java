package models.people.dealers;

import models.gamecomponents.Card;
import models.gamecomponents.DeckOfCards;
import models.hands.BlackjackHand;

public class BlackjackDealer extends Dealer {
    Dealer blackjackDealer;
    BlackjackHand hand = new BlackjackHand();

    public BlackjackDealer(Dealer dealer) {
        this.blackjackDealer = dealer;
    }

    public Card hit() {
        return null;
    }

    public Boolean stay() {
        return null;
    }

    public DeckOfCards shuffle(DeckOfCards deck) {
        return null;
    }

}
