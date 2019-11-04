package models.people.dealers;

import models.gamecomponents.Dice;
import models.hands.KlondikeHand;

public class KlondikeDealer extends Dealer {
    Dealer klondikeDealer;
    KlondikeHand hand = new KlondikeHand();

    public KlondikeDealer(Dealer dealer) {
        this.klondikeDealer = dealer;
    }

    public Integer rollDice(Dice dice){
        return null;
    }

}
