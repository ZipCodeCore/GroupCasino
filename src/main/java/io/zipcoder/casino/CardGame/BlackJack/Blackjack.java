package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.CardGame.CardGame;
import io.zipcoder.casino.CardGame.Cards.Deck;
import io.zipcoder.casino.GamblingGame;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

public class Blackjack extends CardGame implements GamblingGame {
    private double pot;
    private BlackjackPlayer blackjackPlayer;
    private Deck deck = new Deck(10);
    private int bet;
    private int playerTotal;
    private Console console = Console.getInstance();

    public Blackjack(Player player) {
        blackjackPlayer = new BlackjackPlayer(player);
        this.pot = 0;

    }

    public void takeBet(double amount) {
        pot += amount;
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
