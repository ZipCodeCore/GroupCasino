package com.github.zipcodewilmington.casino.player;

//import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Roulette;


import java.io.Console;

public class RoulettePlayer extends Player implements PlayerInterface {

    private Casino casino = new Casino();
    private Roulette roulette = new Roulette();
    Player player;
    private int bet;
    CasinoAccount casinoAccount;


    public RoulettePlayer(Player player, CasinoAccount casinoAccount) {
        this.player = player;
        this.casinoAccount = casinoAccount;
    }

    public RoulettePlayer() {
    }

    public Player getPlayer() {
        return this.player;
    }

    public void playerWinsColor() {
        player.setPlayerBalance(casinoAccount.getPlayerBalance() + (bet));
    }

    public void playerWinsEvensOdds() {
        player.setPlayerBalance(casinoAccount.getPlayerBalance() + (bet));
    }

    public void playerWinsNumber() {
        player.setPlayerBalance(casinoAccount.getPlayerBalance() + (35 * bet));
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return casinoAccount;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

    public void setArcadeAccount() {
        this.casinoAccount = casinoAccount;
    }
}
