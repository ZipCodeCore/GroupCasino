package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class GoFish extends CardGame {

    // players hand
    // dealers hand
    // deck

    Console c;
    private InputStream in;
    private PrintStream out;
    GoFishDisplay d;
    int bookCountPlayer;
    int bookCountDealer;
    String rankAskedFor;

    public GoFish() {

        this.in = System.in;
        this.out = System.out;
        this.c = new Console(in, out);

        d = new GoFishDisplay();

        this.bookCountPlayer = 0;
        this.bookCountDealer = 0;
    }


    public void setupGame(int numberOfCards) {
        this.createNewDeck();
        this.shuffleCards();
        this.dealCards(numberOfCards);
    }

    public String getRankToAskFor_Human() {
        d.printWhatRankYouWillAskFor();
        return c.getStringInput(null, null);
    }

    public String getRankToAskFor_Computer(ArrayList<String> computersHand) {
        int pickCard = (int) Math.random() * (computersHand.size() - 1);
        return this.getRankOnCard(computersHand.get(pickCard));
    }

    // Use this to check if rank in requesting player's hand first (can only request a rank already in your hand)
    // And use to check if rank is in other player's hand
    public boolean checkIfRankInPlayersHand(ArrayList<String> playersHand, String rankAskedFor) {
        for (int i = 0; i < playersHand.size(); i++) {
            if (getRankOnCard(playersHand.get(i)) == rankAskedFor) {
                return true;
            }
        }
        return false;
    }

    public void takeCardFromOtherPlayer(ArrayList<String> playerTakingCard, ArrayList<String> playerGivingCard, String rankAskedFor) {
        for (int i = 0; i < playerGivingCard.size(); i++) {
            if (this.getRankOnCard(playerGivingCard.get(i)) == rankAskedFor) {
                playerTakingCard.add(playerGivingCard.get(i));
                playerGivingCard.remove(i);
            }
        }
    }

    public void drawCardFromDeck(ArrayList<String> playerHand) {
        playerHand.add(this.deck.get(0));
        this.deck.remove(0);
    }

    public void checkFullBookInHand(ArrayList<String> currentPlayer) {

    }

    public void checkWinner(int bookCount) {
        bookCount += 1;
    }

}












