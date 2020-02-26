package io.zipcoder.casino.GameClasses.DiceGames;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    @Test
    public void rollAndSumWith2Dice() {
        Dice dice = new Dice(2);
        Integer expected = dice.rollAndSum(dice);
        Integer actual = 0;
        Assert.assertTrue(expected>=2 && expected <=12);
    }

    @Test
    public void rollAndSumWith1Die() {
        Dice dice = new Dice(1);
        Integer expected = dice.rollAndSum(dice);
        Integer actual = 0;
        Assert.assertTrue(expected>=1 && expected <=6);
    }
    @Test
    public void rollAndSumWith7Dice() {
        Dice dice = new Dice(7);
        Integer expected = dice.rollAndSum(dice);
        Integer actual = 0;
        Assert.assertTrue(expected>=7 && expected <=6*7);
    }

    @Test
    public void rollAndSumWithSeed() {
        Dice dice = new Dice(2);
        Integer expected = dice.rollAndSumWithSeed(dice,3);
        Integer actual = 6;
        Assert.assertEquals(actual,expected);
    }
}