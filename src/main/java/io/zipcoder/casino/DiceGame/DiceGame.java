package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.Game;
import io.zipcoder.casino.Player;

public abstract class DiceGame implements Game {
    private Player player;
    private Dice dice;

    public void play(){
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
