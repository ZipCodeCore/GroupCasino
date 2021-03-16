package io.zipcoder.casino;

import java.util.Scanner;

public class Displays {

    public static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public void welcomeScreen() {
        println("                              ");
        println("        $$  $$                ");
        println("     $$$$$$$$$$$$$            ");
        println("    $$$$$$$$$$$$$$$           ");
        println("   $$$   $$  $$ $$$$          ");
        println("   $$$   $$  $$  $$$          ");
        println("   $$$   $$  $$               ");
        println("    $$$$ $$  $$               ");
        println("     $$$$$$$$$$$$$            ");
        println("      $$$$$$$$$$$$$           ");
        println("         $$  $$ $$$$          ");
        println("         $$  $$   $$$         ");
        println("    $$$  $$  $$   $$$         ");
        println("    $$$$ $$  $$ $$$$          ");
        println("     $$$$$$$$$$$$$$$          ");
        println("      $$$$$$$$$$$$            ");
        println("         $$  $$               ");
        println("                              ");
        println(" Welcome to The ZCW Casino!!! ");
        println("------------------------------");
        println("     Enter Casino: 00         ");
        println("     Leave Casino: 99         ");
        println("                              ");
    }

    public void invalidEntryWelcomeScreen() {
        println("                              ");
        println("  Invalid Entry. Try again    ");
        println("------------------------------");
        println("     Enter Casino: 00         ");
        println("     Leave Casino: 99         ");
        println("                              ");
    }

    public void goodbyeCasinoScreen() {
        println("                              ");
        println("   Have a wonderful day!      ");
        println("     Come again soon!         ");
        println("                              ");
    }

    public void casinoLobbyScreen() {
        println("                              ");
        println("     May the odds be          ");
        println("    ever in your favor!       ");
        println("------------------------------");
        println("    Teller Window:   1        ");
        println("   *GoFish Room:     2        ");
        println("    BlackJack Room:  3        ");
        println("    Craps Room:      4        ");
        println("    Poker Dice Room: 5        ");
        println("                              ");
        println(" *Don't need chips to play    ");
        println("                              ");
    }

    public void casinoLobbyInvalidScreen() {
            println("                              ");
            println("     Invalid input            ");
            println("                              ");
            println("------------------------------");
            println("    Teller Window:   1        ");
            println("   *GoFish Room:     2        ");
            println("    BlackJack Room:  3        ");
            println("    Craps Room:      4        ");
            println("    Poker Dice Room: 5        ");
            println("                              ");
            println(" *Don't need chips to play    ");
            println("                              ");
    }

    public void tellerWindowScreen() {
        println("                              ");
        println("   How much money would       ");
        println("   you like to exchange?      ");
        println("   ---------------------      ");
        println("       $1 = 1 Chip            ");
        println("                              ");

    }

}
