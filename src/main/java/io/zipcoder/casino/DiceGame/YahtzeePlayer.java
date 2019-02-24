package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.Player;


import java.util.ArrayList;
import java.util.TreeMap;

public class YahtzeePlayer {
    private String name;
    private Player player;

    public YahtzeePlayer(Player player) {
        this.name = player.getName();
        this.player = player;
    }

    public ArrayList<Dice> rollDice(int numberOfDice){
        ArrayList<Dice> rolledDice = new ArrayList<>();
        for (int i = 0; i < numberOfDice; i++){
            Dice die = new Dice(1);
            int dieValue = die.rollDice();
            rolledDice.add(new Dice(1, dieValue));
        }
        return rolledDice;
    }

    public ArrayList<Dice> saveDice(ArrayList<Dice> rolledDice, String diceToSaveInput) {
        return moveDice(rolledDice, diceToSaveInput);
    }

    public ArrayList<Dice> returnDice(ArrayList<Dice> savedDice, String diceToReturnInput){
        return moveDice(savedDice, diceToReturnInput);
    }

    public ArrayList<Dice> moveDice(ArrayList<Dice> diceToMoveFrom, String diceToMoveInput){
        ArrayList<Dice> diceToMove = new ArrayList<>();
        for (int i = 0; i < diceToMoveInput.length(); i++){
            int indexOfDieToMove = Character.getNumericValue(diceToMoveInput.charAt(i)) - 1;
            diceToMove.add(diceToMoveFrom.get(indexOfDieToMove));
        }
        return diceToMove;
    }


    public String getName() {
        return this.name;
    }

    public Player getPlayer() {
        return this.player;
    }
}
