package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;

import java.util.ArrayList;
import java.util.Arrays;

public class BlackjackHand {

    private CardSet cards;
    private double bet;
    private int value;
    private BlackjackPlayer player;

    public BlackjackHand(double bet, BlackjackPlayer player, Card card1, Card card2) {
        this.bet = bet;
        this.player = player;
        this.cards = new CardSet(0);
        this.cards.addCard(card1);
        this.cards.addCard(card2);
    }

    public CardSet getCards() {
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

    public void setCards(CardSet cards) {
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
