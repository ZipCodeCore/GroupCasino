package io.zipcoder.casino;


import io.zipcoder.casino.player.Player;

public class Casino {
    public static void main(String[] args) {
        // write your tests before you start fucking with this
        Handler handler = new Handler();
        handler.setUpPlayer();
        handler.run();
    }
}
