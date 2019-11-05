package io.zipcoder.casino.GamePieces;

import java.util.Random;

public class RouletteSpinner {
    private Random random = new Random();

    public Integer winningNumber() {
        return random.nextInt(37);
    }

}
