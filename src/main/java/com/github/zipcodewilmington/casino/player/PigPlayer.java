package com.github.zipcodewilmington.casino.player;

//import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Pig;

public class PigPlayer extends Player implements PlayerInterface {


    private Pig pigGame = new Pig();
    Player player;
    CasinoAccount casinoAccount;

    public PigPlayer(Player player, CasinoAccount casinoAccount) {
        this.player = player;
        this.casinoAccount = casinoAccount;
    }

    public PigPlayer() {
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

//    @Override
//    public <SomeReturnType> SomeReturnType play() {
//        return null;
//    }
}
