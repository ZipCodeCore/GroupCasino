package io.zipcoder.casino.DiceGamesTests.YahtzeeTests;

import io.zipcoder.casino.DiceGames.Yahtzee;
import io.zipcoder.casino.Player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ScoreAndSettingsTest {

    Yahtzee scoreTester;

    @Before
    public void doThisFirst(){
        scoreTester = new Yahtzee(new Player("1234", "password"));
    }


    @Test
    public void scoreTest1(){
        Assert.assertEquals(0, scoreTester.getPoints());
        scoreTester.updateScore(10);
        Assert.assertEquals(10, scoreTester.getPoints());
    }

    @Test
    public void scoreTest2(){
        Assert.assertEquals(0, scoreTester.getPoints());
        scoreTester.updateScore(15);
        scoreTester.updateScore(5);
        Assert.assertEquals(20, scoreTester.getPoints());
    }

    @Test
    public void resetGameTest(){
        scoreTester.updateScore(10);
        scoreTester.roll5Dice();
        Assert.assertNotEquals(0, scoreTester.getPoints());

        scoreTester.resetGame();

        String[] expectedOptions = {" ","1s", "2s", "3s", "4s", "5s", "6s", "3 of a kind", "4 of a kind",
                "Small Straight", "Large Straight", "Full House", "Yahtzee", "Chance"};

        Assert.assertEquals(0, scoreTester.getPoints());
        Assert.assertArrayEquals(expectedOptions, scoreTester.getAvailableOptions());
    }
}
