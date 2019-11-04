package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class CrapsPlayer implements GamblingPlayer {
    private String name;
    private double wallet;
    private Player player;


    public CrapsPlayer(Player player) {
        this.wallet = player.getWallet();
        this.name = player.getName();
    }

    public void bet(double amount) {
        this.wallet = wallet - amount;
    }

    public ArrayList<Dice> rollDice(int numberOfDice) {

        ArrayList<Dice> rolledDice = new ArrayList<>();

        for (int i = 0; i < numberOfDice; i++) {
            Dice die = new Dice(1);
            int dieValue = die.rollDice();
            rolledDice.add(new Dice(1, dieValue));
        }
        return rolledDice;
    }

    public int sumOfRoll(ArrayList<Dice> diceRoll){
        return diceRoll.get(0).getValue() + diceRoll.get(1).getValue();
    }


    public void collect(double amount) {
        this.wallet += amount;
    }

    public String getName(){
        return name;
    }

    public void collectCraps(double amount, double winningsMultiplier){
        this.wallet += (amount*winningsMultiplier);
    }

    public double getWallet(){
        return this.wallet;
    }
}
