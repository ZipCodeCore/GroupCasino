package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.GambleableGame;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.List;

public class RouletteGame implements GambleableGame {
    List<RoulettePlayer> activePlayers;


    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

    }

    @Override
    public int getNumberOfPlayers() {
        return 0;
    }

    @Override
    public boolean playerWins() {
        return false;
    }

    @Override
    public boolean playerLoses() {
        return false;
    }

    @Override
    public void clearGame() {

    }
}
