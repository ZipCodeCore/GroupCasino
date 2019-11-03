package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.CardGame;
import io.zipcoder.casino.CardSet;
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
    private CardSet shoe;
    private int numDecks;

    public BlackjackGame(double minBet, double maxBet, Player incomingPlayer) {
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.player = new BlackjackPlayer(incomingPlayer);
        this.dealer = new BlackjackNPCPlayer(new Player("Mr.", "Roboto", 50, 1000000.00), 16, true);
        this.numDecks = 5;
        this.hands = new ArrayList<BlackjackHand>(0);
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

    public int getNumDecks() {
        return numDecks;
    }

    public CardSet getShoe() {
        return shoe;
    }

    public ArrayList<BlackjackHand> getHands() {
        return hands;
    }

    public BlackjackPlayer getPlayer() {
        return player;
    }

    public BlackjackNPCPlayer getDealer() {
        return dealer;
    }

    public void startPlay() {
        new BlackjackMenu(this).displayMenu();
        checkShoe();
        initialDeal();
        System.out.println("Blackjack, sucka!");
    }

    public void initialDeal() {
        this.hands.add(new BlackjackHand(40.00, this.player, this.shoe.removeFirstCard(), this.shoe.removeFirstCard()));
        this.hands.add(new BlackjackHand(40.00, (BlackjackPlayer) this.dealer, this.shoe.removeFirstCard(), this.shoe.removeFirstCard()));
    }

    public void roundOfPlay() {

    }

    public void endChoice() {

    }

    public void checkShoe() {
        if (this.shoe == null || this.shoe.size() < this.numDecks * 26) {
            this.shoe = getNewShoe();
        }
    }

    public CardSet getNewShoe() {
        CardSet newShoe = new CardSet(this.numDecks);
        newShoe.shuffle();
        return newShoe;
    }

    public void displayTable() {

    }

    // returns 0 if you lost, bet size if you pushed, 2x/2.5x bet size if you won
    public double calculateWinnings (BlackjackHand handToEvaluate) {
        return 0.0;
    }

}
