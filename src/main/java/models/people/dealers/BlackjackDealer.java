package models.people.dealers;

import models.gamecomponents.Card;
import models.gamecomponents.DeckOfCards;
import models.hands.BlackjackHand;

public class BlackjackDealer extends Dealer {
    Dealer blackjackDealer;
    BlackjackHand hand = new BlackjackHand();

    public BlackjackDealer(String firstName, String lastName, double balance) {
        super(firstName, lastName, balance);
    }

    public Dealer getBlackjackDealer() {

        return blackjackDealer;
    }

    public void setBlackjackDealer(Dealer blackjackDealer) {

        this.blackjackDealer = blackjackDealer;
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
