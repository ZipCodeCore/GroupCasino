package io.zipcoder.casino.games;

import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.gameTools.Deck;
import io.zipcoder.casino.player.CardGamePlayer;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFish extends Games {

    private CardGamePlayer mainPlayer;
    private Deck deck = new Deck();
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<GoFishPlayer> otherPlayers;

    public GoFish() {}

    public GoFish(GoFishPlayer player) {
        super();
        this.mainPlayer = player;
    }

    public void startTheGame () {
        otherPlayers = createOtherPlayers(2);
        deck.deal(5,mainPlayer);
        for (GoFishPlayer other: otherPlayers
             ) {
            deck.deal(5, other);
        }
    }



    @Override
    void nextTurn() {

    }

    @Override
    void endGame() {

    }

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


    //====================alex
    public Integer inputNumPlayers() {

        String info = "Please Enter Number of players";
        Integer result = scanner.nextInt();
        return result;
    }
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
    public void runAction (String userAction) {
        //based on the action user Start the game/See Rules/ Exit the game

    }



}
