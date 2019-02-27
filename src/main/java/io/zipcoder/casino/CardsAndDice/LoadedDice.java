package io.zipcoder.casino.CardsAndDice;

public class LoadedDice extends Dice {
    private int numberToRoll;

    public LoadedDice(int numberToRoll) {
        this.numberToRoll = numberToRoll;
    }

    @Override
    public int roll() {
        return numberToRoll;
    }

}
