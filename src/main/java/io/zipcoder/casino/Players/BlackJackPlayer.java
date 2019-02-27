package io.zipcoder.casino.Players;

import io.zipcoder.casino.CardsAndDice.Card;

import java.util.List;

public class BlackJackPlayer extends Player {

    public BlackJackPlayer(Profile profile){
        super(profile);
    }

    private List<Card> hand;

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {

        this.hand = hand;
    }

    public Profile getProfile(){
       return super.getProfile();
    }

    public int getBalance(){
        return getProfile().getBalance();
    }
    public void setBalance(int newBalance){
        getProfile().setBalance(newBalance);
    }

//    public void addToHand(List<Card> cards) {if(hand != null) {this.hand.addAll(cards);  Collections.sort(hand);} }
//    public void addToHand(Card card) {if(hand != null) {this.hand.add(card);  Collections.sort(hand);} }

}
