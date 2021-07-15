package com.github.zipcodewilmington.casino.games.CrapsGame;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class CrapsGame implements GameInterface {
    Dice dice = new Dice();
    int num1;
    int num2;
    boolean x;

    public int firstRoll() {
        num1 = dice.rollingTheDice();

        System.out.println("Your first roll is " + num1 + "!");
        return num1;
    }

    public int secondRoll() {
        num2 = dice.rollingTheDice();

        System.out.println("Your second roll is " + num2 + "!");
        return num2;
    }

    public boolean sumOfRoll(int num1, int num2) {
        boolean x;
        if (num1==7||num1==11){
            if(num2==7||num2==11)
                return true; System.out.println("Cash Out! You've won!");}
        if(num1!=11&&num1!=7){
            if(num2!=11&&num2!=7)
                return true;
        } System.out.println("Turn in your chips... Better luck next time!");return false;
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

    }
}


