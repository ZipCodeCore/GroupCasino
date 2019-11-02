package io.zipcoder.casino.Menus;

import io.zipcoder.casino.GameObject;
import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;

import java.util.HashMap;

public class MainMenu implements Menu {

    private HashMap<Integer, Menu> choiceMap;
    private Player player;
    private Console console;
    private String name = "Main Menu";

    public MainMenu(Player player) {
        this.player = player;
        this.console = new Console(System.in, System.out);

        choiceMap = new HashMap<Integer, Menu>();
        int count = 0;
        choiceMap.put(++count, new GameMenu(this.player));
        choiceMap.put(++count, new TellerMenu(this.player));

    }

    @Override
    public void displayMenu() {

        // temporary
        for (int gameNum : choiceMap.keySet()) {
            console.println(String.format("%d: %s", gameNum, (choiceMap.get(gameNum)).getName()));
        }
        console.menuChoice(2);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void handleChoice(int choice) {
        choiceMap.get(choice).displayMenu();
    }

    public Player newPlayerDialogue() {
        return null;
    }
}
