package com.github.zipcodewilmington.casino.games.CardGame;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

public class CasinoWarPlayer implements PlayerInterface {
    IOConsole console = new IOConsole();
    CasinoWar currentGame;
    String determineWinner;
    private CasinoAccount casinoRobinAccount;

    public CasinoWarPlayer(CasinoAccount casinoRobinAccount){

        this.casinoRobinAccount=casinoRobinAccount;
    }


    @Override
    public CasinoAccount getArcadeAccount() {
        return this.casinoRobinAccount;
    }

    @Override
    public <SomeReturnType> void play() {
        determineWinner= currentGame.determineWinner();

    }

    @Override
    public void setArcadeAccount(CasinoAccount casinoAccount) {

    }
}
