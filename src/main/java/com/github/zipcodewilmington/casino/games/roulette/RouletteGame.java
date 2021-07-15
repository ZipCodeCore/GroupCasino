package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GambleableGame;
import com.github.zipcodewilmington.casino.GamblingPlayer;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.objects.Wheel;

import java.util.List;
import java.util.Scanner;

public class RouletteGame implements GambleableGame, GamblingPlayer {
    Wheel wheel;

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        Scanner scanner = new Scanner(System.in);
        return null;
    }

    @Override
    public void add(PlayerInterface player) {

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

    @Override
    public void increaseBet(float raise) {

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


}
