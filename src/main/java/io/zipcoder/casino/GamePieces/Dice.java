package io.zipcoder.casino.GamePieces;

import io.zipcoder.casino.utilities.Console;

import java.util.HashMap;
import java.util.Random;

public class Dice {
    Console console = new Console(System.in, System.out);

    public Integer rollDice(Integer numberOfDice){
        Random r = new Random();
        Integer sum = 0;
        for(int i = 0; i < numberOfDice; i++){
            sum += r.nextInt(6) + 1;
        }
        return sum;
    }

    public String diceArt(Integer roll){
        HashMap<Integer,String> diceMap = new HashMap<>();
        diceMap.put(1,"+-----+\n" +
                "|     |\n" +
                "|  o  |\n" +
                "|     |\n" +
                "+-----+");
        diceMap.put(2,"+-----+\n" +
                "| o   |\n" +
                "|     |\n" +
                "|   o |\n" +
                "+-----+");
        diceMap.put(3,"+-----+\n" +
                "| o   |\n" +
                "|  o  |\n" +
                "|   o |\n" +
                "+-----+");
        diceMap.put(4,"+-----+\n" +
                "| o   |\n" +
                "|  o  |\n" +
                "|   o |\n" +
                "+-----+");
        diceMap.put(5,"+-----+\n" +
                "| o o |\n" +
                "|  o  |\n" +
                "| o o |\n" +
                "+-----+");
        diceMap.put(6,"+-----+\n" +
                "| o o |\n" +
                "| o o |\n" +
                "| o o |\n" +
                "+-----+");
        return diceMap.get(roll);
    }
}
