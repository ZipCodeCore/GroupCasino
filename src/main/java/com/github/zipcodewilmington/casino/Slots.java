package com.github.zipcodewilmington.casino;

import java.util.Random;
import java.util.Scanner;

public class Slots {

    public static void main(String[] args) {

        int tokens = 100;
        int amountWon; // (amountWagered x 5 if 3 of the same, amountWagered x 2 if 2 of the same)
        int amountWagered;
        int slot1;
        int slot2;
        int slot3;
        int input;
        Random randomNumber = new Random();
        Scanner console = new Scanner(System.in);

        do {
            System.out.println("--Welcome to the Slot Machine game--");
            System.out.println("--You currently have " + tokens + " tokens--");
            System.out.println("--How many tokens would you like to wager?");

            // todo can't let wager be more than current tokens amount

            amountWagered = console.nextInt();

            // how many tokens?
            // todo need to account for negative amount
            // todo need to account for how to keep entering incorrect wager, if you keep doing it then it will let you use that amount
            if (amountWagered < 0) {
                System.out.println("Sorry, but that is not a valid amount to wager. Please enter a positive number.");
                amountWagered = console.nextInt();
            }
            else if (amountWagered > tokens) {
                System.out.println("--How many tokens would you like to wager?");
                amountWagered = console.nextInt();
            } else if (amountWagered == 0) {
                System.out.println("That's no fun. Please enter a valid wager amount.");
                amountWagered = console.nextInt();
            }

            // using random number generator to create random number for each slot
            slot1 = randomNumber.nextInt(4) + 1;
            slot2 = randomNumber.nextInt(4) + 1;
            slot3 = randomNumber.nextInt(4) + 1;

            // assigning random number values to each suit to be used in game
            switch (slot1) {
                case 1:
                    System.out.println("♥ Heart ♥");
                    break;
                case 2:
                    System.out.println("♠ Spade ♠");
                    break;
                case 3:
                    System.out.println("❖ Diamond ❖");
                    break;
                case 4:
                    System.out.println("♣ Club ♣");
                    break;


            }

            switch (slot2) {
                case 1:
                    System.out.println("♥ Heart ♥");
                    break;
                case 2:
                    System.out.println("♠ Spade ♠");
                    break;
                case 3:
                    System.out.println("❖ Diamond ❖");
                    break;
                case 4:
                    System.out.println("♣ Club ♣");
                    break;


            }

            switch (slot3) {
                case 1:
                    System.out.println("♥ Heart ♥");
                    break;
                case 2:
                    System.out.println("♠ Spade ♠");
                    break;
                case 3:
                    System.out.println("❖ Diamond ❖");
                    break;
                case 4:
                    System.out.println("♣ Club ♣");
                    break;

            }

//            System.out.println(slot1 + " " + slot2 + " " + slot3); // todo will need to remove when finished

            // winning conditions
            if (slot1 == slot2 && slot1 == slot3) {
                System.out.println("You win the jackpot!");
                tokens = tokens + (amountWagered * 2);
            } else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3) {
                System.out.println("You win.");
                tokens = tokens + (amountWagered);
            } else {
                System.out.println("You lose " + amountWagered + " tokens.");
                tokens = tokens - amountWagered;
            }

            System.out.println("You now have " + tokens + " tokens.");
            System.out.println("--Press 1 to play again or press 2 to quit and return to the main menu--");

            input = console.nextInt();


        }
        while (input == 1);

    }
}
