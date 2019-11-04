package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Utilities.Console;

public class GoFishMenu implements Menu {

    private Console console;
    private String name = "Go Fish Menu";

    public GoFishMenu() {
        this.console = new Console (System.in, System.out);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayMenu() {
        console.clearScreen();

        console.println("Go Fiiiiiish");

    }

    @Override
    public void handleChoice(int choice) {

    }
}
