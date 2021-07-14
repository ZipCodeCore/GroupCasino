package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;
import com.github.zipcodewilmington.casino.Player;

public class RoulettePlayer implements GamblingPlayer {

    Player player;
    float playerWinnings;

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

    public boolean finalizeBet(){
        return false;
    }

    public void increaseBet(float raise){

    }

    @Override
    public void decreaseBet(float deposit) {

    }

    @Override
    public float amountWagered() {
        return 0;
    }

    @Override
    public float amountWon() {
        return 0;
    }

    @Override
    public float payOut() {
        return 0;
    }

    void placeOutsideBet(){}

    void placeInsideBet(){}
}
