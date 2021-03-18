package io.zipcoder.casino;

import java.util.Random;

abstract class DiceGame implements GamblingGame {


    public Integer diceRollSum(int i) {
        Random random = new Random();
        Integer thisToss = 0;

        while (i >= 1) {
            int randomGen = (random.nextInt(6) + 1);
            thisToss += randomGen;
            i--;
        }
        return thisToss;
    }
}
