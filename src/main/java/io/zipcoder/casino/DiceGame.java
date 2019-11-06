package io.zipcoder.casino;

import java.util.Random;

public abstract class DiceGame extends GameObject {

    private Random randomNum;



    //Rolls any number of dice with any number of sides
    public static int roll (int numberOfDiceBeingRolled, int numOfSides)
    {
        Integer dieRoll1 = 0;
        for (int i = 1; i <= numberOfDiceBeingRolled; i++) {
            dieRoll1 += (int) (Math.random() * numOfSides + 1);
        }
        return dieRoll1;
    }

    //Rolls just one die with 6 sides
    public static int roll () {

        return roll(1,6);
    }



    public static int roll (int numberOfDiceBeingRolled){
        return roll(numberOfDiceBeingRolled, 6);
    }


}
