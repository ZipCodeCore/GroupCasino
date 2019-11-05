package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Player.Player;

import java.util.ArrayList;
import java.util.Stack;

public class GoFish {

    Player user = new Player();
    Deck goFishDeck = new Deck(1);

    Integer pointAccumulated;
    Integer hasCardQuestion;


    public void startGame(){

    }

    public boolean askForCard(Player thisPlayer, int cardNumber){return false;}

    public void tradeCards(ArrayList fromPlayer, ArrayList toPlayer){}

    public void dropCards (Player playerToDrop){

    }

    public void promptLeaveGame(){}

    public void displayResults (){}
}
