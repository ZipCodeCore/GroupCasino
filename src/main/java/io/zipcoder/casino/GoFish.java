package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Collections;

public class GoFish extends CardGame {

    private Console c;
    private GoFishDisplay d;
    private int bookCountPlayer;
    private int bookCountDealer;
    private String turn;

    public GoFish() {

        this.c = new Console(System.in, System.out);
        this.d = new GoFishDisplay();

        this.bookCountPlayer = 0;
        this.bookCountDealer = 0;
        this.turn = "player";
    }

    public void setupGame(int numberOfCards) {
        this.createNewDeck();
        this.shuffleCards();
        this.dealCards(numberOfCards);
    }

    public void setBookCounts(int bookCountPlayer, int bookCountDealer) {
        this.bookCountPlayer = bookCountPlayer;
        this.bookCountDealer = bookCountDealer;
    }

    public String getRankToAskFor_Human() {
        d.printWhatRankYouWillAskFor();
        return c.getStringInput(null, null);
    }

    public String getRankToAskFor_Computer(ArrayList<String> computersHand) {
        int pickCard = (int) Math.random() * (computersHand.size() - 1);
        return this.getRankOnCard(computersHand.get(pickCard));
    }

    public boolean checkIfRankInPlayersHand(ArrayList<String> playersHand, String rankAskedFor) {
        for (int i = 0; i < playersHand.size(); i++) {
            if (getRankOnCard(playersHand.get(i)).equals(rankAskedFor)) {
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

    public String checkFullBookInHand(ArrayList<String> currentPlayer) {
        Collections.sort(currentPlayer);
        int count = 0;
        for (int i = 1; i < currentPlayer.size(); i++) {
            if (this.getRankOnCard(currentPlayer.get(i - 1)) == this.getRankOnCard(currentPlayer.get(i))) {
                count += 1;
                if (count == 4) {
                    return this.getRankOnCard(currentPlayer.get(i));
                }
            } else {
                count = 0;
            }
        }
        return "no books yet";
    }

    public void createABook(ArrayList<String> currentPlayer, int currentPlayerBook) {
        String rankToRemove = checkFullBookInHand(currentPlayer);
        for(int i = 0; i < currentPlayer.size(); i++) {
            if (getRankOnCard(currentPlayer.get(i)).equals(rankToRemove)) {
                currentPlayer.remove(i);
            }
        }
        currentPlayerBook += 1;
    }

    public boolean checkGameOver() {
        if (this.bookCountDealer + this.bookCountPlayer == 13) {
            return true;
        }
        return false;
    }

    public String checkWinner() {
            if (this.bookCountDealer > this.bookCountPlayer) {
                return "dealer";
            } else {
                return "player";
            }
    }

}












