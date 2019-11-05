package io.zipcoder.casino.GamePieces;

import io.zipcoder.casino.utilities.Console;

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

    public void diceArt(Integer roll){
        switch(roll){
            case 1:
                console.println("+-----+\n" +
                        "|     |\n" +
                        "|  o  |\n" +
                        "|     |\n" +
                        "+-----+");
                break;
            case 2:
                console.println("+-----+\n" +
                        "| o   |\n" +
                        "|     |\n" +
                        "|   o |\n" +
                        "+-----+");
                break;
            case 3:
                console.println("+-----+\n" +
                        "| o   |\n" +
                        "|  o  |\n" +
                        "|   o |\n" +
                        "+-----+");
                break;
            case 4:
                console.println("+-----+\n" +
                        "| o o |\n" +
                        "|     |\n" +
                        "| o o |\n" +
                        "+-----+");
                break;
            case 5:
                console.println("+-----+\n" +
                        "| o o |\n" +
                        "|  o  |\n" +
                        "| o o |\n" +
                        "+-----+");
                break;
            case 6:
                console.println("+-----+\n" +
                        "| o o |\n" +
                        "| o o |\n" +
                        "| o o |\n" +
                        "+-----+");
                break;
        }
    }
}
