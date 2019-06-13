package io.zipcoder.casino.player;

import io.zipcoder.casino.Dice;


public class CrapsPlayer extends Player implements GamblerInterface {



    public Integer roll() {
        Dice dice = new Dice();

        return dice.rollDice();
    }

    public void bet(Double bet) {
    }

    public void betType(String betType) {

    }

    public void cashout() {

    }

    public void displayAccoutBal() {

    }
}
