package io.zipcoder.casino.Games.Blackjack;

import io.zipcoder.casino.utilities.CasinoArt;
import io.zipcoder.casino.GamePieces.Card;




import io.zipcoder.casino.Games.GamblingGame;
import io.zipcoder.casino.Games.Game;

import io.zipcoder.casino.Menus.Casino;


import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.GamePieces.Deck;
import io.zipcoder.casino.utilities.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BlackJack implements Game, GamblingGame {


    Deck deck = null;
    Console console = new Console(System.in, System.out);
    Card[] playerHand = new Card[6];
    Card[] dealerHand = new Card[6];
    private Player currentPlayer;
    Player dealer = new Player("Dealer", 100000);
    private CasinoArt art = new CasinoArt();
    boolean running = true;
    boolean alsoRunning = true;
    Integer pot = 0;
    Integer handOfPlayer = checkHand(playerHand);
    Integer handOfDealer = checkHand(dealerHand);
    private DateTimeFormatter dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public Player getWinner() {
        return winner;
    }

    private Player winner = null;
    private Integer totalEarnings = 0;


    public void runBlackJack(Player currentPlayer) {
        alsoRunning = true;
        running = true;
        this.currentPlayer = currentPlayer;
        approachTable(currentPlayer);
    }


    @Override
    public void runGame(Player currentplayer) {


        while (running == true) {
            deck = new Deck();
            winner = null;

            console.println("Welcome to BlackJack! Let's begin!");

            deck.shuffle();
            initialHand();

            viewDealerHand();
            viewCurrentHand();

            console.println("How much would you like to los- I mean bet?" + " Current balance: $" + currentplayer.getBalance());
            placeBet(currentPlayer);
        if (running == true){
            houseWin();


            if (winner == null) {

                viewDealerHand();
                viewCurrentHand();

                hitOrStay();

                checkHand(playerHand);
                checkHand(dealerHand);
                dealerMove();
                checksWinner();

                exitGame(currentPlayer);
            } else {
                exitGame(currentPlayer);
            }
        }
        }
    }




    @Override
    public void approachTable(Player currentPLayer) {
        while (alsoRunning == true) {
            Console.clearScreen();
            this.currentPlayer = currentPLayer;
            console.println(art.getCasinoArt(CasinoArt.Art.BLACKJACK));
            console.println("You approach the BlackJack table. What would you like to do?");
            console.println("(1) - Play the game");
            console.println("(2) - Read the rules");
            console.println("(3) - Return to the game menu");
            Integer playerInput = console.getIntegerInput(":");

            switch (playerInput) {
                case 1:
                    running = true;
                    runGame(currentPlayer);

                    break;
                case 2:

                    approachTable(currentPlayer);

                    break;
                case 3:

                    alsoRunning = false;

                    break;
            }
        }
    }


    @Override
    public void placeBet(Player currentPlayer) {
        Integer playerBet = console.getIntegerInput(":");
        if (currentPlayer.getBalance() <= 0) {
            console.printSlow("Git yo broke ass ouuta heeerrre Bruhh!  !  !  !");
            console.delay(3500);
            alsoRunning = false;
            running = false;
        } else if (currentPlayer.getBalance() < playerBet) {
            console.printSlow(" Not enough cheddar! Bet a different amount");
            console.delay(3500);
            placeBet(currentPlayer);
        } else {
            currentPlayer.placeBet(playerBet);
            pot = playerBet;

        }
    }

    @Override
    public void returnWinnings(Player currentPlayer, Integer results) {

    }

    public int blackJackCardValue(Card c) {
        int card = c.getCardValue().getValue();
        if(card > 10 && card < 14) {
            card = 10;
        } else if(card == 14) {
            card = 11;
        }
        return card;
    }

    public void viewCurrentHand() {
        console.println("Your hand is " + String.valueOf(blackJackCardValue(playerHand[0])) + " " + String.valueOf(blackJackCardValue(playerHand[1])));
    }

    public void viewDealerHand() {

        console.println("Dealer hand is " + String.valueOf(blackJackCardValue(dealerHand[0])));
    }

    public void hitOrStay() {

        handOfPlayer = checkHand(playerHand);
        console.println("Would you like to 'hit' or 'stay'?");
        String playerInput = console.getStringInput(":");


        if (!notBusted(checkHand(playerHand))) {


        } else if (playerInput.equals("hit")) {
            handOfPlayer = checkHand(playerHand);
            if (!notBusted(checkHand(playerHand))) {

            }

            hit();


        } else if (playerInput.equals("stay")) {

            stay();

        } else {
            console.println("Not a choice");
            hitOrStay();
        }

    }

    public void hit() {


        if (playerHand[2] == null) {
            playerHand[2] = deck.draw();
            handOfPlayer = checkHand(playerHand);
            console.println("This is your hand " + handOfPlayer);
            if (notBusted(checkHand(playerHand))) {
                hitOrStay();

                if (playerHand[2] == null) {
                    playerHand[2] = deck.draw();
                    handOfPlayer = checkHand(playerHand);

                   if (notBusted(checkHand(playerHand))) {
                        console.println("This is your hand " + handOfPlayer);
                       hitOrStay();

            } else if(playerHand[2] != null && playerHand[3] == null){
                handOfPlayer = checkHand(playerHand);
                playerHand[3] = deck.draw();
                handOfPlayer = checkHand(playerHand);
                if(notBusted(checkHand(playerHand))){
                console.println("This is your hand " + handOfPlayer);
                hitOrStay();
                }
            }else if (playerHand[3] != null && playerHand[4] == null){
                handOfPlayer = checkHand(playerHand);
                console.println("This is your hand " + handOfPlayer);
                playerHand[4] = deck.draw();
                handOfPlayer = checkHand(playerHand);
                hitOrStay();
            }else if (playerHand[4] != null && checkHand(playerHand) < 21){
                specialFive();
            }


                    }



                }
            }
        }

        public Boolean notBusted(Integer handValue){
            if (handValue > 21) {
                return false;
            }
            return true;


        }
        public void stay() {
            console.println("You chose to stay");
            viewCurrentHand();


        }
        public void isWinner(Player currentPlayer){
            winner = currentPlayer;
            Integer winnings = pot * 2;
            currentPlayer.changeBalance(winnings);
            console.println("You won $" + winnings);

        }
        public void isLoser() {
            console.println("You lost $" + pot);
            winner = dealer;

        }

        public Integer checkHand(Card[]hand){
            int handValue = 0;
            for (Integer i = 0; i < hand.length; i++) {
                if (hand[i] != null) {
                    handValue += blackJackCardValue(hand[i]);
                }
            }
            if (notBusted(handValue)) {

            }

            return handValue;

        }
        public void initialHand() {
            dealerHand[0] = deck.draw();
            dealerHand[1] = deck.draw();
            playerHand[0] = deck.draw();
            playerHand[1] = deck.draw();

            for (int i = 2; i < dealerHand.length - 1; i++) {
                dealerHand[i] = null;
            }
            for (int i = 2; i < playerHand.length - 1; i++) {
                playerHand[i] = null;
            }

        }
        public void specialFive() {
            isWinner(currentPlayer);
        }

        @Override
        public void exitGame (Player currentPlayer){
            if (winner.equals(currentPlayer)) {
                LocalDateTime now = LocalDateTime.now();
                currentPlayer.addHistory("You won at BLACKJACK. ** " + dateTimeFormatter.format(now) + "!");
            } else if (winner.equals(dealer)) {
                LocalDateTime now = LocalDateTime.now();
                currentPlayer.addHistory("You lost at BLACKJACK. ** " + dateTimeFormatter.format(now));
            }

            console.println("Would you like to play again?");
            console.println("(1) - Yes");
            console.println("(2) - No");


            Integer playerInput = console.getIntegerInput(":");
            switch (playerInput) {
                case 1:
                    // Card[] playerHand = playerHand[6];
                    runGame(currentPlayer);

                    break;
                case 2:
                    //approachTable(currentPlayer);

                    running = false;

                    break;

            }
        }

        public void dealerMove() {
            Integer value = checkHand(dealerHand);
            Integer counter = 2;


            if (value == 16 || value == 17) {
                //dealer cheat method
            } else if (value >= 18 && value <= 21 && dealerHand[5] != null) {
                console.println("Dealer Chose to stay");

            } else if (value <= 21 && dealerHand[5] != null) {
                console.println("Unlucky... \nThe Dealer wins with Special Five");
                isLoser();


            } else if (value <= 15) {
                dealerHand[counter] = deck.draw();
                counter++;

            } else if (value > 21) {
                console.println("Dealer Bust...");



            }
        }




    private Boolean checkForBlackjack(Card[] hand) {
        if (checkHand(hand) == 21) {
            return true;
        } else {
            return false;
        }

    }

    private void houseWin() {
            checkHand(dealerHand);
            checkHand(playerHand);

            if (checkForBlackjack(dealerHand) && checkForBlackjack(playerHand)) {
                Integer handOfPlayer = checkHand(playerHand);
                Integer handOfDealer = checkHand(dealerHand);
                console.println("Your Hand was " + handOfPlayer);
                console.println("Dealers Hand was " + handOfDealer);
                console.println("The house wins!");

                isLoser();

            } else if (checkForBlackjack(playerHand)) {
                handOfPlayer = checkHand(playerHand);
                handOfDealer = checkHand(dealerHand);
                console.println("Your Hand was " + handOfPlayer);
                console.println("Dealers Hand was " + handOfDealer);
                console.println("Congratulations you got BLACKJACK!");

                isWinner(currentPlayer);

            } else if (checkForBlackjack(dealerHand)) {
                Integer handOfPlayer = checkHand(playerHand);
                Integer handOfDealer = checkHand(dealerHand);
                console.println("Your Hand was " + handOfPlayer);
                console.println("Dealers Hand was " + handOfDealer);
                console.println("The Dealer wins!");

                isLoser();

            }
        }
        private void checksWinner() {
            Integer handOfPlayer = checkHand(playerHand);
            Integer handOfDealer = checkHand(dealerHand);
            if (checkHand(playerHand) > checkHand(dealerHand) && checkHand(playerHand) <= 21) {

                console.println("Your Hand was " + handOfPlayer);
                console.println("Dealers Hand was " + handOfDealer);
                console.println("Congratulations you Won!");

                isWinner(currentPlayer);
            } else if (checkHand(playerHand) < checkHand(dealerHand) && checkHand(dealerHand) <= 21) {

                console.println("Your Hand was " + handOfPlayer);
                console.println("Dealers Hand was " + handOfDealer);
                console.println("Hope you like ramen noodles....");

                isLoser();
            } else if (checkHand(playerHand) < checkHand(dealerHand) && checkHand(dealerHand) > 21) {

                console.println("Your Hand was " + handOfPlayer);
                console.println("Dealers Hand was " + handOfDealer);
                console.println("Congratulations you Won! Dealer Busted Out!");

                isWinner(currentPlayer);
            } else {

                console.println("Your Hand was " + handOfPlayer);
                console.println("Dealers Hand was " + handOfDealer);
                console.println("Busted Out! Hope you like ramen noodles....");

                isLoser();
            }
        }

    }

