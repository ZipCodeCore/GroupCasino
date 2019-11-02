package io.zipcoder.casino.Menus;

import io.zipcoder.casino.GameObject;
import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Services.GameRepo;
import io.zipcoder.casino.Utilities.Console;

import java.util.HashMap;

public class GameMenu implements Menu {

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
    
    @Override
    public void displayMenu() {
        // temporary
        for (int gameNum : gameMap.keySet()) {
            System.out.println(String.format("%d: %s", gameNum, ((GameObject) gameMap.get(gameNum)).getName()));
        }
    }

    @Override
    public void handleChoice(int choice) {
        gameMap.get(choice).startPlay();
    }

}
