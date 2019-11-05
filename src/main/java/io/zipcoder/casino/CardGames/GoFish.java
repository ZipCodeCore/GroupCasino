package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Player.Player;

import java.util.ArrayList;
import java.util.Stack;

public class GoFish {

    Player user = new Player("1234", "password");
    Deck goFishDeck = new Deck(1);

    Integer pointAccumulated;
    Integer hasCardQuestion;


    public void startGame(){

        goFishDeck.shuffleDeck();

        System.out.println(goFishDeck.drawCard().toString());
        System.out.println(goFishDeck.drawCard().toString());
        System.out.println(goFishDeck.drawCard().toString());

    }

    public boolean askForCard(Player thisPlayer, int cardNumber){return false;}

    public void tradeCards(ArrayList fromPlayer, ArrayList toPlayer){}

    public void dropCards (Player playerToDrop){

    }

    public void promptLeaveGame(){}

    public void displayResults (){}
}
