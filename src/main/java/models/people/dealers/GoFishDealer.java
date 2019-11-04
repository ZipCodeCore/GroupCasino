package models.people.dealers;

import models.gamecomponents.Card;
import models.gamecomponents.DeckOfCards;
import models.hands.GoFishHand;

public class GoFishDealer extends Dealer {
    Dealer goFishDealer;
    GoFishHand hand = new GoFishHand();

    public GoFishDealer(Dealer dealer) {
        this.goFishDealer = dealer;
    }

    public Integer askForCard(){
        return null;
    }

    public Card drawCard() {
        return null;
    }

    public Card giveCard() {
        return null;
    }

    public DeckOfCards shuffle(DeckOfCards deck) {
        return null;
    }


}
