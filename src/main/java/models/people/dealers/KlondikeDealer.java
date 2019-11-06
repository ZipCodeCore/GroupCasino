package models.people.dealers;

import models.gamecomponents.Dice;
import models.hands.KlondikeHand;

public class KlondikeDealer extends Dealer {
    Dealer klondikeDealer;
  //  KlondikeHand hand = new KlondikeHand();

    public KlondikeDealer(String firstName, String lastName, double balance) {
        super(firstName, lastName, balance);
    }

    public Integer rollDice(Dice dice){
        return null;
    }

}
