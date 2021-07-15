package com.github.zipcodewilmington.casino.games.cards;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.objects.Deck;

import java.util.ArrayList;

public class Blackjack implements GambleableGame, GamblingPlayer {

    ArrayList<Player> players;
    Deck deck;


    public Blackjack(Deck deck) {
        this.deck = deck;
    }




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

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
