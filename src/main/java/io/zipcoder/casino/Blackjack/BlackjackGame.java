package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.CardGame;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Menus.BlackjackMenu;
import io.zipcoder.casino.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class BlackjackGame extends CardGame implements Game {

    private String name = "Blackjack";
    public static final HashMap<String, Integer> cardMap = null;
    private double minBet;
    private double maxBet;
    private BlackjackPlayer player;
    private BlackjackNPCPlayer dealer;
    private ArrayList<BlackjackHand> hands;
    private int numDecks;

    public BlackjackGame(double minBet, double maxBet, Player incomingPlayer) {
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.player = new BlackjackPlayer(incomingPlayer);
    }

    public void setMinBet(double minBet) {
        this.minBet = minBet;
    }

    public void setMaxBet(double maxBet) {
        this.maxBet = maxBet;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getMinBet() {
        return minBet;
    }

    public double getMaxBet() {
        return maxBet;
    }

    public void startPlay() {
        new BlackjackMenu(this).displayMenu();

        System.out.println("Blackjack, sucka!");
    }

    public ArrayList<BlackjackHand> initialDeal() {
        return null;
    }

    public BlackjackNPCPlayer createDealer() {
        return null;
    }


    public void roundOfPlay() {

    }

    public void endChoice() {

    }

    public boolean checkDeck() {
        return false;
    }

    public void displayTable() {

    }

    // returns 0 if you lost, bet size if you pushed, 2x/2.5x bet size if you won
    public double calculateWinnings (BlackjackHand handToEvaluate) {
        return 0.0;
    }

}
