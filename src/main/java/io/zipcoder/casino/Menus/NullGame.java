package io.zipcoder.casino.Menus;

import io.zipcoder.casino.CardGame;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player;

import io.zipcoder.casino.utilities.Console;


public class NullGame extends CardGame implements Game {

    private String name = "Main Menu";
    private Console console = new Console(System.in, System.out);
    private Player player;

    public NullGame(Player player) {
        this.player = player;
    }

    @Override
    public String getName() {
        return name;
    }

    public void startPlay() {
        MainMenu mainmenu = new MainMenu(player);
        mainmenu.displayMenu();
    }

    public void roundOfPlay() {

    }

    public void endChoice() {

    }

}
