package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Stack;

public class GoFish {

    private  int points;
    private Player user;
    Console input = new Console(System.in, System.out);

    //Player user = new Player();
    Deck goFishDeck;
    CardHand playerHand;
    CardHand computerHand;
    boolean winGame = false;
    Integer pointAccumulated;
    Integer hasCardQuestion;

    public GoFish(Player player) {
        this.user = player;
        this.points = 0;
    }

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
