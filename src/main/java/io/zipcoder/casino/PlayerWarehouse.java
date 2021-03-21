package io.zipcoder.casino;

import java.util.HashMap;

public class PlayerWarehouse {

    private HashMap<String, Player> playerGroup;
    private HashMap<String, String> userNamePasswordMap;

    public PlayerWarehouse() {
        this.playerGroup = new HashMap<String, Player>();
        this.userNamePasswordMap = new HashMap<String, String>();
    }

    public Player getPlayer(String userId) {
        return this.playerGroup.get(userId);
    }

    public boolean validateUniquePlayer(String userId) {
        if (userNamePasswordMap.containsKey(userId)) {
            return false;
        }
        return true;
    }

    public void addNewPlayer(String userId, Player player, String password) {
        playerGroup.put(userId, player);
        userNamePasswordMap.put(userId, password);
    }

    public boolean validateLoginCredentials(String userId, String password) {



        if (userNamePasswordMap.containsKey(userId) && userNamePasswordMap.get(userId).equals(password)) {
            return true;
        }
    return false;
    }

}
