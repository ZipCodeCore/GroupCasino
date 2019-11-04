package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;

public class NullMenu implements Menu {

    private String name = "Quit";
    private Console console = new Console(System.in, System.out);


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayMenu() {
        console.clearScreen();


    }

    @Override
    public void handleChoice(int choice) {

    }
}
