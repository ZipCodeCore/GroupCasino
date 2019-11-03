package io.zipcoder.casino.GamePieces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    @Test
    public void rollDiceTest1() {
        Integer numberOfDice = 2;
        Dice dice = new Dice();
        Integer expected = dice.rollDice(numberOfDice);
        Assert.assertTrue(expected >= numberOfDice && expected <= numberOfDice * 6);
    }

    @Test
    public void rollDiceTest2() {
        Integer numberOfDice = 5;
        Dice dice = new Dice();
        Integer expected = dice.rollDice(numberOfDice);
        Assert.assertTrue(expected >= numberOfDice && expected <= numberOfDice * 6);
    }

    @Test
    public void rollDiceTest3() {
        Integer numberOfDice = 300;
        Dice dice = new Dice();
        Integer expected = dice.rollDice(numberOfDice);
        Assert.assertTrue(expected >= numberOfDice && expected <= numberOfDice * 6);
    }
}