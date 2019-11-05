package io.zipcoder.casino.DiceGames;

public class Dice {
    private boolean kept;
    private int value;

    public Dice(){
        kept = false;
        value = 0;
    }
    public void rollDice(){
        this.value = (int)(Math.random() * ((6 - 1) + 1)) + 1;
    }

    public void keptOrRolled(){
        kept = !kept;
    }

    public boolean isKept() {
        return kept;
    }

    public void setKept(boolean kept) {
        this.kept = kept;
    }

    public int getValue() {
        return value;
    }
    public String toString(){
        return String.format("Value: %d  : Keeping: %b", value, kept);
    }
}