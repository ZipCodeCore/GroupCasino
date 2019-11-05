package io.zipcoder.casino.Player;

import java.util.ArrayList;

public class PlayerWarehouse {

    private ArrayList<Player> warehouse = new ArrayList<>();

    public void addPlayer(int ID, int pwd){

        Player newUser = new Player(ID, pwd);
        warehouse.add(newUser);

    }
}
