package io.zipcoder.casino;

import io.zipcoder.casino.Player.PlayerWarehouse;

public class Main {

    public static void main (String[] args) {
        Casino casino = new Casino();
        PlayerWarehouse.initializePlayers();
        while (true) {
            casino.run();
        }
    }
}
