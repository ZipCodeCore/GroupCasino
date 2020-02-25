package io.zipcoder.casino.player;

import java.util.Random;

public class CrapsPlayer extends DicePlayer {
    @Override
    public int rollDice() {
        Random random = new Random();
        return 2 * (random.nextInt(6) + 1);
    }
}
