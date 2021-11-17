package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;
import java.util.Scanner;

public class Slots {

    public static void main(String[] args) {

        // todo place all of this into a run() method and then call elsewhere???

        // instance fields (need for uml)
        int tokens = 100;
//        int amountWon;
        int amountWagered;
        int slot1;
        int slot2;
        int slot3;
        int input;
        Random randomNumber = new Random();
        IOConsole consoleAuto = new IOConsole(AnsiColor.AUTO);
        IOConsole consoleGreen = new IOConsole(AnsiColor.GREEN);
//        IOConsole consolePurple = new IOConsole(AnsiColor.PURPLE);
        IOConsole consoleRed = new IOConsole(AnsiColor.RED);
        IOConsole consoleBlack = new IOConsole(AnsiColor.BLACK);

        do {

            if (tokens == 0) {
                tokens = tokens + 100;
                consoleAuto.println("\nDon't go anywhere! We gave you 100 more tokens :)");
            }


            consoleAuto.println("Welcome to the Slot Machine game");
            consoleAuto.println("You currently have " + tokens + " tokens");
            amountWagered = consoleAuto.getIntegerInput("\nHow many tokens would you like to wager?");

            // how many tokens?


            while (true) {
                if (amountWagered > tokens) {
                    amountWagered = consoleAuto.getIntegerInput("You do not have enough tokens for that wager. Please place wager again.");
                }
                else if (amountWagered < 0) {
                    amountWagered = consoleAuto.getIntegerInput("Sorry, but that is not a valid amount to wager. Please enter a wager more than zero.");
                }
                else if (amountWagered == 0) {
                    amountWagered = consoleAuto.getIntegerInput("C'mon, that's no fun. Please enter a valid wager amount.");
                }
                else if (amountWagered <= tokens) {
                    consoleAuto.println("\nAlright! Let's play Slots! \n");
                    break;
                }
            }


            // using random number generator to create random number for each slot
            slot1 = randomNumber.nextInt(4) + 1;
            slot2 = randomNumber.nextInt(4) + 1;
            slot3 = randomNumber.nextInt(4) + 1;

            // assigning random number values to each suit to be used in game
            switch (slot1) {
                case 1:
                    consoleRed.println("♥ Heart ♥");  // use console class
                    break;
                case 2:
                    consoleBlack.println("♠ Spade ♠");
                    break;
                case 3:
                    consoleRed.println("❖ Diamond ❖");
                    break;
                case 4:
                    consoleBlack.println("♣ Club ♣");
                    break;


            }

            switch (slot2) {
                case 1:
                    consoleRed.println("♥ Heart ♥");  // use console class
                    break;
                case 2:
                    consoleBlack.println("♠ Spade ♠");
                    break;
                case 3:
                    consoleRed.println("❖ Diamond ❖");
                    break;
                case 4:
                    consoleBlack.println("♣ Club ♣");
                    break;


            }

            switch (slot3) {
                case 1:
                    consoleRed.println("♥ Heart ♥       \n");  // use console class
                    break;
                case 2:
                    consoleBlack.println("♠ Spade ♠     \n");
                    break;
                case 3:
                    consoleRed.println("❖ Diamond ❖     \n");
                    break;
                case 4:
                    consoleBlack.println("♣ Club ♣      \n" );
                    break;

            }


            // winning conditions
            if (slot1 == slot2 && slot1 == slot3) {
                consoleGreen.println("All three suits match--You win the jackpot!");
                tokens = tokens + (amountWagered * 2);
            } else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3) {
                consoleGreen.println("Two matching suits--You win.");
                tokens = tokens + (amountWagered);
            } else {
                consoleRed.println("Nothing matches--You lose " + amountWagered + " tokens.");
                tokens = tokens - amountWagered;
            }

            consoleAuto.println("You now have " + tokens + " tokens.");


            input = consoleAuto.getIntegerInput("Press 1 to play again.\nPress 2 to return to the main menu.");


        }
        while (input == 1);

    }
}
