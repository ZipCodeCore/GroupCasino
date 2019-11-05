package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Player.Player;

import java.util.ArrayList;
import java.util.Stack;

public class GoFish {

    //Player user = new Player();
    Deck goFishDeck = new Deck(1);
    CardHand playerHand1 = new CardHand();
   // CardHand playerHand2 = new CardHand();

    Integer pointAccumulated;
    Integer hasCardQuestion;


    public void startGame(){

        goFishDeck.shuffleDeck();


    }
    public void dealCards(){

        Card newCard = goFishDeck.drawCard();

        playerHand1.addCardToHand(newCard);

    }

    public boolean askForCard(Player thisPlayer, int cardNumber){return false;}

    public void tradeCards(ArrayList fromPlayer, ArrayList toPlayer){}

    public void displayCards(){
        playerHand1.displayHand();
    }

    public void dropCards (Player playerToDrop){

    }

    public void promptLeaveGame(){

    }

    public void displayResults (){}
}
