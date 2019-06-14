package io.zipcoder.casino.games;

import io.zipcoder.casino.gameTools.Card;
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
    private CardGamePlayer otherPlayer = new GoFishPlayer();
    private Deck deck = new Deck();


    public GoFish() {}

    public GoFish(GoFishPlayer player, Console console) {
        super();
        this.mainPlayer = player;
        this.console = console;
//        otherPlayer.setName("other player");
    }
    public void runGame () {

        console.println("Hey " + mainPlayer.getName() + "! \nWelcome to GOFISH GAME");


    }

    public void createPlayers () {
//        deck.deal(5, mainPlayer);
//        deck.deal(5, otherPlayer);
//        ArrayList<Card> hand = mainPlayer.getHand();
//        ArrayList<Card> dealerHand = otherPlayer.getHand();
    }


    @Override
    void nextTurn() { }

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
