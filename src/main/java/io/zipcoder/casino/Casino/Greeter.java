package io.zipcoder.casino.Casino;

import io.zipcoder.casino.utilities.Console;

public class Greeter {
    private Console console = Console.getConsole();
    public Greeter(){}

    public String getNextGame() {
        String game = console.getStringInput(
                "Would you like to play blackjack, GoFish, craps, Macao or leave?");
        game = game.toLowerCase().trim();
        return game;
    }

    public String getNextCleanGame() {
        String game = console.getStringInput("Would you like to play GoFish, Macao or leave?");
        game = game.toLowerCase().trim();
        return game;
    }

    public String getUserName() {
        return console.getStringInput("Welcome to our Casino! What's your name?");
    }

    public Boolean getIfGambling(String name) {
        Integer age = console.getIntegerInput(String.format("It's great to meet you, %s . How old are you?"));
        if (age > 18) {
            String isGambling = console.getStringInput("And will you be gambling here today?");
            console.print("Your starting balance with us is 500 zips. Best of luck!");
            return parseIsGambling(isGambling);
        } else {
            console.print("No problem, we're happy to offer GoFish and Macao for our nongamblers. They do still cost" +
                    " money, though. Your starting balance is 500 zips.");
            return false;
        }
    }

    private Boolean parseIsGambling(String isGambling) {
        isGambling = isGambling.toLowerCase().trim();
        if ("yes".equals(isGambling)) {
            console.println("Happy to hear it.");
            return true;
        } else  if ("no".equals(isGambling)) {
            return false;
        } else {
            console.println("That sounds like a yes! ");
            return true;
        }
    }
}
