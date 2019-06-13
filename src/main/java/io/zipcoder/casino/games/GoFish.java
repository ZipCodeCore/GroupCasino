package io.zipcoder.casino.games;

import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.gameTools.Deck;
import io.zipcoder.casino.player.CardGamePlayer;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;

import java.util.ArrayList;

public class GoFish extends Games {

    private CardGamePlayer goFishPlayer;
    Deck deck = new Deck();

    public GoFish() {}
    public GoFish(GoFishPlayer player) {
        super();
        this.goFishPlayer = player;
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

    public Card goFish () {
        return null;
    };


    //====================alex
    public Integer inputNumPlayers() {
        String info = "Please Enter Number of players";
        return null;
    }
    public ArrayList<Player> createOtherPlayers (Integer numPlayers) {
        //foreach of inputnUmplayers - create player
        return null;
    }



}
