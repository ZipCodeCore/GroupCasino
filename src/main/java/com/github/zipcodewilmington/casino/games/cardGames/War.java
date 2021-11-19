package com.github.zipcodewilmington.casino.games.cardGames;


import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Collections;
import java.util.Random;

public class War implements GameInterface {


    private Double balance = 1000.00;
    private Double amountWagered;
    private Double player2Bet;
    private IOConsole consoleAuto = new IOConsole(AnsiColor.AUTO);
    private IOConsole consoleGreen = new IOConsole(AnsiColor.GREEN);
    private IOConsole consoleRed = new IOConsole(AnsiColor.RED);
    private IOConsole consoleBlack = new IOConsole(AnsiColor.BLACK);
    private int numberOfPlayers;
    private String player1Name;
    private String player2Name;
    private int player1Score;
    private int player2Score;
    private Cards player1Card;
    private Cards player2Card;
    createDeck deck = new createDeck();
//    Random randomNumber = new Random();


    public static void main(String[] args) {

        War war = new War();
        war.run();

//        war.howManyPlayers(); // WORX
//        war.enterNames(); // WORX
//        war.shuffle(); //
//        war.determineRoundWinner(); //
//        war.determineGameWinner(); // WORX
////        war.keepPlaying(); //

    }


    // this method states the rules of the game
    public String warRules() {
//        System.out.println("Welcome to the game of War.\n\nEach player will get dealt a " +
//                "card. Whoever has the higher \nvalue card wins that round, and gets awarded " +
//                "one point. In \nthe event of a tie, no points will be rewarded and both " +
//                "\nplayers will play again. The winner is the first player to \nscore ten points.\n");

        return ("Welcome to the game of War.\n\nEach player will get dealt a " +
                "card. Whoever has the higher \nvalue card wins that round, and gets awarded " +
                "one point. In \nthe event of a tie, no points will be rewarded and both " +
                "\nplayers will play again. The winner is the first player to \nscore ten points.\n");

    }

    // this method determines how many players will play
    // if 1 player, then player 2 is "computer".
//    public void howManyPlayers() {
//
////        IOConsole consoleAuto = new IOConsole(AnsiColor.AUTO);
//
//
//        int userInput;
//
//        do {
//            consoleAuto.println("How many players will be playing?");
//            userInput = consoleAuto.getIntegerInput("Please select 1 or 2 players.");
//            numberOfPlayers = userInput;
//            // sets the input to numberOfPlayers
//            // defines how many players there will be to be used in following
//
//            if (numberOfPlayers != 1 && numberOfPlayers != 2) {
//                numberOfPlayers = 0;
//                consoleAuto.println("That's not a valid amount.");
//            }
//        }
//        while (numberOfPlayers == 0);
//
//    }


    // this method takes in and set players names
    public void enterNames() {

        player1Name = consoleAuto.getStringInput("Player, please enter your name:");
        player2Name = "Computer";

//        if (numberOfPlayers == 2) {
//            player1Name = consoleAuto.getStringInput("Player 1, please enter your name:");
//            player2Name = consoleAuto.getStringInput("Player 2, please enter your name:");
//            consoleAuto.println("Player 1 name is saved as: " + player1Name); // todo take out
//            consoleAuto.println("Player 2 name is saved as: " + player2Name); // todo take out
//
//        } else if (numberOfPlayers == 1) {
//            player1Name = consoleAuto.getStringInput("Player 1, please enter your name:");
//            player2Name = "Computer";
//            consoleAuto.println("Player 1 name is saved as: " + player1Name); // todo take out
//            consoleAuto.println("Player 2 name is saved as: " + player2Name); // todo take out
//        }
    }

    // this method creates a new deck and shuffles
    public void shuffle() {
        Collections.shuffle(deck.cardsStack);
    }


