package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackjackHand {

    private ArrayList<Card> cards;
    private double bet;
    private int value;
    private BlackjackPlayer player;

    public BlackjackHand(double bet, BlackjackPlayer player) {
        this.bet = bet;
        this.player = player;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public double getBet() {
        return bet;
    }

    public int getValue() {
        return value;
    }

    public BlackjackPlayer getPlayer() {
        return player;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPlayer(BlackjackPlayer player) {
        this.player = player;
    }

    public int playChoice(){
        return 0;
    }

    public int determineHandValue() {
        return 0;
    }

    //
    public BlackjackHand splitHand() {
        return null;
    }


}
