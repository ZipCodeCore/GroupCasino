package io.zipcoder.casino.DiceGames.Craps;

import io.zipcoder.casino.DiceGames.Dices.Dice;
import io.zipcoder.casino.DiceGames.Dices.DiceGame;
import io.zipcoder.casino.Games.Game;

import java.util.ArrayList;

public class Craps extends DiceGame implements Game {

    private ArrayList<Dice> thrownDice;
    private Integer sumOfDice;
    private Integer pointNumber;
}