    // this method determines winner of each individual round
    public void determineRoundWinner() {

        consoleAuto.println(player1Name + ", your current balance is " + balance);
        amountWagered = consoleAuto.getDoubleInput(player1Name + ", please enter your wager amount.");
        while (true) {
            if (amountWagered > balance) {
                amountWagered = consoleAuto.getDoubleInput("You do not have enough money for that wager. Please place wager again.");
            }
            else if (amountWagered < 0) {
                amountWagered = consoleAuto.getDoubleInput("Sorry, but that is not a valid amount to wager. Please enter a wager more than zero.");
            }
            else if (amountWagered == 0) {
                amountWagered = consoleAuto.getDoubleInput("C'mon, that's no fun. Please enter a valid wager amount.");
            }
            else if (amountWagered <= balance) {
                break;
            }
        }



        consoleAuto.println("Let's flip over our cards.");
        Cards player1Card = deck.cardsStack.pop();
        Cards player2Card = deck.cardsStack.pop();

        consoleAuto.println("\n" + player1Name + " draws a " + player1Card); // print player1card
        consoleAuto.println(player2Name + " draws a " + player2Card); // print player2card

        Rank player1CardRank = player1Card.getRank();
        Rank player2CardRank = player2Card.getRank();

//        System.out.println(player1CardRank); // print player1card rank
//        System.out.println(player2CardRank); // print player2card rank


        if (player1CardRank.compareTo(player2CardRank) > 0) {
            consoleAuto.println("\n" + player1Name + " has won this round.");
            player1Score++;
            balance = balance + amountWagered;
            consoleAuto.println("\n" + player1Name + " now has a balance of " + balance);
            consoleAuto.println("\n" + player1Name + " now has won " + player1Score + " rounds.\n");

        } else if (player1CardRank.compareTo(player2CardRank) < 0) {
            // if 2 is higher than 1, 2 wins, and one point added to score for player 2
            consoleAuto.println("\n" + player2Name + " has won this round.");
            player2Score++;
            balance = balance - amountWagered;
            consoleAuto.println("\n" + player1Name + " now has a balance of " + balance);
            consoleAuto.println("\n" + player2Name + " now has won " + player2Score + " rounds.\n");

        } else if (player1CardRank.compareTo(player2CardRank) == 0) {
            // this is a tie. neither players gets a point
            consoleAuto.println("\nIt was a tie.\n");
            player1Card = deck.cardsStack.pop();
            player2Card = deck.cardsStack.pop();
        }


    }

    // this method declares a winner for whoever reached 10 points first
    public void determineGameWinner() {
        if (player1Score >= 10) {
            consoleAuto.println("\n" + player1Name + " has won the game!\n");
            player1Score = 0;
            player2Score = 0;
        } else if (player2Score >= 10) {
            consoleAuto.println("\n" + player2Name + " has won the game!\n");
            player2Score = 0;
            player1Score = 0;
        }
    }

//    public void keepPlaying() {
//        consoleAuto.println("Would you like to play again?");
//        String answer = consoleAuto.getStringInput("Please type in YES or NO.");
//
//        if (answer.equalsIgnoreCase("YES")) {
//            System.out.println(" ");
//            runGame();
//        } else if (answer.equalsIgnoreCase("NO")) {
//            System.out.println(" ");
//            // todo quit game return to main menu
//        } else {
//            do {
//                consoleAuto.println("Would you like to play again?");
//                answer = consoleAuto.getStringInput("Please type in YES or NO.");
//            }
//            while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
//        }
////        return;
//    }


    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        // where you have game running
        WarPlayer warPlayer = new WarPlayer();
        balance = warPlayer.getArcadeAccount().getBalance();

        War war = new War();

        System.out.println(war.warRules());
//        war.howManyPlayers();
        war.enterNames();


        do {
            war.shuffle();
            war.determineRoundWinner();
            war.determineGameWinner();
            String keepPlaying = "";
            keepPlaying = consoleAuto.getStringInput("Would you like to play again? Please press any key to continue, or type [no] to quit.");
            if (keepPlaying.equalsIgnoreCase("no")) {
                break;
            }
        } while (true);

    }
} // class War closing bracket