package io.zipcoder.casino;

import java.util.HashMap;

public class PlayerRepository {

    HashMap<String, Player> playerDataBase;

    Player findPlayer(String playerName) {
        return playerDataBase.get(playerName);
    }

    boolean addPlayer(Player player) {
        if(playerDataBase.containsKey(player.getName())) {
            return false;
        } else {
            playerDataBase.put(player.getName(), player);
            return true;
        }
    }

}
