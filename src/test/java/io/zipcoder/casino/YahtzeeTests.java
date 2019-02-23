package io.zipcoder.casino;

import io.zipcoder.casino.DiceGame.Dice;
import io.zipcoder.casino.DiceGame.Yahtzee;
import io.zipcoder.casino.DiceGame.YahtzeePlayer;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeMap;

public class YahtzeeTests {

    @Test
    public void YahtzeeConstructorTest(){
        // Given
        String expectedYahtzeePlayerName = "Cara";
        Player player = new Player(expectedYahtzeePlayerName, 1000.00);
        TreeMap<String, Integer> expectedScoreCard = new TreeMap<String, Integer>();
        ArrayList<Dice> expectedSavedDice = new ArrayList<Dice>();
        ArrayList<Dice> expectedRolledDice = new ArrayList<Dice>();
        int expectedRollNumber = 1;
        int expectedScore = 0;

        // When
        Yahtzee yahtzee = new Yahtzee(player);
        String actualYahtzeePlayerName = yahtzee.getYahtzeePlayer().getName();
        TreeMap<String, Integer> actualScoreCard = yahtzee.getScoreCard();
        ArrayList<Dice> actualSavedDice = yahtzee.getSavedDice();
        ArrayList<Dice> actualRolledDice = yahtzee.getRolledDice();
        int actualRollNumber = yahtzee.getRollNumber();
        int actualScore = yahtzee.getScore();

        // Then
        Assert.assertEquals(expectedYahtzeePlayerName, actualYahtzeePlayerName);
        Assert.assertEquals(expectedScoreCard, actualScoreCard);
        Assert.assertEquals(expectedSavedDice, actualSavedDice);
        Assert.assertEquals(expectedRolledDice, actualRolledDice);
        Assert.assertEquals(expectedRollNumber, actualRollNumber);
        Assert.assertEquals(expectedScore, actualScore);
    }


    @Test
    public void getAllDiceTest(){
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);

        Dice d1 = new Dice(1, 3);
        Dice d2 = new Dice(1, 2);
        Dice d3 = new Dice(1, 1);
        Dice d4 = new Dice(1, 4);
        Dice d5 = new Dice(1, 5);

        yahtzee.getRolledDice().add(d1);
        yahtzee.getRolledDice().add(d2);
        yahtzee.getRolledDice().add(d3);

        yahtzee.getSavedDice().add(d4);
        yahtzee.getSavedDice().add(d5);

        ArrayList<Dice> expectedAllDice = new ArrayList<Dice>();
        expectedAllDice.add(d1);
        expectedAllDice.add(d2);
        expectedAllDice.add(d3);
        expectedAllDice.add(d4);
        expectedAllDice.add(d5);

        // When
        ArrayList<Dice> actualAllDice = yahtzee.getAllDice(yahtzee.getRolledDice(), yahtzee.getSavedDice());

