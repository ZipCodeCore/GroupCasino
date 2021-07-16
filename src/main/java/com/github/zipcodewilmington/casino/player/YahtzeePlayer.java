package com.github.zipcodewilmington.casino.player;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class YahtzeePlayer extends Player implements PlayerInterface {

    Player player;
    CasinoAccount casinoAccount;

    public YahtzeePlayer(Player player, CasinoAccount casinoAccount) {
        this.player = player;
        this.casinoAccount = casinoAccount;
    }

    public YahtzeePlayer() {
    }

    public Player getPlayer() {
        return this.player;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return casinoAccount;
    }

    public void setArcadeAccount() {
        this.casinoAccount = casinoAccount;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
