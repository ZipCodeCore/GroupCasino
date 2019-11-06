package io.zipcoder.casino.DiceGamesTests.YahtzeeTests;

import io.zipcoder.casino.DiceGames.Yahtzee;
import io.zipcoder.casino.Player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EvaluationTest {

    Yahtzee detect;

    @Before
    public void doThisFirst(){

        detect = new Yahtzee(new Player("1234", "password"));

    }

    @Test
    public void getFacePointsTest(){
        Integer[] thisIsMyDice = {1,1,1,1,5};
        int actual = detect.checkForFaces(thisIsMyDice, 1);
        int expected = 4;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getFacePointsTest2(){
        Integer[] thisIsMyDice2 = {1,5,5,5,5};
        int actual2 = detect.checkForFaces(thisIsMyDice2, 5);
        int expected2 = 20;
        Assert.assertEquals(expected2,actual2);
    }

    @Test
    public void get3Kind(){
        Integer[] thisIsMyDice = {1,1,1,6,5};
        int expected = 14;
        int actual = detect.checkForSameKind(thisIsMyDice, 3);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void get3Kind2(){
        Integer[] thisIsMyDice = {1,5,2,2,2};
        int expected = 12;
        int actual = detect.checkForSameKind(thisIsMyDice, 3);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void get4Kind(){
        Integer[] thisIsMyDice = {4,4,4,4,1};
        int expected = 17;
        int actual = detect.checkForSameKind(thisIsMyDice, 4);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void get4Kind2(){
        Integer[] thisIsMyDice = {2,4,2,2,1};
        int expected2 = 0;
        int actual2 = detect.checkForSameKind(thisIsMyDice, 4);
        Assert.assertEquals(expected2,actual2);
    }

    @Test
    public void getFullHouse(){
        Integer[] thisIsMyDice = {4,1,4,4,1};
        int expected = 25;
        int actual = detect.checkForFullHouse(thisIsMyDice);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getFullHouse2(){
        Integer[] thisIsMyDice = {4,2,1,4,2};
        int expected = 0;
        int actual = detect.checkForFullHouse(thisIsMyDice);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getSmallStraight(){
        Integer[] thisIsMyDice = {3,2,2,4,2};
        int expected = 0;
        int actual = detect.checkForStraight(thisIsMyDice, 4);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getSmallStraight2(){
        Integer[] thisIsMyDice = {3,2,5,4,6};
        int expected = 30;
        int actual = detect.checkForStraight(thisIsMyDice, 4);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getLargeStraight(){
        Integer[] thisIsMyDice = {3,2,5,4,2};
        int expected = 0;
        int actual = detect.checkForStraight(thisIsMyDice, 5);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getLargeStraight2(){
        Integer[] thisIsMyDice = {3,2,5,4,6};
        int expected = 40;
        int actual = detect.checkForStraight(thisIsMyDice, 5);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getYahtzee(){
        Integer[] thisIsMyDice = {3,3,3,3,3};
        int expected = 50;
        int actual = detect.checkForYahtzee(thisIsMyDice);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getYahtzee2(){
        Integer[] thisIsMyDice = {2,3,3,3,3};
        int expected = 0;
        int actual = detect.checkForYahtzee(thisIsMyDice);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getChanceValueTest(){
        Integer[] thisIsMyDice = {2,1,1,1,5};
        int actual = detect.chance(thisIsMyDice);
        int expected = 10;
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getChanceValueTest2(){
        Integer[] thisIsMyDice2 = {1,5,4,5,5};
        int actual2 = detect.chance(thisIsMyDice2);
        int expected2 = 20;
        Assert.assertEquals(expected2,actual2);
    }
}
