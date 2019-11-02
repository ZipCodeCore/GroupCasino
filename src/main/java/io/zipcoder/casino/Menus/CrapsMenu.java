package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Utilities.Console;

public class CrapsMenu implements Menu {

    private Console console;
    private String name = "Craps Menu";

    public CrapsMenu() {
        this.console = new Console (System.in, System.out);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayMenu() {

    }

    @Override
    public void handleChoice(int choice) {

    }

}
