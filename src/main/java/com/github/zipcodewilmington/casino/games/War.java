package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import com.sun.tools.javac.code.Lint;

import java.util.Random;

public class War {
    public static void main(String[] args) {

        howManyPlayers();
        getPlayerName();
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


    public static void howManyPlayers() {

        IOConsole consoleAuto = new IOConsole(AnsiColor.AUTO);

        int numberOfPlayers = 0;
        int userInput;

        do {
            consoleAuto.println("How many players will be playing?");
            userInput = consoleAuto.getIntegerInput("Please select 1 or 2 players.");
            numberOfPlayers = userInput; // sets the input to numberOfPlayers

            if (numberOfPlayers != 1 && numberOfPlayers != 2) {
                numberOfPlayers = 0;
                consoleAuto.println("That's not a valid amount.");
            }
        }
        while (numberOfPlayers == 0);
    }


    public static void getPlayerName() {

        IOConsole consoleAuto = new IOConsole(AnsiColor.AUTO);

        String name = ""; // empty name String


        do {  // sets the input to name.
            name = consoleAuto.getStringInput("What's your name?");
        }
        while (name.length() == 0); // checks if user entered anything or not
    }


//    public static void

    public static void runGame() {

        // run howManyPlayers() to set number of players
        howManyPlayers();
        // players each get dealt a card


        // compare cards


        // determine who has higher value card
        // winner will be awarded one point
        // todo what about a tie?
        // maybe deal and go again. no points awarded

        // deal next cards
        // repeat process of comparing cards and determining winner

        // continue until all cards are gone

        // higher score is the winner
        // announce winner

    }


} // Class War closing bracket



