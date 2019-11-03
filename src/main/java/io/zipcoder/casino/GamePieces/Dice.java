package io.zipcoder.casino.GamePieces;

import java.util.Random;

public class Dice {

    Integer rollDice(Integer numberOfDice){
        Random r = new Random();
        Integer sum = 0;
        for(int i = 0; i < numberOfDice; i++){
            sum += r.nextInt(6) + 1;
        }
        return sum;
    }
}
