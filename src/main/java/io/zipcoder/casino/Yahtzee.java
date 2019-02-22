package io.zipcoder.casino;

public class Yahtzee extends DiceGame {
    private int rollNumber;
    private java.util.TreeMap<String, Integer> scoreCard;
    private int score;
    private java.util.ArrayList<Dice> savedDice;
    private java.util.ArrayList<Dice> rolledDice;
    private YahtzeePlayer yahtzeePlayer;

    public void play() {
    }

    public void walkAway(){}
}
