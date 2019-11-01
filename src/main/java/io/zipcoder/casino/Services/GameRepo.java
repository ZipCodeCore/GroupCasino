package io.zipcoder.casino.Services;

import io.zipcoder.casino.Game;
import io.zipcoder.casino.GameObject;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class GameRepo {

    private ArrayList<GameObject> gamesList;

    public GameRepo(ArrayList<GameObject> gamesList) {
        this.gamesList = gamesList;
    }

    public ArrayList<GameObject> getGamesList() {
        return this.gamesList;
    }

    public ArrayList<GameObject> getGamesList(Player player) {
        return null;
    }

    public Game getGame() {
        return null;
    }

}
