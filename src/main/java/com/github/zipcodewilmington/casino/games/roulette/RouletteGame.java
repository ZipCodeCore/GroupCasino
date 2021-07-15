package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.objects.Wheel;

import java.util.List;
import java.util.Scanner;

public class RouletteGame implements GambleableGame {
    String gameName;
    Wheel wheel;
    List<PlayerInterface> activePlayers;
    RoulettePlayer player;

    public RouletteGame(String gameName, List<PlayerInterface> activePlayers, RoulettePlayer player) {
        this.gameName = gameName;
        this.activePlayers = activePlayers;
        this.player = player;
    }

    @Override
    public void add(PlayerInterface player) {
        activePlayers.add(this.player);

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        wheel.getSpinValue();

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
