package io.zipcoder.casino;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GoFishGame extends CardGame implements Game {

    private GoFishPlayer player;
    private GoFishNPC opponent;
    ArrayList<GoFishRound> hands;
    ArrayList <Card> playerSuites;
    ArrayList <Card> npcSuites;

    public GoFishGame(GoFishPlayer player) {
        this.player = player;
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
