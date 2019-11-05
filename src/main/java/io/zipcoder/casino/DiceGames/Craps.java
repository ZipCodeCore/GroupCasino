package io.zipcoder.casino.DiceGames;

import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Interfaces.GamblingPlayer;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.utilities.Console;

public class Craps implements Game, GamblingGame,GamblingPlayer {

    public Craps crapsGame = new

    private static Console console = new Console(System.in, System.out);

    private String[] availableOptionsCrapsNames = {"Roll the Die ","YO Levine the Dancing Queen", "Place Your Bets",
                                                    "Winner Winner Chicken Dinner", "Nina Nina from Pasedena"};

    public void user(){}
    public void diceValues (){}
    public void  currentRolledNumber(){}
    public void PointNumber(){}
    public void startGame(){}
    public int [] roll (int[] diceValues){
        return null;
    }
    public void distributeWinnings(){}
    public void evaluateDiceValue (){}
    public void  promptLeaveGame(){}
    public void  displayResults(){}


    public void placeWage() {

    }
}
