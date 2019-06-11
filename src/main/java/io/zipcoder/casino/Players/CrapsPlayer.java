package io.zipcoder.casino.Players;

import io.zipcoder.casino.Dice;

public class CrapsPlayer extends Gambler {

    public Integer roll() {
        Dice dice = new Dice();

        return dice.rollDice();
    }

}
