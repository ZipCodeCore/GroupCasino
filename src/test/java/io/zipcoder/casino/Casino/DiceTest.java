package io.zipcoder.casino.Casino;

import io.zipcoder.casino.CardsAndDice.Dice;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DiceTest {

    private Dice dice = new Dice();

    @Test
    public void rollTest() {
        // Given an ArrayList that stores output from the roll method (and an expected mininum of 1 and maximum of 6)
        ArrayList<Integer> ints = new ArrayList<>();
        Integer expectedMinimum = 1;
        Integer expectedMaximum = 6;

        // When the roll function is called 1000 times and the variables stored in the int arraylist
        for (int i = 0; i < 1000; i++) {
            ints.add(dice.roll());
        }

        // When we retrieve the minimum and maximum values
        Integer actualMinimum = ints.get(0);
        Integer actualMaximum = ints.get(0);
        for (int i = 1; i < ints.size(); i++) {
            if (ints.get(i) < actualMinimum) {
                actualMinimum = ints.get(i);
            }
            if (ints.get(i) > actualMaximum) {
                actualMaximum = ints.get(i);
            }
        }

        // Then we expect the mins and maxes to match
        Assert.assertEquals(expectedMaximum, actualMaximum);
        Assert.assertEquals(expectedMinimum, actualMinimum);
    }
}
