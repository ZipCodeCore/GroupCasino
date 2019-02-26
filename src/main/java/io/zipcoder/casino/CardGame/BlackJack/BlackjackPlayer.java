package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.CardGame.Cards.Card;
import io.zipcoder.casino.CardGame.Cards.Deck;
import io.zipcoder.casino.CardGame.Hand;
import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class BlackjackPlayer implements GamblingPlayer {
    private Hand hand;
    private Player player;
    private double wallet;

    public BlackjackPlayer(Player player) {
        this.player = player;
        this.wallet = player.getWallet();

    }

    public double getBlackjackPlayerWallet() {
        return this.wallet;

    }

    public void bet(double amount) {
        this.wallet -= amount;

    }

    public void collect(double amount) {
        this.wallet += amount;
    }

    public void hit(Deck deck) {
        this.hand.drawCard(deck);
    }

    public void stand() {
    }

    public void doubleDown() {
    }

    public void split() {
    }

    public int sumOfHand(Hand hand) {
        return 0;
    }

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(ArrayList<Card> cards) {
        this.hand = new Hand(cards);
    }

    public int numberOfCardsInHand() {
        return this.hand.getSize();
    }
}
