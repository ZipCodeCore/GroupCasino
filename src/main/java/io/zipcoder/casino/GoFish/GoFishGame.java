package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardGame;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class GoFishGame extends CardGame implements Game {

    private String name = "Go Fish";
    private GoFishPlayer player;
    private GoFishNPC opponent;
    ArrayList <Card> playerSuites;
    ArrayList <Card> npcSuites;

    public String getName() {
        return name;
    }

    public GoFishGame(Player player) {
        this.player = new GoFishPlayer(player);
    }

    public void startPlay(){

    }

    public void roundOfPlay(){

    }

    public void endChoice(){

    }

    public ArrayList<GoFishRound> initialDeal;

    public Player checkForWin(){
        return null;
    }


    public void display(){

    }
}
