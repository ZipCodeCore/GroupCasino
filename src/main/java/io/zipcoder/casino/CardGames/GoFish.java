package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Stack;
import static java.lang.System.in;

public class GoFish implements Game {

    private Player user;

    Console input = new Console(System.in, System.out);

    Deck goFishDeck;
    CardHand playerHand;
    CardHand computerHand;
    boolean winGame = false;

    public GoFish(Player player) {
        this.user = player;

    }

    public void startGame(){

        initializeHands();

        System.out.println("Loading Go Fish....");

        do{

            System.out.println("Player's Turn");
            playerTurn();
            winGame = playerHand.evaluateHand();


            //System.out.println("Computer's Turn");
            //computerTurn();



        }while(winGame == false);

    }

    public void initializeHands(){

        //initialize deck and shuffle
        goFishDeck = new Deck(1);
        goFishDeck.shuffleDeck();

        //initialize players' hand and deal cards
        playerHand = new CardHand(goFishDeck.dealCards(5));
        computerHand = new CardHand(goFishDeck.dealCards(5));


    }

    public void playerTurn(){

        System.out.println(playerHand.displayHand());

        String userInput = input.getStringInput("Which value would you like to ask for? ");
        userInput.toUpperCase();

        if(computerHand.lookForCard(userInput) == true){

            System.out.println("The computer has this card");

            playerHand.tradeCards(computerHand.removeCardsFromHand(userInput));


        }else{
            System.out.println("Go Fish!");

            playerHand.getCardFromDeck(goFishDeck.drawCard());
        }

        System.out.println(playerHand.displayHand());

    }

    public void computerTurn(){



    }


    public void promptLeaveGame(){

    }

    public void displayResults (){
    }
}
