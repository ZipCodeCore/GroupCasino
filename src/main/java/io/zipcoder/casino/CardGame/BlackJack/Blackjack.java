package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.CardGame.CardGame;
import io.zipcoder.casino.CardGame.Cards.Deck;
import io.zipcoder.casino.GamblingGame;

public class Blackjack extends CardGame implements GamblingGame {
    private double pot;
    private BlackjackPlayer blackjackPlayer;
    private Deck deck = new Deck();

    public void takeBet(double amount) {
        pot += amount;
    }

    public void deal() {

    }

    public double payout() {
        return 0;
    }

    public void play() {
    }

    public void walkAway() {

    }

    public double getPot(){
        return pot;
    }
}
