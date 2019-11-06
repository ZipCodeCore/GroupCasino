package io.zipcoder.casino.Games.Blackjack;

import io.zipcoder.casino.CasinoArt;
import io.zipcoder.casino.GamePieces.Card;
import io.zipcoder.casino.Games.GamblingGame;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.GamePieces.Deck;
import io.zipcoder.casino.utilities.Console;

public class BlackJack implements Game, GamblingGame {

    Deck deck = new Deck();
    Console console = new Console(System.in, System.out);
    Card[] playerHand = new Card[6];
    Card[] dealerHand = new Card[6];
    private Player currentPlayer;
    Player dealer = new Player( "Dealer", 100000);
    private boolean currentGame = true;
    private CasinoArt art = new CasinoArt();
    boolean running = true;
    Integer pot = 0;
    Integer handOfPlayer = checkHand(playerHand);
    Integer handOfDealer = checkHand(dealerHand);


    @Override
    public void runGame(Player currentplayer) {
        while(running){

        console.println("Welcome to BlackJack! Let's begin!");
        deck.shuffle();
        initialHand();
        viewDealerHand();
        viewCurrentHand();
        console.println("How much would you like to los- I mean bet?" + " Current balance: $" + currentplayer.getBalance());
        placeBet(currentPlayer);
        houseWin();

        viewDealerHand();
        viewCurrentHand();
        hitOrStay();
        checkHand(playerHand);
        checkHand(dealerHand);
        dealerMove();
        checksWinner();
        exitGame(currentPlayer);
        }

    }
    @Override
    public void approachTable(Player currentPLayer) {
        Console.clearScreen();
        this.currentPlayer = currentPLayer;
        console.println(art.getCasinoArt(CasinoArt.Art.BLACKJACK));
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
        if(!notBusted(checkHand(playerHand))){
            checksWinner();
        }
        console.println("Would you like to 'hit' or 'stay'?");
        String playerInput = console.getStringInput(":");
        if (playerInput.equals("hit")){
            handOfPlayer = checkHand(playerHand);
            if(!notBusted(checkHand(playerHand))){
                checksWinner();
            }

            hit();



        }else if(playerInput.equals("stay")){

            stay();

        }else{
            console.println("Not a choice");
            hitOrStay();
        }

    }
    public void hit(){

            if(playerHand[2] == null){
                playerHand[2] = deck.draw();
                handOfPlayer = checkHand(playerHand);
                console.println("This is your hand " + handOfPlayer);
                hitOrStay();
            }else if(playerHand[2] != null && playerHand[3] == null){
                handOfPlayer = checkHand(playerHand);
                playerHand[3] = deck.draw();
                console.println("This is your hand " + handOfPlayer);
                hitOrStay();
            }else if (playerHand[3] != null && playerHand[4] == null){
                handOfPlayer = checkHand(playerHand);
                console.println("This is your hand " + handOfPlayer);
                playerHand[4] = deck.draw();
                hitOrStay();
            }else if (playerHand[4] != null && checkHand(playerHand) < 21){
                specialFive();
            }


    }
    public Boolean notBusted(Integer handValue){
        if(handValue > 21){
            return false;
        }
            return true;


    }
    public void stay(){
        console.println("You chose to stay");
        viewCurrentHand();

    }
    public void isWinner(Player currentPlayer){
        Integer winnings = pot*2;
    currentPlayer.changeBalance(winnings);
    console.println("You won $"+ winnings);
    }
    public void isLoser(){
        console.println("You lost $" + pot);
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

        for (int i = 2; i < dealerHand.length -1; i++){
        dealerHand[i] = null;
        }
        for (int i = 2; i < playerHand.length -1; i++){
            playerHand[i] = null;
        }

    }
    public void specialFive(){
        isWinner(currentPlayer);
    }

    @Override
    public void exitGame(Player currentPlayer) {

        console.println("Would you like to play again?");
        console.println("(1) - Yes");
        console.println("(2) - No");
        Integer playerInput = console.getIntegerInput(":");
        switch (playerInput){
            case 1:
               // Card[] playerHand = playerHand[6];
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

        while (value < 18) {

            if (value == 16 || value == 17) {
                //dealer cheat method
            } else if (value >= 18 && value <= 21 && dealerHand[5] != null) {
                console.println("Dealer Chose to stay");

            } else if (value <= 21 && dealerHand[5] != null) {
                console.println("Unlucky... \nThe Dealer wins with Special Five");
                isLoser();
                exitGame(currentPlayer);
            } else if (value <= 15) {
                dealerHand[counter] = deck.draw();
                counter++;
            } else if (value > 21) {
                console.println("Dealer Bust...");

            }
        }



    }
    private Boolean checkForBlackjack(Card[] hand){
        if (checkHand(hand) == 21){
            return true;
        }else{
            return false;
        }

    }
private void houseWin(){
        if (checkForBlackjack(dealerHand) && checkForBlackjack(playerHand)){
            Integer handOfPlayer = checkHand(playerHand);
            Integer handOfDealer = checkHand(dealerHand);
            console.println("Your Hand was " + handOfPlayer);
            console.println("Dealers Hand was " + handOfDealer);
            console.println("The house wins!");

            isLoser();
            exitGame(currentPlayer);
        }else if(checkForBlackjack(playerHand)){
            handOfPlayer = checkHand(playerHand);
            handOfDealer = checkHand(dealerHand);
            console.println("Your Hand was " + handOfPlayer);
            console.println("Dealers Hand was " + handOfDealer);
            console.println("Congratulations you got BLACKJACK!");

            isWinner(currentPlayer);
            exitGame(currentPlayer);
        }else if (checkForBlackjack(dealerHand)){
            Integer handOfPlayer = checkHand(playerHand);
            Integer handOfDealer = checkHand(dealerHand);
            console.println("Your Hand was " + handOfPlayer);
            console.println("Dealers Hand was " + handOfDealer);
            console.println("The Dealer wins!");

            isLoser();
            exitGame(currentPlayer);
        }
}
    private void checksWinner() {
        Integer handOfPlayer = checkHand(playerHand);
        Integer handOfDealer = checkHand(dealerHand);
        if(checkHand(playerHand) > checkHand(dealerHand) && checkHand(playerHand) <= 21){

            console.println("Your Hand was " + handOfPlayer);
            console.println("Dealers Hand was " + handOfDealer);
            console.println("Congratulations you Won!");

            isWinner(currentPlayer);
            exitGame(currentPlayer);
        }else if (checkHand(playerHand) < checkHand(dealerHand) && checkHand(dealerHand) <= 21){

            console.println("Your Hand was " + handOfPlayer);
            console.println("Dealers Hand was " + handOfDealer);
            console.println("Hope you like ramen noodles....");

            isLoser();
            exitGame(currentPlayer);
        }else if (checkHand(playerHand) < checkHand(dealerHand) && checkHand(dealerHand) > 21){

            console.println("Your Hand was " + handOfPlayer);
            console.println("Dealers Hand was " + handOfDealer);
            console.println("Congratulations you Won! Dealer Busted Out!");

            isWinner(currentPlayer);
            exitGame(currentPlayer);
        }else {

            console.println("Your Hand was " + handOfPlayer);
            console.println("Dealers Hand was " + handOfDealer);
            console.println("Busted Out! Hope you like ramen noodles....");

            isLoser();
            exitGame(currentPlayer);
        }
    }

}






