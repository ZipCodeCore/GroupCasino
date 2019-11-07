package io.zipcoder.casino.DiceGamesTests.YahtzeeTests;

import io.zipcoder.casino.DiceGames.Dice;
import io.zipcoder.casino.DiceGames.Yahtzee;
import io.zipcoder.casino.Player.Player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class YahtzeeDiceTest {

    private Yahtzee roller;
    private Player user;

    @Before
    public void doThisFirst(){
        user = new Player("123","pw");
        roller = new Yahtzee(user);
    }

    @Test
    public void diceRollTest(){
        roller.roll5Dice();
        Dice[] diceValues = roller.getMyDice();

        for(int i = 0; i < diceValues.length; i++){
            Assert.assertTrue(diceValues[i].getValue() < 7);
            Assert.assertTrue(diceValues[i].getValue() > 0);
        }
    }

    @Test
    public void checkForKeepsTest(){
        roller.roll5Dice();
        Dice[] dice = roller.getMyDice();

        for(int i = 0; i < roller.getMyDice().length; i++){
            Assert.assertFalse(dice[i].isKept());
        }
        dice[1].setKept(true);
        Assert.assertTrue(dice[1].isKept());
    }

    @Test
    public void resetDiceTest(){
        roller.roll5Dice();
        Dice[] dice = roller.getMyDice();

        for(int i = 0; i < roller.getMyDice().length; i++){
            dice[i].setKept(true);
            Assert.assertTrue(dice[i].isKept());
        }

        roller.resetDice();

        for(int i = 0; i < roller.getMyDice().length; i++){
            Assert.assertFalse(dice[i].isKept());
        }
    }
}
