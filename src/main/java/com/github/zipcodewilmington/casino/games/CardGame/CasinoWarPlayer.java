package com.github.zipcodewilmington.casino.games.CardGame;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

public class CasinoWarPlayer implements PlayerInterface {
    IOConsole console = new IOConsole();
    CasinoWar currentGame;
    String determineWinner;

    public CasinoWarPlayer(CasinoWar currentGame){

        this.currentGame=currentGame;
    }


    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> void play() {
        determineWinner= currentGame.determineWinner();

    }
}
