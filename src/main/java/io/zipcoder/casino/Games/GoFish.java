package io.zipcoder.casino.Games;

import io.zipcoder.casino.Players.BlackJackPlayer;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Models.Card;
import io.zipcoder.casino.Models.Hand;

public class GoFish extends CardGame implements Game {

    private GoFishPlayer player;
    private GoFishPlayer opponent;
    private Integer numberOfPairsPlayer;
    private Integer numberOfPairsOpponent;

    public void updateDisplay(){

    }

    public void setUp(){

    }

    public void takeTurn(){

    }

    public void quitGame(){

    }

    public void winning(){

    }

    public void losing(){

    }

    public Hand getPlayerHand(BlackJackPlayer player){
        return null;
    }

    public Card askOtherPlayerforCard(){
        return null;
    }

    public void goFish(){

    }

    public GoFishPlayer breakTie(){
        return null;
    }

    public void incrementNumberOfPairs(GoFishPlayer playerToIncrement){

    }

    public Card deal(){
        return null;
    }
}
