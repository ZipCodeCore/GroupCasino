package io.zipcoder.casino.gameTools;

public class Dice {
    public Integer rollDice() {
        int sum = 0;
        for (int i = 0; i < 2 ; i++) {
            sum += (int) (Math.random()*6+1);
        };
        return sum;
    }
}
