package io.zipcoder.casino.games;

import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.gameTools.CardValue;
import io.zipcoder.casino.gameTools.Deck;
import io.zipcoder.casino.player.CardGamePlayer;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GoFish extends Games {
    Console console;
    private GoFishPlayer mainPlayer;
    private GoFishPlayer otherPlayer = new GoFishPlayer();
    private boolean isPlaying = true;



    private Deck deck = new Deck();


    public GoFish() {}

    public GoFish(GoFishPlayer player, Console console) {
        super();
        this.mainPlayer = player;
        this.console = console;

    }
    public void runGame () {
        console.println("Hey " + mainPlayer.getName() + "! \nWelcome to GOFISH GAME");
        String userInput = console.getStringInput("Do you want to play?");
        if (readyToPlay(userInput)) {
            dealHands();
            console.println(seeHand());
            Double test = 200.00;
            update(test);

            nextTurn();
            turnPlayer();
        }
    }

    public void update(Double ammount) {
        Double result = mainPlayer.getAccount() + ammount;
        mainPlayer.setAccount(result);
        String test = "";

    }

    public void dealHands () {
        deck.deal(5, mainPlayer);
        deck.deal(5, otherPlayer);
    }
    public String seeHand () {
        String hand = "";
        for (Card c: mainPlayer.getHand()
             ) {
            hand += c.getCardValue() + " of "  + c.getSuit() + " ==== ";
        }
        return hand;

    }

    public boolean readyToPlay(String userInput){
        if (userInput.equalsIgnoreCase("yes")) {
            return true;
        }
        else {
            return false;}
    }

    public String turnPlayer() {
        String userInput = console.getStringInput("What are you looking for?");
        return userInput.toUpperCase();
    }

    public void action() {
        String value = turnPlayer();

        //if (otherPlayer.getHand().contains(
    }

    @Override
    void nextTurn() {
    }

    @Override
    void endGame() { }

    @Override
    boolean getResults() {
        return false;
    }

    @Override
    public void display(String output) {
        super.display(output);
    }

    public Card check (Integer query) {
        return null;
    };

    public Card goFishAction () {
        return null;
    };


    public ArrayList<GoFishPlayer> createOtherPlayers (Integer numPlayers) {
        ArrayList<GoFishPlayer> players = new ArrayList<GoFishPlayer>();
        //foreach of inputnUmplayers - create player
        for (int i = 1; i <= numPlayers; i++) {
            GoFishPlayer goFishPlayer = new GoFishPlayer();
            goFishPlayer.setName("Player" + i);
            players.add(goFishPlayer);
        }
        return players;
    }

}
