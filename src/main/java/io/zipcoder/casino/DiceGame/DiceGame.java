package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.Game;
import io.zipcoder.casino.Player;

public abstract class DiceGame implements Game {
    private Player player;
    private Dice dice;

    public abstract void play();
}
