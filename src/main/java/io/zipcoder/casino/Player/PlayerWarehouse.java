package io.zipcoder.casino.Player;

import java.util.HashMap;

//Class Starts
public class PlayerWarehouse {

    private HashMap<String, Player> warehouse;

    public PlayerWarehouse() {
        this.warehouse = new HashMap<String, Player>();
    }

    public void addPlayer(String ID, String pwd) {
        Player newUser = new Player(ID, pwd);
        String key = newUser.ID + newUser.pwd;
        warehouse.put(key, newUser);
    }

    public Player getPlayer(String idNum) {
        return warehouse.get(idNum);
    }


}
