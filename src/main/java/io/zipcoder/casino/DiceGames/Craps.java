package io.zipcoder.casino.DiceGames;

import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player.GamblingPlayer;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

public class Craps implements Game, GamblingGame {

    private Dice[] crapsDice;

    private GamblingPlayer crapsPlayer;

    public Craps(Player player) {
        this.crapsPlayer = new GamblingPlayer(player);

    }

    private boolean continuePlay;

    public void startGame() {
    }

    public void promptLeaveGame() {

    }


    public void displayResults() {
    }


    public void distributeWinnings() {

    }
}
