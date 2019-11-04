package io.zipcoder.casino.Menus;


import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Casino {

    private static Console console = new Console(System.in, System.out);

    public static void main(String[] args)  {
        // write your tests before you start fucking with this
        Casino.prologue();
        Player player = Casino.newPlayerDialogue();

        MainMenu mainmenu = new MainMenu(player);
        mainmenu.displayMenu();
        Casino.displayEnding();
    }

    public static void prologue () {
        console.println("You had a really long day at work and decide to take the edge off by visiting the local casino,\n" +
                "'Maybe if I win some big bucks I'll get out of this boring job of mine.', You think to yourself. \n"+
                "The same thought always crosses your mind when passing by the big flashy sign embroidered with flashing poker chips.\n" +
                        "But tonight is a little different... \n" + "\n" + "Tonight you're feeling lucky. \uD83C\uDF40" + "\n" + "\n" + "\n" + "\n" +
                "------------------------------------------------------------------------------------------------------\n");
    }

    public static Player newPlayerDialogue() {
        String firstName = console.getInput("((You walk up to the entrance and get greeted by a tall, stocky man with a handlebar mustache))\n" +
                "\n[TELLER]: What's your first name?\n");
        String lastName = console.getInput("\n[TELLER]: What's your last name? \n");
        int age = console.getInteger("\n[TELLER]: How old are you? \n");
        return new Player(firstName, lastName, age, 0.0);
    }



    public static void displayEnding() {
        console.println("Lorem impsum ending...");
    }
}
