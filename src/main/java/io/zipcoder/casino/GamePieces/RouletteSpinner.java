package io.zipcoder.casino.GamePieces;

import java.util.Random;

public class RouletteSpinner {
    private static Random random = new Random();

    public static Integer winningNumber() {
        return random.nextInt(37);
    }

}
