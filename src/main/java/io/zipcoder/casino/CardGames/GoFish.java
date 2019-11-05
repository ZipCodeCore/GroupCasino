package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Stack;
import static java.lang.System.in;

public class GoFish implements Game {

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

        initializeHands();

        do{



        }while(winGame == false);

        /*System.out.println("Player 1: " + playerHand.displayHand());
        System.out.println("Player 2: " + computerHand.displayHand());*/

    }

    public void initializeHands(){

        //initialize deck and shuffle
        goFishDeck = new Deck(1);
        goFishDeck.shuffleDeck();

        //initialize players' hand and deal cards
        playerHand = new CardHand(goFishDeck.dealCards(5));
        computerHand = new CardHand(goFishDeck.dealCards(5));


    }

    public void playerTurn(){}

    public void computerTurn(){}

    public boolean askForCard(Player thisPlayer, String card){



        return false;
    }

    public void tradeCards(ArrayList fromPlayer, ArrayList toPlayer){


    }

    public void displayCards(CardHand currentPlayer){
    }

    public void dropCards (Player playerToDrop){

    }

    public void promptLeaveGame(){

    }

    public void displayResults (){
    }
}