        // Then
        Assert.assertEquals(expectedAllDice, actualAllDice);
    }


    @Test
    public void getScoreForCategoryTest(){
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);

        Dice d1 = new Dice(1, 1);
        Dice d2 = new Dice(1, 2);
        Dice d3 = new Dice(1, 3);
        Dice d4 = new Dice(1, 4);
        Dice d5 = new Dice(1, 5);
        Dice d6 = new Dice(1, 6);

        // Aces
        ArrayList<Dice> acesDice = new ArrayList<Dice>();
        acesDice.add(d1);
        acesDice.add(d2);
        acesDice.add(d3);
        acesDice.add(d1);
        acesDice.add(d1);
        int expectedAcesScore = 3;

        // Twos
        ArrayList<Dice> twosDice = new ArrayList<Dice>();
        twosDice.add(d2);
        twosDice.add(d6);
        twosDice.add(d5);
        twosDice.add(d2);
        twosDice.add(d1);
        int expectedTwosScore = 4;

        // Threes
        ArrayList<Dice> threesDice = new ArrayList<Dice>();
        threesDice.add(d3);
        threesDice.add(d3);
        threesDice.add(d4);
        threesDice.add(d3);
        threesDice.add(d3);
        int expectedThreesScore = 12;

        // Fours
        ArrayList<Dice> foursDice = new ArrayList<Dice>();
        foursDice.add(d4);
        foursDice.add(d1);
        foursDice.add(d4);
        foursDice.add(d5);
        foursDice.add(d2);
        int expectedFoursScore = 8;

        // Fives
        ArrayList<Dice> fivesDice = new ArrayList<Dice>();
        fivesDice.add(d5);
        fivesDice.add(d5);
        fivesDice.add(d5);
        fivesDice.add(d5);
        fivesDice.add(d5);
        int expectedFivesScore = 25;

        // Sixes
        ArrayList<Dice> sixesDice = new ArrayList<Dice>();
        sixesDice.add(d1);
        sixesDice.add(d6);
        sixesDice.add(d6);
        sixesDice.add(d6);
        sixesDice.add(d1);
        int expectedSixesScore = 18;

        // Three of a Kind
        ArrayList<Dice> threeOfAKindDice = new ArrayList<Dice>();
        threeOfAKindDice.add(d5);
        threeOfAKindDice.add(d4);
        threeOfAKindDice.add(d5);
        threeOfAKindDice.add(d5);
        threeOfAKindDice.add(d2);
        int expectedThreeOfAKindScore = 21;
        int expectedNotThreeOfAKindScore = 0;

        // Four of a Kind
        ArrayList<Dice> fourOfAKindDice = new ArrayList<Dice>();
        fourOfAKindDice.add(d1);
        fourOfAKindDice.add(d1);
        fourOfAKindDice.add(d1);
        fourOfAKindDice.add(d6);
        fourOfAKindDice.add(d1);
        int expectedFourOfAKindScore = 10;
        int expectedNotFourOfAKindScore = 0;

        // Small Straight
        ArrayList<Dice> smallStraightDice = new ArrayList<Dice>();
        smallStraightDice.add(d3);
        smallStraightDice.add(d2);
        smallStraightDice.add(d1);
        smallStraightDice.add(d3);
        smallStraightDice.add(d4);
        int expectedSmallStraightScore = 30;
        int expectedNotSmallStraightScore = 0;

        // Large Straight
        ArrayList<Dice> largeStraightDice = new ArrayList<Dice>();
        largeStraightDice.add(d2);
        largeStraightDice.add(d3);
        largeStraightDice.add(d4);
        largeStraightDice.add(d6);
        largeStraightDice.add(d5);
        int expectedLargeStraight = 40;
        int expectedNotLargeStraight = 0;

        // Yahtzee
        ArrayList<Dice> yahtzeeDice = new ArrayList<Dice>();
        yahtzeeDice.add(d2);
        yahtzeeDice.add(d2);
        yahtzeeDice.add(d2);
        yahtzeeDice.add(d2);
        yahtzeeDice.add(d2);
        int expectedYahtzeeScore = 50;
        int expectedNotYahtzeeScore = 0;

        // Chance
        ArrayList<Dice> chanceDice = new ArrayList<Dice>();
        chanceDice.add(d1);
        chanceDice.add(d2);
        chanceDice.add(d5);
        chanceDice.add(d6);
        chanceDice.add(d6);
        int expectedChanceScore = 20;


        // When
        int actualAcesScore = yahtzee.getScoreForCategory("Aces", acesDice);
        int actualTwosScore = yahtzee.getScoreForCategory("Twos", twosDice);
        int actualThreesScore = yahtzee.getScoreForCategory("Threes", threesDice);
        int actualFoursScore = yahtzee.getScoreForCategory("Fours", foursDice);
        int actualFivesScore = yahtzee.getScoreForCategory("Fives", fivesDice);
        int actualSixesScore = yahtzee.getScoreForCategory("Sixes", sixesDice);

        int actualThreeOfAKindScore = yahtzee.getScoreForCategory("3 of a kind", threeOfAKindDice);
        int actualNotThreeOfAKindScore = yahtzee.getScoreForCategory("3 of a kind", twosDice);

        int actualFourOfAKindScore = yahtzee.getScoreForCategory("4 of a kind", fourOfAKindDice);
        int actualNotFourOfAKindScore = yahtzee.getScoreForCategory("4 of a kind", foursDice);

        int actualSmallStraightScore = yahtzee.getScoreForCategory("Small straight", smallStraightDice);
        int actualNotSmallStraightScore = yahtzee.getScoreForCategory("Small straight", fourOfAKindDice);

        int actualLargeStraightScore = yahtzee.getScoreForCategory("Large straight", largeStraightDice);
        int actualNotLargeStraightScore = yahtzee.getScoreForCategory("Large straight", smallStraightDice);

        int actualYahtzeeScore = yahtzee.getScoreForCategory("Yahtzee", yahtzeeDice);
        int actualNotYahtzeeScore = yahtzee.getScoreForCategory("Yahtzee", fourOfAKindDice);

        int actualChanceScore = yahtzee.getScoreForCategory("Chance", chanceDice);


        // Then
        Assert.assertEquals(expectedAcesScore, actualAcesScore);
        Assert.assertEquals(expectedTwosScore, actualTwosScore);
        Assert.assertEquals(expectedThreesScore, actualThreesScore);
        Assert.assertEquals(expectedFoursScore, actualFoursScore);
        Assert.assertEquals(expectedFivesScore, actualFivesScore);
        Assert.assertEquals(expectedSixesScore, actualSixesScore);

        Assert.assertEquals(expectedThreeOfAKindScore, actualThreeOfAKindScore);
        Assert.assertEquals(expectedNotThreeOfAKindScore,actualNotThreeOfAKindScore);

        Assert.assertEquals(expectedFourOfAKindScore, actualFourOfAKindScore);
        Assert.assertEquals(expectedNotFourOfAKindScore, actualNotFourOfAKindScore);

        Assert.assertEquals(expectedSmallStraightScore, actualSmallStraightScore);
        Assert.assertEquals(expectedNotSmallStraightScore, actualNotSmallStraightScore);

        Assert.assertEquals(expectedLargeStraight, actualLargeStraightScore);
        Assert.assertEquals(expectedNotLargeStraight, actualNotLargeStraightScore);

        Assert.assertEquals(expectedYahtzeeScore, actualYahtzeeScore);
        Assert.assertEquals(expectedNotYahtzeeScore, actualNotYahtzeeScore);

        Assert.assertEquals(expectedChanceScore, actualChanceScore);
    }



}
