package com.github.zipcodewilmington.casino.player;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer extends Player implements PlayerInterface {

    Player player;
    private int bet;
    CasinoAccount casinoAccount;

    public SlotsPlayer(Player player, CasinoAccount casinoAccount) {
        this.player = player;
        this.casinoAccount = casinoAccount;
    }

    public SlotsPlayer() {
    }

    public Player getPlayer() {
        return this.player;
    }

    public void updatePlayerBalance() {
        player.setPlayerBalance(player.getPlayerBalance() + (bet));
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