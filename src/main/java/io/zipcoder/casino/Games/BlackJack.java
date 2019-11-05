package io.zipcoder.casino.Games;

import io.zipcoder.casino.GamePieces.Card;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.GamePieces.Deck;
import io.zipcoder.casino.utilities.Console;

public class BlackJack implements Game, GamblingGame{
    Console console = new Console(System.in, System.out);
    Card[] hand = new Card[6];
    Card[] dealerHand = new Card[6];
    Player dealer = new Player( "Dealer", 100000);

    boolean running;
    Integer pot = 0;


    @Override
    public void runGame(Player currentPlayer) {
        while(running)
        console.println("Welcome to BlackJack!");
        //draw two cards for current player and Dealer
        console.println("How much would you like to los- I mean bet?");
        placeBet(currentPlayer);
        console.println("Would you like to 'hit' or 'stay'?");
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
        console.println(String.valueOf(hand[0]) + " " + String.valueOf(hand[1]));
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

    }
    public void stay(){

    }
    public Boolean isWinner(){
    return null;
    }
    public Boolean isLoser(){
return null;
    }

    @Override
    public void exitGame(Player currentPlayer) {

    }

}
