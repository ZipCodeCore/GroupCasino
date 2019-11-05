package io.zipcoder.casino.Games;

import io.zipcoder.casino.GamePieces.Card;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.GamePieces.Deck;
import io.zipcoder.casino.utilities.Console;




public class BlackJack implements Game, GamblingGame{

    Deck deck = new Deck();
    Console console = new Console(System.in, System.out);
    Card[] playerHand = new Card[6];
    Card[] dealerHand = new Card[6];
    private Player currentPlayer;
    Player dealer = new Player( "Dealer", 100000);
    private boolean currentGame = true;
    boolean running = true;
    Integer pot = 0;


    @Override
    public void runGame(Player currentplayer) {
        while(running){

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
        checkHand(playerHand);
        checkHand(dealerHand);
        dealerMove();
        exitGame(currentPlayer);
        }

    }

    @Override
    public void approachTable(Player currentPLayer) {
        this.currentPlayer = currentPLayer;
        console.println("You approach the BlackJack table. What would you like to do?");
        console.println("(1) - Play the game");
        console.println("(2) - Read the rules");
        console.println("(3) - Return to the game menu");
        Integer playerInput = console.getIntegerInput(":");
        while(running) {
            switch (playerInput) {
                case 1:
                    runGame(currentPlayer);
                    running = false;
                    break;
                case 2:

                    approachTable(currentPlayer);
                    running = false;
                    break;
                case 3:
                    running = false;
                    break;
            }
        }

    }



    @Override
    public void placeBet(Player currentPlayer) {
        Integer playerBet = console.getIntegerInput(":");
        currentPlayer.placeBet(playerBet);
        pot += playerBet;

    }

    @Override
    public void returnWinnings(Player currentPlayer) {

    }
    public void viewCurrentHand(){
        console.println("Your hand is " + String.valueOf(playerHand[0].getCardValue().getValue()) + " " + String.valueOf(playerHand[1].getCardValue().getValue()));
    }
    public void viewDealerHand(){
        console.println("Dealer hand is " + String.valueOf(dealerHand[0].getCardValue().getValue()));
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
        }else if(playerHand[2] != null && playerHand[3] == null){
            playerHand[3] = deck.draw();
        }else if (playerHand[3] != null && playerHand[4] == null){
            playerHand[4] = deck.draw();
        }else if (playerHand[4] != null){
            specialFive();
        }

    }
    public Boolean notBusted(Integer handValue){
        if(handValue > 21){
            isLoser();
        }
            return true;


    }
    public void stay(){
        console.println("You chose to stay");
        viewCurrentHand();

    }
    public Boolean isWinner(){
    return null;
    }
    public Boolean isLoser(){
return null;
    }
    public Integer checkHand(Card[] hand){
        int handValue = 0;
        for (Integer i = 0; i < hand.length; i++){
            if(hand[i] != null){
            Card currentCard = hand[i];
            handValue += currentCard.getCardValue().getValue();
            }
        }
        if(notBusted(handValue)){

        }

        return handValue;

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
        console.println("Would you like to play again?");
        console.println("(1) - Yes");
        console.println("(2) - No");
        Integer playerInput = console.getIntegerInput(":");
        switch (playerInput){
            case 1:
                runGame(currentPlayer);
                break;
            case 2:
                running = false;
                break;

    }
    }
    public void dealerMove(){
        Integer value = checkHand(dealerHand);
        Integer counter = 2;
        while (value <= 15 && dealerHand[4] !=null){
            dealerHand[counter] = deck.draw();
            counter++;

        }

        if(value == 16 || value == 17){
            //dealer cheat method
        }else if (value > 18 && value < 21){
            console.println("Dealer Chose to stay");

        }else {
            console.println("Dealer Bust...");
            isWinner();
        }

        if(checkHand(playerHand) > checkHand(dealerHand)){
            viewCurrentHand();
            viewDealerHand();
            console.println("Congratulations you Won!");

            isWinner();
        }else {
            viewCurrentHand();
            viewDealerHand();
            console.println("Congratulations you Lost!");

            isLoser();
        }
    }

}

