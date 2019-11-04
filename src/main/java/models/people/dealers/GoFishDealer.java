package models.people.dealers;

import models.gamecomponents.Card;
import models.gamecomponents.DeckOfCards;
import models.hands.GoFishHand;

public class GoFishDealer extends Dealer {
    Dealer goFishDealer;
    GoFishHand hand = new GoFishHand();

    public GoFishDealer(String firstName, String lastName, double balance) {
        super(firstName, lastName, balance);
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
