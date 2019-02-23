package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Player;

public class CrapsPlayer implements GamblingPlayer {
    private String name;
    private double wallet;
    private Player player;

    public CrapsPlayer(Player player) {
    }

    public double bet(double amount) {
        return 0.0;
    }

    public void collect(double amount) {
    }
}
