package io.zipcoder.casino;
import io.zipcoder.casino.Player;


import io.zipcoder.casino.utilities.Console;

public class Casino {

    private static Console console = new Console(System.in, System.out);

    public static void main(String[] args) {
    }

    public static Player playerInfo() {
        String firstName = console.getInput("Teller: What's your first name? ");
        String lastName = console.getInput("Teller: What's your last name? ");
        int age = console.getInteger("Teller: How old are you? ");
        return new Player(firstName, lastName, age, 0.0);
    }
}

