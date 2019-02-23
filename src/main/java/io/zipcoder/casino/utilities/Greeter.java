package io.zipcoder.casino.utilities;

import io.zipcoder.casino.Cards.Games.*;
import io.zipcoder.casino.utilities.Console;

import java.util.NoSuchElementException;

public class Greeter {
    private Console console;

    public Greeter(){
        this.console = Console.getConsole();
    }

    public Greeter(Console console) {
        this.console = console;
    }

    public String getUserName() {
        try {
            String name = console.getStringInput("Welcome to our Casino! What's your name?");
            return name;
        } catch (NoSuchElementException exception) {
            return "Jane Doe";
        }
    }

    public Boolean getIfGambling(String name) {
        Integer age = console.getIntegerInput(String.format("It's great to meet you, %s. How old are you?", name));
        if (age >= 18) {
            String isGambling = console.getStringInput("And will you be gambling here today?");
            return parseIsGambling(isGambling);
        } else {
            console.print("No problem, we're happy to offer GoFish and Macao for our nongamblers. They do still" +
                    " cost money, though. Your starting balance is 500 zips.\n");
            return false;
        }
    }

    private Boolean parseIsGambling(String isGambling) {
        isGambling = isGambling.toLowerCase().trim();
        if ("yes".equals(isGambling)) {
            console.println("Your starting balance with us is 500 zips. Best of luck!");
            return true;
        } else  if ("no".equals(isGambling)) {
            return false;
        } else {
            console.println("That sounds like a yes!");
            return true;
        }
    }

    public Game getNextGame() {
        String game = console.getStringInput(
                "Would you like to play BlackJack, GoFish, Craps or Macao?");
        game = game.toLowerCase().trim();
        return parseGame(game, true);
    }

    public Game getNextCleanGame() {
        String game = console.getStringInput("Would you like to play GoFish or Macao?");
        game = game.toLowerCase().trim();
        return parseGame(game, false);
    }

    private Game parseGame(String game, Boolean gambling) {
        if (game.equals("blackjack") && gambling) {
            console.println("Sounds good, let me go get the BlackJack dealer");
            console.clear();
            return new BlackJack();
        } else if (game.equals("craps") && gambling) {
            console.println("The Craps table is right over here");
            console.clear();
            return new Craps();
        } else if (game.equals("macao")) {
            console.println("Great, I hope you remember how to play");
            console.clear();
            return new Macao();
        } else if (game.equals("gofish")) {
            console.println("Great game, GoFish! Just a moment.");
            console.clear();
            return new GoFish();
        } else {
            console.println("How about we play my favorite game, GoFish?");
            console.clear();
            return new GoFish();
        }
    }


    public boolean getIfLeaving() {
        String isLeaving = console.getStringInput("That was great! Would you like to play another game?");
        if (isLeaving.toLowerCase().trim().equals("no")) {
            return true;
        } else if (isLeaving.toLowerCase().trim().equals("yes")) {
            console.println("We're happy you're staying!");
            return false;
        } else {
            console.println("It sounds like you'd like to play another game!");
            return false;
        }
    }

    public void balanceTooLow() {
        console.println("Sorry, your balance is too low to keep playing.");
    }

    public void goodBye() {
        console.println("Thank you so much for coming! Please come again!");
    }

}
