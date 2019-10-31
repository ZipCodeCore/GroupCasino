package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;

public class BlackjackGame extends CardGame implements GamblingGame {

    public static final HashMap<String, Integer> cardMap = null;
    private double minBet;
    private double maxBet;
    private ArrayList<Player> players;
    private ArrayList<BlackjackHand> hands;

    public BlackjackGame(double minBet, double maxBet, int numPlayers, Player incomingPlayer) {
        this.minBet = minBet;
        this.maxBet = maxBet;
    }

    public void startPlay() {

    }

    public void roundOfPlay() {

    }

    public void endChoice() {

    }

    public void checkDeck() {

    }

    public void initialDeal() {

    }

    public void modifyNPCRoster () {

    }

    public void displayTable() {

    }

    public void chooseWinners() {

    }

    public void wager(double amount) {

    }

    public void payOut(double amount) {

    }
}
