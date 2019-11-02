package io.zipcoder.casino.Menus;

import io.zipcoder.casino.GameObject;
import io.zipcoder.casino.Services.GameRepo;
import io.zipcoder.casino.Utilities.Console;

import java.util.HashMap;

public class GameMenu {

    //maps the choice number to the name of the game
    private HashMap<Integer, GameObject> gameMap;
    private GameRepo gameRepo;

    public GameMenu(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
        this.gameMap = gameRepo.getGamesMap();
    }

    public HashMap<Integer, GameObject> getGameMap() {
        return gameMap;
    }

    // gets a set of allowed game based on player choice
    public void displayGameMenu() {
        // temporary
        for (int gameNum : gameMap.keySet()) {
            System.out.println(String.format("%d: %s", gameNum, gameMap.get(gameNum)));
        }

    }

    // switch cases based on the name of the game
    public void handleChoices(int choice) {

    }


}
