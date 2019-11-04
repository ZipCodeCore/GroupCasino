package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.CardGame.CardGame;
import io.zipcoder.casino.CardGame.Cards.Deck;
import io.zipcoder.casino.GamblingGame;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

public class Blackjack extends CardGame implements GamblingGame {
    private double pot;
    private BlackjackPlayer blackjackPlayer;
    private BlackjackPlayer dealer;
    private Player player;
    private Deck deck;
    private double bet;
    private int playerCardTotal;
    private int dealerCardTotal;
    private Console console = Console.getInstance();


    public Blackjack(Player player) {
        this.blackjackPlayer = new BlackjackPlayer(player);
        this.pot = 0;
        this.player = new Player("Dealer", 0);
        this.dealer = new BlackjackPlayer(this.player);
        this.deck = new Deck(10);
        this.deck.shuffle();
    }

    public void takeBet(double amount) {
        pot += amount;
    }

    public double payout() {

        return this.pot * 2;


    }


    public double push(){
        return 0;
    }

    public void play() {
        setBet(console.getDoubleInput("How much money do you want to lose? "));

        while (!validateBet()){
            setBet(console.getDoubleInput("Whoa there, scammer! You can't bet what you don't have! "));

        }

        blackjackPlayer.bet(getBet());
        takeBet(getBet());

        blackjackPlayer.setHand(deck.deal(2));
        dealer.setHand(deck.deal(2));

        console.println(blackjackPlayer.getHand().toString());

        console.println("Your cards total " + blackjackPlayer.sumOfHand().toString());

        if (blackjackPlayer.sumOfHand() == 21){
            console.println("Congrats, cheater! You win!");
            blackjackPlayer.collect(payout());
            this.pot = 0;
            play();
        }

        else if (blackjackPlayer.sumOfHand() > 21){
            console.println("You lose!");
            this.pot = 0;
            play();
        }

        else {
            int choice = console.getIntegerInput(menu());

        }








    }

    public boolean validateBet(){
        boolean result = false;
        if (this.bet < this.blackjackPlayer.getBlackjackPlayerWallet()) {
            result = true;

        }

        return result;
    }

    public void walkAway() {

    }

    public double getPot(){
        return pot;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public double getBet() {
        return this.bet;
    }

    public String menu() {
        return "**Enter 1 to Hit\n**Enter 2 to Stand \n**Enter 3 to Double Down\n**Enter 4 to Split\n**Enter 5 to Walk away\n\nMake a Move! ";

    }
}
