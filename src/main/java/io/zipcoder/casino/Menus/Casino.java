package io.zipcoder.casino.Menus;


import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;

public class Casino {

    private static Console console = new Console(System.in, System.out);

    public static void main(String[] args) {
        // write your tests before you start fucking with this
        Casino.prologue();
        Player player = Casino.newPlayerDialogue();

        MainMenu mainmenu = new MainMenu(player);
        mainmenu.displayMenu();
        Casino.displayEnding();
    }

    public static void prologue () {
        console.println("Lorem ipsum intro...");
    }

    public static Player newPlayerDialogue() {
        String firstName = console.getInput("What's your first name? ");
        String lastName = console.getInput("What's your last name? ");
        int age = console.getInteger("How old are you? ");
        return new Player(firstName, lastName, age, 0.0);
    }



    public static void displayEnding() {
        console.println("Lorem impsum ending...");
    }
}
