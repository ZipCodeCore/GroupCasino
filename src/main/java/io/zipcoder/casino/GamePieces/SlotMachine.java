package io.zipcoder.casino.GamePieces;

import io.zipcoder.casino.Games.GamblingGame;
import io.zipcoder.casino.utilities.Console;

import java.util.Random;
import java.util.Arrays;

public class SlotMachine {

    Console console = new Console(System.in, System.out);

    Integer[][] slotMachine = new Integer[2][2];

    public static Integer randNum(){
        Random random = new Random();
        Integer randInt = random.nextInt(10);
        return randInt;
    }


    public Integer[][] createMachine() {
        for (int i = 0; i < slotMachine.length; i++){
            for(int j = 0; j < slotMachine.length; j++){
                slotMachine[i][j] = randNum();
            }
        } return slotMachine;
    }

    public void printSlots(){
        console.println(slotMachine.toString());
    }
}
