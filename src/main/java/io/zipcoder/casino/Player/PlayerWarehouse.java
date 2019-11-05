package io.zipcoder.casino.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerWarehouse {

    private HashMap <Integer, Player> warehouse = new HashMap<Integer, Player>();

    public void addPlayer(int ID, int pwd){

        Player newUser = new Player(ID, pwd);
        warehouse.put(newUser.ID, newUser);

    }

    public Player getPlayer(int idNum){
        return warehouse.get(idNum);
    }


}
