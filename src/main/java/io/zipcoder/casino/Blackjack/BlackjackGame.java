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
    public static final HashMap<String, Integer> cardMap = new HashMap<String,Integer>();
    static {
        for (int i = 2; i <= 10; i++) {
            cardMap.put(String.valueOf(i), i);
        }
        cardMap.put("J",10);
        cardMap.put("Q",10);
        cardMap.put("K",10);
        cardMap.put("A",11);
    }

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
        BlackjackHand playerHand = new BlackjackHand(40.00, this.player, this.shoe.removeFirstCard(), this.shoe.removeFirstCard());
        this.hands.add(playerHand);
        this.player.addHand(playerHand);

        BlackjackHand dealerHand = new BlackjackHand(40.00, (BlackjackPlayer) this.dealer, this.shoe.removeFirstCard(), this.shoe.removeFirstCard());
        this.hands.add(dealerHand);
        this.dealer.addHand(dealerHand);
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
