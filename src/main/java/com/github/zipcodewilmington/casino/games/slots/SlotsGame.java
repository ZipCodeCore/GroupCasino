package com.github.zipcodewilmington.casino.games.slots;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame {
    public static void main(String[] args) {

        Random generator = new Random();
        Scanner scanner = new Scanner(System.in);
        String slot1, slot2, slot3;
        int input; // this is where the funds will be added
do{
        System.out.println("Welcome to the Slot Machine!");
        System.out.println("You need 10 tokens to play!" + "\n");
        System.out.println("Press 1 to pull or press 2 to quit");

        input = scanner.nextInt(); //this will be where the funds are added

        String[] slotValues = {"watermelon", "grape", "lemon", "orange", "bar", "7", "BIGWIN", "cherry","banana"};
        slot1 = slotValues[generator.nextInt(slotValues.length)];
        slot2 = slotValues[generator.nextInt(slotValues.length)];
        slot3 = slotValues[generator.nextInt(slotValues.length)];


            System.out.println(slot1 + " " + slot2 + " " + slot3 + "\n");

            if (slot1 == "BIG WIN" && slot1 == slot2 && slot1 == slot3) {
                System.out.println("Jackpot! You win 50 tokens!" + "\n");
            } else if (slot1 == slot2 && slot1 == slot3) {
                System.out.println("Congrats! You win 10 tokens." + "\n");
            } else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3) {
                System.out.println("Congrats! You win 5 tokens." + "\n");
            } else {
                System.out.println("Sorry! Better luck next time." + "\n");
            }
        }
        while(input == 1);

    }
}
