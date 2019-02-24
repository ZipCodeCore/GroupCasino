package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.Player;


import java.util.ArrayList;
import java.util.TreeMap;

public class YahtzeePlayer {
    private String name;
    private Player player;
    private int rollNumber = 0;


    public YahtzeePlayer(Player player) {
        this.name = player.getName();
        this.player = player;
    }

    public ArrayList<Dice> rollDice(int numberOfDice) throws TooManyRollsException{
        if (rollNumber >= 3){
            throw new TooManyRollsException();
        }
        else {
            ArrayList<Dice> rolledDice = new ArrayList<>();
            for (int i = 0; i < numberOfDice; i++) {
                Dice die = new Dice(1);
                int dieValue = die.rollDice();
                rolledDice.add(new Dice(1, dieValue));
            }
            rollNumber++;
            return rolledDice;
        }
    }


    public ArrayList<Dice> saveDice(ArrayList<Dice> rolledDice, String diceToSaveInput) {
        ArrayList<Dice> savedDice = new ArrayList<>();
        for (int i = 0; i < diceToSaveInput.length(); i++) {
            int indexOfDieToSave = Character.getNumericValue(diceToSaveInput.charAt(i)) - 1;
            savedDice.add(rolledDice.get(indexOfDieToSave));
        }
        removeSameDice(rolledDice, savedDice);

        return savedDice;
    }


    public ArrayList<Dice> returnDice(ArrayList<Dice> savedDice, String diceToReturnInput) {
        ArrayList<Dice> returnedDice = new ArrayList<>();
        for (int i = 0; i < diceToReturnInput.length(); i++){
            int indexOfDieToReturn = Character.getNumericValue(diceToReturnInput.charAt(i) - (6 - savedDice.size()));
            returnedDice.add(savedDice.get(indexOfDieToReturn));
        }
        removeSameDice(savedDice, returnedDice);
        return returnedDice;
    }

    public void removeSameDice(ArrayList<Dice> diceListToRemoveFrom, ArrayList<Dice> diceList){
        for (Dice die : diceList){
            if(diceListToRemoveFrom.contains(die)){
                diceListToRemoveFrom.remove(die);
            }
        }
    }


    public String getName() {
        return this.name;
    }


    public Player getPlayer() {
        return this.player;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public class TooManyRollsException extends Throwable {}
}
