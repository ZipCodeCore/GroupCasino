package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Utilities.Console;

public class RRMenu implements Menu {

    private Console console;
    private String name = "Russian Roulette Dice Menu";

    public RRMenu() {
        this.console = new Console (System.in, System.out);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayMenu() {
        console.clearScreen();

        console.println("Da");
    }

    @Override
    public void handleChoice(int choice) {

    }
}
