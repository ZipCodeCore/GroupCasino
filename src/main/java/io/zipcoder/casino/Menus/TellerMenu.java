package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Player;

public class TellerMenu implements Menu {

    private Player player;
    private String name = "Teller Menu";

    public TellerMenu(Player player) {
        this.player = player;
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
