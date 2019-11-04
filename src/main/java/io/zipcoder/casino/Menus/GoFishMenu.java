package io.zipcoder.casino.Menus;

import io.zipcoder.casino.GoFish.GoFishGame;
import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Utilities.Console;

public class GoFishMenu implements Menu {

    private Console console;
    private String name = "Go Fish Menu";
    private GoFishGame goFishGame;

    public GoFishMenu(GoFishGame goFishGame) {
        this.console = new Console (System.in, System.out);
        this.goFishGame = goFishGame;
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
