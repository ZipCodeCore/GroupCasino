package io.zipcoder.casino.Games;

import io.zipcoder.casino.GamePieces.Card;

import io.zipcoder.casino.Player;
//import io.zipcoder.casino.GamePieces.Deck;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Console;



public class BlackJack implements Game, GamblingGame{

    Deck deck = new Deck();
    Console console = new Console(System.in, System.out);
    Card[] playerHand = new Card[6];
    Card[] dealerHand = new Card[6];
    Player dealer = new Player( "Dealer", 100000);

    boolean running;
    Integer pot = 0;


    @Override
    public void runGame(Player currentPlayer) {
        while(running)
        console.println("Welcome to BlackJack! Let's begin!");
        deck.shuffle();
        initialHand();
        viewDealerHand();
        viewCurrentHand();
        console.println("How much would you like to los- I mean bet?");
        placeBet(currentPlayer);
        console.println("Would you like to 'hit' or 'stay'?");
        viewDealerHand();
        viewCurrentHand();
        hitOrStay();


    }

    @Override
    public void approachTable(Player currentPLayer) {

    }



    @Override
    public void placeBet(Player currentPlayer) {
        Integer playerBet = console.getIntegerInput(":");
        currentPlayer.changBalance(-playerBet);
        pot += playerBet;

    }

    @Override
    public void returnWinnings(Player currentPlayer) {

    }
    public void viewCurrentHand(){
        console.println("Your hand is " + String.valueOf(playerHand[0]) + " " + String.valueOf(playerHand[1]));
    }
    public void viewDealerHand(){
        console.println("Dealer hand is " + String.valueOf(dealerHand[0]));
    }
    public void hitOrStay(){
        String playerInput = console.getStringInput(":");
        if (playerInput.equals("hit")){
            hit();
        }else if(playerInput.equals("stay")){
            stay();
        }else{
            console.println("Not a choice");
        }
    }
    public void hit(){
        if(playerHand[2] == null){
            playerHand[2] = deck.draw();
        }else if(playerHand[2] != null){
            playerHand[3] = deck.draw();
        }else if (playerHand[3] != null){
            playerHand[4] = deck.draw();
        }else if (playerHand[4] != null){
            specialFive();
        }

    }
    public void stay(){

    }
    public Boolean isWinner(){
    return null;
    }
    public Boolean isLoser(){
return null;
    }
    public Integer checkPlayerHand(){
        int handValue = 0;
        for (Integer i = 0; i < playerHand.length; i++){
            Card currentCard = playerHand[i];
            handValue += currentCard.getCardValue().getValue();
        }
        return null;
    }
    public void initialHand(){
        dealerHand[0]= deck.draw();
        dealerHand[1]= deck.draw();

        playerHand[0]= deck.draw();
        playerHand[1]= deck.draw();

    }
    public void specialFive(){
        isWinner();
    }

    @Override
    public void exitGame(Player currentPlayer) {

    }

}



