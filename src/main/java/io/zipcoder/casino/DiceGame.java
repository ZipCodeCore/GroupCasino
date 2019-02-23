package io.zipcoder.casino;

public abstract class DiceGame implements Game {
    private Player player;
    private Dice dice;

    public abstract void play();

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
