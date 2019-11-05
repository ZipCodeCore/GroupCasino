package io.zipcoder.casino.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerWarehouse {

    private HashMap <String, Player> warehouse = new HashMap<String, Player>();

    public void addPlayer(String ID, String pwd){

        Player newUser = new Player(ID, pwd);
        warehouse.put(newUser.ID, newUser);

    }

    public Player getPlayer(int idNum){
        return warehouse.get(idNum);
    }


}
