package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;

public class TellerMenu implements Menu {

    private Console console;
    private Player player;
    private String name = "Teller Menu";

    public TellerMenu(Player player) {
        this.player = player;
        this.console = new Console(System.in, System.out);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayMenu() {
        console.clearScreen();

        console.println("Teller...");
        handleChoice(0);
    }

    @Override
    public void handleChoice(int choice) {
        MainMenu mainmenu = new MainMenu(player);
        mainmenu.displayMenu();
    }

}
