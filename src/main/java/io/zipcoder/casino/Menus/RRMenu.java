package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.RR.RRGame;
import io.zipcoder.casino.Utilities.Console;

public class RRMenu implements Menu {

    private Console console;
    private String name = "Russian Roulette Dice Menu";
    private RRGame rrGame;

    public RRMenu(RRGame rrGame) {
        this.console = new Console (System.in, System.out);
        this.rrGame = rrGame;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayMenu() {
        console.clearScreen();

        console.println("Welcome To Russian Roulette! ");
        console.println("First The House Will Roll A Die ");
        console.println("Your Bet Will Be Your Entire Balance ");
        console.println("Next You Will Roll A Die ");
        console.println("If Your Roll Does Not Match The House's Roll, Your Balance Is Doubled ");
        console.println("If Your Roll Matches The House, You Lose All Your Balance ");
    }

    @Override
    public void handleChoice(int choice) {

    }
}
