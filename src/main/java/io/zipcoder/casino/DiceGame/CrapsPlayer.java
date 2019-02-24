package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Player;

public class CrapsPlayer implements GamblingPlayer {
    private String name;
    private double wallet;
    private Player player;


    public CrapsPlayer(Player player) {
        this.wallet = player.getWallet();
    }

    public void bet(double amount) {
        this.wallet = wallet - amount;
    }

    public void collect(double amount) {
    }
}
