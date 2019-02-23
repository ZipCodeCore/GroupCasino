package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.Player;


import java.util.ArrayList;
import java.util.TreeMap;

public class YahtzeePlayer {
    private String name;
    private Player player;
    private boolean hasYahtzee = false;

    public YahtzeePlayer(Player player) {
        this.name = player.getName();
    }

    public ArrayList<Dice> rollDice(int numberOfDice){
        ArrayList<Dice> rolledDice = new ArrayList<Dice>();
        return rolledDice;
    }

    public ArrayList<Dice> saveDice(ArrayList<Dice> dice, String diceToSaveInput) {
        ArrayList<Dice> diceToSave = new ArrayList<Dice>();
        return diceToSave;
    }

    public ArrayList<Dice> returnDice(ArrayList<Dice> savedDice, String diceToReturnInput){
        ArrayList<Dice> diceToReturn = new ArrayList<Dice>();
        return diceToReturn;
    }

    public ArrayList<Dice> moveDice(ArrayList<Dice> dice, String diceToMoveInput){
        ArrayList<Dice> diceToMove = new ArrayList<Dice>();
        return diceToMove;
    }

    public void markScoreCard(String category, ArrayList<Dice> allDice, TreeMap<String, Integer> scoreCard){
    }


    public String getName() {
        return this.name;
    }
}
