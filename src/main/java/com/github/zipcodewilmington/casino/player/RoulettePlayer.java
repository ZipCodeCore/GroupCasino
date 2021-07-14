package com.github.zipcodewilmington.casino.player;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.games.Roulette;

import java.io.Console;

public class RoulettePlayer extends Player{

    private Casino casino = new Casino();
    private Roulette roulette = new Roulette();
    Player player;
    private int bet;

    public RoulettePlayer(Player player) {
        this.player = player;
    }

    public RoulettePlayer() {
    }

    public Player getPlayer() {
        return this.player;
    }

    public void placeBetOnColor() {
        player.setPlayerBalance(player.getPlayerBalance() - bet);
        if(casino.rouletteColorInput() == "red") {
            roulette.betOnRed();
        } else roulette.betOnBlack();
    }

    public void placeBetOnEvensOrOdds() {
        player.setPlayerBalance(player.getPlayerBalance() - bet);
        if(casino.rouletteEvenOddInput() == "evens") {
            roulette.betOnEvens();
        } else roulette.betOnOdds();
    }

    public void placeBetOnNumber() {
        player.setPlayerBalance(player.getPlayerBalance() - bet);
        if(casino.rouletteNumberInput() == roulette.winningNumber()) {
            playerWinsNumber();
        }
    }

    public void playerWinsColor() {
        player.setPlayerBalance(player.getPlayerBalance() + (bet));
    }

    public void playerWinsEvensOdds() {
        player.setPlayerBalance(player.getPlayerBalance() + (bet));
    }

    public void playerWinsNumber() {
        player.setPlayerBalance(player.getPlayerBalance() + (35 * bet));
    }

}
