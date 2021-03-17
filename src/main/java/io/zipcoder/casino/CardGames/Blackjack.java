package io.zipcoder.casino.CardGames;
import io.zipcoder.casino.Menus.BlackjackMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;


    public class Blackjack extends CardGame {
        private double minBet;
        private double maxBet;

    public Blackjack(double minBet, double maxBet) {
        this.minBet = minBet;
        this.maxBet = maxBet;

    }


    public void runGame() {

    }

    public void getResults() {

    }

    public void endGame() {

    }


    public void dealCards() {

    }

    public double getMinBet() {
        return minBet;
    }

    public double getMaxBet() {
        return maxBet;
    }

    public void setMinBet(double minBet) {
        this.minBet = minBet;
    }

    public void setMaxBet(double maxBet) {
        this.maxBet = maxBet;
    }
}
