package io.zipcoder.casino.DiceGamesTests.YahtzeeTests;

import io.zipcoder.casino.DiceGames.Yahtzee;
import io.zipcoder.casino.Player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiceRollTest {

    Yahtzee roller;
    Player user;

    @Before
    public void doThisFirst(){
        user = new Player("123","pw");
        roller = new Yahtzee(user);
    }

    @Test
    public void Test1(){
        roller.roll5Dice();
        roller.getMyDice();
        Integer[] diceValues = roller.getDiceValues();

        for(Integer s: diceValues){
            Assert.assertTrue(s < 7);
            Assert.assertTrue(s > 0);
        }
        Assert.assertNotEquals(1,0);
    }
}
