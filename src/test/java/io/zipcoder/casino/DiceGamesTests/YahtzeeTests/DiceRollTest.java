package io.zipcoder.casino.DiceGamesTests.YahtzeeTests;

import io.zipcoder.casino.DiceGames.Dice;
import io.zipcoder.casino.DiceGames.Yahtzee;
import io.zipcoder.casino.Player.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiceRollTest {

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
        roller.getMyDice();
        Integer[] diceValues = roller.getDiceValues();

        for(Integer s: diceValues){
            Assert.assertTrue(s < 7);
            Assert.assertTrue(s > 0);
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
    public void resetTest(){
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

    @After
    public void doThisLast(){
        
    }
}
