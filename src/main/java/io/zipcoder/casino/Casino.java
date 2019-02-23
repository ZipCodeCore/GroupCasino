package io.zipcoder.casino;


import io.zipcoder.casino.utilities.Console;

public class Casino {
    private Player player;
    private Game game;

    public static void main(String[] args) {
        Console temp = Console.getInstance();
        int intInput = temp.getIntegerInput("Enter an integer.");
        temp.println("You entered %d", intInput);
    }
}
