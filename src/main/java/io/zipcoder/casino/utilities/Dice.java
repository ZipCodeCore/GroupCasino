package io.zipcoder.casino.utilities;

public class Dice {

    private final int SIDES = 6;

    public Dice() {
    }

    public int roll() {
        return (int)(Math.random()*6 + 1);
    }

}

