package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Collections;

public class GoFish extends CardGame {

    private Console c;
    private GoFishDisplay d;
    private Integer pairCountPlayer;
    private Integer pairCountDealer;
    private String rankRequested;
    private String turn;

    public GoFish() {

        this.c = new Console(System.in, System.out);
        this.d = new GoFishDisplay();

        this.pairCountPlayer = 0;
        this.pairCountDealer = 0;
        this.turn = "player";
        this.rankRequested = "";
    }

    public String getTurn() {
        return this.turn;
    }

    public void setTurn(String newTurn) {
        this.turn = newTurn;
    }

    public String getRankRequested() {
        return this.rankRequested;
    }

    public void setBookCounts(int bookCountPlayer, int bookCountDealer) {
        this.pairCountPlayer = bookCountPlayer;
        this.pairCountDealer = bookCountDealer;
    }

    public int getPairCountPlayer() {
        return this.pairCountPlayer;
    }

    public int getPairCountDealer() {
        return this.pairCountDealer;
    }

    public void setRankRequested(String rank) {
        this.rankRequested = rank;
    }

    public void setupGame(int numberOfCards) {
        this.createNewDeck();
        this.shuffleCards();
        this.dealCards(numberOfCards);
    }

/*
    public void getRankToAskFor_Human() {
    // Move to display class??
    public String displayPlayersHand(ArrayList<String> playersHand) {
        String playersHandOutput = "";
        Iterator itr = playersHand.iterator();
        while(itr.hasNext()) {
            playersHandOutput += itr.next() + "\n";
        }
        return playersHandOutput;
    }*/

    public void getRankToAskFor_Human() {

        d.printWhatRankYouWillAskFor();
        this.rankRequested = c.getStringInput("", null);
    }

    public void getRankToAskFor_Computer() {
       int pickCard = (int) Math.random() * (this.dealersHand.size() - 1);
       this.rankRequested = this.getRankOnCard(this.dealersHand.get(pickCard));
    }

    public boolean checkIfRankInHand(ArrayList<String> handToCheck) {
        for (int i = 0; i < handToCheck.size(); i++) {
            if (getRankOnCard(handToCheck.get(i)).equals(this.rankRequested)) {
                return true;
            }
        }
        return false;
    }

    public void takeCardFromOtherPlayer(ArrayList<String> playerTakingCard, ArrayList<String> playerGivingCard, String rankAskedFor) {
        for (int i = 0; i < playerGivingCard.size(); i++) {
            if (this.getRankOnCard(playerGivingCard.get(i)).equals(rankAskedFor)) {
                playerTakingCard.add(playerGivingCard.get(i));
                playerGivingCard.remove(i);
            }
        }
    }

    public void drawCardFromDeck(ArrayList<String> playerHand) {
        playerHand.add(this.deck.get(0));
        this.deck.remove(0);
    }

    public String checkPairInHand(ArrayList<String> currentPlayer) {
        Collections.sort(currentPlayer);
        int count = 1;
        for (int i = 1; i < currentPlayer.size(); i++) {
            if (this.getRankOnCard(currentPlayer.get(i - 1)).equals(this.getRankOnCard(currentPlayer.get(i)))) {
                count += 1;
                if (count == 2) {
                    return this.getRankOnCard(currentPlayer.get(i));
                }
            } else {
                count = 1;
            }
        }
        return null;
    }

    //public void checkForPairsInCurrentPlayersHand(ArrayList<String> currentPlayer) {


    public int removePairFromHand(ArrayList<String> currentPlayer) {
        String rankToRemove = checkPairInHand(currentPlayer);
        if (rankToRemove != null) {
            int i = 0;
            while(i < currentPlayer.size()) {
                if (getRankOnCard(currentPlayer.get(i)).equals(rankToRemove)) {
                    currentPlayer.remove(i);
                } else {
                    i++;
                }
            }
            return 1;
        }
        return 0;
    }

    public void incrementPairCountPlayer(int num) {
        this.pairCountPlayer += num;
    }

    public void incrementPairCountDealer(int num) {
        this.pairCountDealer += num;
    }

    public boolean checkGameOver() {
        if (this.pairCountDealer + this.pairCountPlayer == 13) {
            return true;
        }
        return false;
    }

    public String checkWinner() {
            if (this.pairCountDealer > this.pairCountPlayer) {
                return "Opponent";
            } else {
                return "Player";
            }
    }

    public String startGame() {
        return null;
    }

    public Double acceptBetFrom(Double betAmount) {
        return null;
    }

    public Double acceptBetFrom() {
        return null;
    }

    public Double calculateReward() {
        return null;
    }

    public Double calculateLoss() {
        return null;
    }

    public String endGame() {
        return null;
    }
}












