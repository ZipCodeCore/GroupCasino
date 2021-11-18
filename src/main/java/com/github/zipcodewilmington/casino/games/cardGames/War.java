package com.github.zipcodewilmington.casino.games.cardGames;

import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Collections;
import java.util.Random;

public class War {

    private static IOConsole consoleAuto = new IOConsole(AnsiColor.AUTO);
    private static int numberOfPlayers;
    private static String player1Name;
    private static String player2Name;
    private static int player1Score;
    private static int player2Score;
    private static boolean player1Card;
    private static boolean player2Card;
//    int tokens = 100;
//    int amountWagered;
    Random randomNumber = new Random();
    IOConsole consoleGreen = new IOConsole(AnsiColor.GREEN);
    IOConsole consoleRed = new IOConsole(AnsiColor.RED);
    IOConsole consoleBlack = new IOConsole(AnsiColor.BLACK);

    public static void main(String[] args) {

        warRules();
        howManyPlayers(); // tested and works
        enterNames(); // tested and works
//        callDeck();
//        determineRoundWinner();
        determineGameWinner(); // tested and works
    }

    // this method states the rules of the game
    // todo not returning any text? why?
    public static void warRules() {
        System.out.println("Welcome to the game of War.\n\nEach player will get dealt a " +
                "card. Whoever has the higher \nvalue card wins that round, and gets awarded " +
                "one point. In \nthe event of a tie, no points will be rewarded and both " +
                "\nplayers will play again. The winner is the first player to \nscore ten points.\n");

        return;

    }

    // this method determines how many players will play
    // keeping this in?
    // if 1 player, then player 2 is "computer".
    // need to change enterNames() method
    public static int howManyPlayers() {

        IOConsole consoleAuto = new IOConsole(AnsiColor.AUTO);


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

        return numberOfPlayers;
    }


    // this method takes in and set players names
    public static void enterNames() {

        if (numberOfPlayers == 2) {
        player1Name = consoleAuto.getStringInput("Player 1, please enter your name:");
        player2Name = consoleAuto.getStringInput("Player 2, please enter your name:");
            consoleAuto.println("Player 1 name is saved as: " + player1Name); // todo take out
            consoleAuto.println(" Player 2 name is saved as: " +player2Name); // todo take out

    } else if (numberOfPlayers == 1) {
            player1Name = consoleAuto.getStringInput("Player 1, please enter your name:");
            player2Name = "Computer";
            consoleAuto.println("Player 1 name is saved as: " + player1Name); // todo take out
            consoleAuto.println("Player 2 name is saved as: " + player2Name); // todo take out
        }
        }

    // this method creates a new deck and shuffles
    // todo still need to figure out how to print the actual card, not memory
    public static void callDeck() {
        createDeck deck = new createDeck();
        Collections.shuffle(deck.cardsStack);
        for (Cards card : deck.cardsStack) {
            System.out.println(card.toString());
        }
    }

    // this method determines winner of each individual round
    // todo need to figure out deck issues, then figure out how to rank them
//    public static void determineRoundWinner () {
//
//        if (player1Card > player2Card) {
//                consoleAuto.println("\nPlayer 1 has won this round.\n");
//                player1Score++;
//                consoleAuto.println("Player 1 now has " + player1Score + " points.");
//            } else if (player2Card > player1Card) {
//                // if 2 is higher than 1, 2 wins, and one point added to score for player 2
//                consoleAuto.println("\nPlayer 2 has won this round.\n");
//                player2Score++;
//                consoleAuto.println("Player 2 now has " + player2Score + " points.");
//            } else if (player1Card == player2Card) {
//                // this is a tie. neither players gets a point
//                consoleAuto.println("\nIt was a tie. Let's deal again.\n");
//            }
//    }

    // this method declares a winner for whoever reached 10 points first
    public static void determineGameWinner() {
        if (player1Score >= 10) {
            consoleAuto.println("\nPlayer 1 has won the game!\n");
        } else if (player2Score >= 10) {
            consoleAuto.println("\nPlayer 2 has won the game!\n");
        }
    }



} // class War closing bracket



