package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Card;

import java.util.ArrayList;

public class GoFishRound {

    private ArrayList<Card> newSuites;
    private GoFishPlayer player;
    private GoFishPlayer opponent;

    public GoFishRound(GoFishPlayer player, GoFishPlayer opponent) {
        this.player = player;
        this.opponent = opponent;


    }
    public ArrayList<Card> playRound(){
        return null;
    }

    public String chooseCard(){
        return "";
    }

    public Card retrieveCard (String requestedCard){
        return null;
    }
    public Card drawCard(){
        return null;
    }


    public Card scanForSuites(){
        return null;
    }
    public void createSuite(){

    }




}
