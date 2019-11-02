package io.zipcoder.casino.Menus;

import io.zipcoder.casino.GameObject;
import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Player;

import java.util.HashMap;

public class MainMenu implements Menu {

    private HashMap<Integer, Menu> choiceMap;

    @Override
    public void displayMenu() {
        choiceMap = new HashMap<Integer, Menu>();

    }

    @Override
    public void handleChoice(int choice) {
        choiceMap.get(choice).displayMenu();
    }

    public Player newPlayerDialogue() {
        return null;
    }
}
