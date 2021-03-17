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
    String rankAskedFor;

    public GoFish() {

        this.in = System.in;
        this.out = System.out;
        this.c = new Console(in, out);
        c = new Console(in, out);

        d = new GoFishDisplay();
    }

    public void beginGame(int numberOfCards) {
        this.createNewDeck();           // Create new standard 52 card deck
        this.shuffleCards();            // Shuffle the deck randomly
        //this.dealCards(numberOfCards);  // Deal numberOfCards to two people
    }

    // Move to display class??
    public String displayPlayersHand(ArrayList<String> playersHand) {
        String playersHandOutput = "";
        Iterator itr = playersHand.iterator();
        while(itr.hasNext()) {
            playersHandOutput += itr.next() + "/n";
        }
        return playersHandOutput;
    }

    public String getRankOnCard(String cardRankAndSuit) {
        return cardRankAndSuit.substring(0, cardRankAndSuit.indexOf(" "));
    }

    public String getRankToAskFor_Human() {
        d.cardYouWillAskFor();
        return c.getStringInput(null, null);
    }

    public String getRankToAskFor_Computer() {
        return null;
    }

    public boolean checkRankRequestedIsAllowed(ArrayList<String> currentPlayersHand, String rankAskedFor) {
        if (playersHand.contains(rankAskedFor)) {
            return true;
        } else {
            d.printNotInYourHand();
            return false;
        }
    }

    public boolean checkIfRankInOtherPlayersHand(ArrayList<String> otherPlayersHand, String rankAskedFor) {
        if (otherPlayersHand.contains(rankAskedFor)) {
            return true;
        } else {
            return false;
        }
    }

    public void takeCardFromOtherPlayer(ArrayList<String> playerTakingCard, ArrayList<String> playerGivingCard, String rankAskedFor) {
        for (int i = 0; i < playerGivingCard.size(); i++) {
            if (this.getRankOnCard(playerGivingCard.get(i)) == rankAskedFor) {
                playerTakingCard.add(playerGivingCard.get(i));
                playerGivingCard.remove(i);
            }
        }
    }

    public void checkForPairsInCurrentPlayersHand(ArrayList<String> currentPlayer) {

    }

}












