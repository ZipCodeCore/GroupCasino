package io.zipcoder.casino.DiceGames;

import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player.GamblingPlayer;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

public class Craps implements Game, GamblingGame {
    public static void main(String[] args) {

    }
    private Dice[] crapsDice;


    private GamblingPlayer crapsPlayer;

    private  Console console;


    //------------- Constructor----------------------------
    public Craps(Player player) {
        this.crapsPlayer = new GamblingPlayer(player);
        this.crapsDice = createDice();

    }
    //------------------------------------------------------
    public Dice[] createDice() {
        Dice[] dice = new Dice[2];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Dice();
        }
        return dice;
    }



    public void startGame() {

    }

    public void promptLeaveGame() {

    }


    public void displayResults() {
        console.
    }


    public void distributeWinnings() {

    }
}
