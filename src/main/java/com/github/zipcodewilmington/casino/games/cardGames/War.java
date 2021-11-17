package com.github.zipcodewilmington.casino.games.cardGames;

import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import com.sun.tools.javac.code.Lint;

import java.util.Random;

public class War {
    public static void main(String[] args) {

        howManyPlayers();
//        getPlayerName();
//        deckOfCards();
    }

    // todo these variables and methods are all outside of psv main but inside class War

    //        Deck deck; //we need a new deck of cards
    int tokens = 100;
    int amountWagered;
    String player1Name = "";
    String player2Name = "";
    int player1Score;
    int player2Score;
    //        Card player1Card;
//        Card player2Card;
    Random randomNumber = new Random();
    IOConsole consoleAuto = new IOConsole(AnsiColor.AUTO);
    IOConsole consoleGreen = new IOConsole(AnsiColor.GREEN);
    IOConsole consoleRed = new IOConsole(AnsiColor.RED);
    IOConsole consoleBlack = new IOConsole(AnsiColor.BLACK);


    public static int howManyPlayers() {

        IOConsole consoleAuto = new IOConsole(AnsiColor.AUTO);

        int numberOfPlayers = 0;
        int userInput;

        do {
            consoleAuto.println("How many players will be playing?");
            userInput = consoleAuto.getIntegerInput("Please select 1 or 2 players.");
            numberOfPlayers = userInput;
            // sets the input to numberOfPlayers
            // defines how many players there will be to be used in following

            if (numberOfPlayers != 1 && numberOfPlayers != 2) {
                numberOfPlayers = 0;
                consoleAuto.println("That's not a valid amount.");
            }
        }
        while (numberOfPlayers == 0);

return 0;

    }

//
//    public static void getPlayerName() {
//
//        IOConsole consoleAuto = new IOConsole(AnsiColor.AUTO);
//
//        String player1Name = ""; // empty name String
//        String player2Name = ""; // empty name String
//
//
//        do {  // sets the input to name.
//            player1Name = consoleAuto.getStringInput("What is your name, player 1?");
//        }
//        while (player1Name.length() <= 12); // checks if user entered anything or not
//    }
//
//        do
//
//    {  // sets the input to name.
//            player2Name = consoleAuto.getStringInput("What is your name, player 2?");
//    }
//        while (player2Name.length() <= 12); // checks if user entered anything or not
//}


//    public static void runGame() {
////            IOConsole consoleAuto = new IOConsole(AnsiColor.AUTO);
//        int numberOfPlayers = howManyPlayers();
//        Card player1Card;
//        Card player2Card;
//
//
//        // create new deck
//        // shuffle deck
//        consoleAuto.println("Welcome to the game of War.\n\nEach player will get dealt a " +
//                "card. Whoever has the higher value card wins that round, and gets awarded " +
//                "one point. The winner is the first player to score ten points.");
//
//        // perform this gameplay loop while neither player has yet scored ten points.
//        while (player1Score < 10 && player2Score < 10) {
//            // introduction to game and rules
//            consoleAuto.println("\nLet's get started.");
//            // create new deck method
//            // shuffle deck method
//
//            // players get assigned cards
//            player1Card = deck.getNextCard(); // player1 gets next card
//            player2Card = deck.getNextCard(); // player2 gets next card
//
//            // displaying results
//            consoleAuto.println("Let's see the results.");
//            consoleRed.println("Player 1: " + player1Card);
//            consoleGreen.println("Player 2: " + player2Card);
//
//            // if 1 is higher than 2, 1 wins, and add 1 to player1 score
//            if (player1Score > player2Score) {
//                consoleAuto.println("\nPlayer 1 has won this round.\n");
//                player1Score++;
//                consoleAuto.println("Player 1 now has " + player1Score + " points.");
//            } else if (player2Score > player1Score) {
//                // if 2 is higher than 1, 2 wins, and one point added to score for player 2
//                consoleAuto.println("\nPlayer 2 has won this round.\n");
//                player2Score++;
//                consoleAuto.println("Player 2 now has " + player2Score + " points.");
//            } else if (player1Score == player2Score) {
//                // this is a tie. neither players gets a point
//                consoleAuto.println("\nIt was a tie. Let's deal again\n");
//            }
//
//        if (player1score >= 10 || player2score < 10) {
//            consoleAuto.println("Congratulations to Player 1! You have won by a score of " + player1Score + )
//        }
//        }


//
//        // run howManyPlayers() to set number of players
//        howManyPlayers();
//        // players each get dealt a card
//
//
//        // compare cards
//
//
//        // determine who has higher value card
//        // winner will be awarded one point
//        // todo what about a tie?
//        // maybe deal and go again. no points awarded
//
//        // deal next cards
//        // repeat process of comparing cards and determining winner
// award one point to winner each time
//
//        // continue until one user reaches 10 points
//
//        // higher score is the winner
//        // announce winner
//
//    }


    } // class War closing bracket



