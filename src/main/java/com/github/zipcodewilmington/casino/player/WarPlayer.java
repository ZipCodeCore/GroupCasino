package com.github.zipcodewilmington.casino.player;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.card.Hand;

public class WarPlayer extends Player implements PlayerInterface {


    Player player;
    Hand hand;
    CasinoAccount casinoAccount;

    public WarPlayer(Player player, CasinoAccount casinoAccount) {
        this.player = player;
        this.casinoAccount = casinoAccount;
    }

    public WarPlayer() {
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
