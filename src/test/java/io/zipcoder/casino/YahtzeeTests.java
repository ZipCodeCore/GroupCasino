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

    Dice d1 = new Dice(1, 1);
    Dice d2 = new Dice(1, 2);
    Dice d3 = new Dice(1, 3);
    Dice d4 = new Dice(1, 4);
    Dice d5 = new Dice(1, 5);
    Dice d6 = new Dice(1, 6);

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


    @Test
    public void scoreAcesTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWith2Aces = new ArrayList<Dice>();
        diceWith2Aces.add(d1);
        diceWith2Aces.add(d2);
        diceWith2Aces.add(d3);
        diceWith2Aces.add(d1);
        diceWith2Aces.add(d5);
        int expectedScore1 = 2;

        ArrayList<Dice> diceWith0Aces = new ArrayList<Dice>();
        diceWith0Aces.add(d5);
        diceWith0Aces.add(d2);
        diceWith0Aces.add(d3);
        diceWith0Aces.add(d4);
        diceWith0Aces.add(d6);
        int expectedScore2 = 0;

        // When
        int actualScore1 = yahtzee.scoreAces(diceWith2Aces);
        int actualScore2 = yahtzee.scoreAces(diceWith0Aces);

        // Then
        Assert.assertEquals(expectedScore1, actualScore1);
        Assert.assertEquals(expectedScore2, actualScore2);
    }


    @Test
    public void scoreTwosTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWith4Twos = new ArrayList<Dice>();
        diceWith4Twos.add(d2);
        diceWith4Twos.add(d3);
        diceWith4Twos.add(d2);
        diceWith4Twos.add(d2);
        diceWith4Twos.add(d2);
        int expectedScore1 = 8;

        ArrayList<Dice> diceWith0Twos = new ArrayList<Dice>();
        diceWith0Twos.add(d5);
        diceWith0Twos.add(d6);
        diceWith0Twos.add(d1);
        diceWith0Twos.add(d3);
        diceWith0Twos.add(d4);
        int expectedScore2 = 0;

        // When
        int actualScore1 = yahtzee.scoreTwos(diceWith4Twos);
        int actualScore2 = yahtzee.scoreTwos(diceWith0Twos);

        // Then
        Assert.assertEquals(expectedScore1, actualScore1);
        Assert.assertEquals(expectedScore2, actualScore2);
    }


    @Test
    public void scoreThreesTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWith3Threes = new ArrayList<Dice>();
        diceWith3Threes.add(d3);
        diceWith3Threes.add(d2);
        diceWith3Threes.add(d2);
        diceWith3Threes.add(d3);
        diceWith3Threes.add(d3);
        int expectedScore1 = 9;

        ArrayList<Dice> diceWith0Threes = new ArrayList<Dice>();
        diceWith0Threes.add(d1);
        diceWith0Threes.add(d2);
        diceWith0Threes.add(d4);
        diceWith0Threes.add(d5);
        diceWith0Threes.add(d6);
        int expectedScore2 = 0;

        // When
        int actualScore1 = yahtzee.scoreThrees(diceWith3Threes);
        int actualScore2 = yahtzee.scoreThrees(diceWith0Threes);

        // Then
        Assert.assertEquals(expectedScore1, actualScore1);
        Assert.assertEquals(expectedScore2, actualScore2);
    }


    @Test
    public void scoreFoursTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        Dice d1 = new Dice(1, 1);
        Dice d2 = new Dice(1, 2);
        Dice d3 = new Dice(1, 3);
        Dice d4 = new Dice(1, 4);
        Dice d5 = new Dice(1, 5);
        Dice d6 = new Dice(1, 6);

        ArrayList<Dice> diceWith4Fours = new ArrayList<Dice>();
        diceWith4Fours.add(d4);
        diceWith4Fours.add(d2);
        diceWith4Fours.add(d4);
        diceWith4Fours.add(d4);
        diceWith4Fours.add(d4);
        int expectedScore1 = 16;

        ArrayList<Dice> diceWith0Fours = new ArrayList<Dice>();
        diceWith0Fours.add(d1);
        diceWith0Fours.add(d2);
        diceWith0Fours.add(d3);
        diceWith0Fours.add(d5);
        diceWith0Fours.add(d6);
        int expectedScore2 = 0;

        // When
        int actualScore1 = yahtzee.scoreFours(diceWith4Fours);
        int actualScore2 = yahtzee.scoreFours(diceWith0Fours);

        // Then
        Assert.assertEquals(expectedScore1, actualScore1);
        Assert.assertEquals(expectedScore2, actualScore2);
    }


    @Test
    public void scoreFivesTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        Dice d1 = new Dice(1, 1);
        Dice d2 = new Dice(1, 2);
        Dice d3 = new Dice(1, 3);
        Dice d4 = new Dice(1, 4);
        Dice d5 = new Dice(1, 5);
        Dice d6 = new Dice(1, 6);

        ArrayList<Dice> diceWith3Fives = new ArrayList<Dice>();
        diceWith3Fives.add(d1);
        diceWith3Fives.add(d2);
        diceWith3Fives.add(d5);
        diceWith3Fives.add(d5);
        diceWith3Fives.add(d5);
        int expectedScore1 = 15;

        ArrayList<Dice> diceWith0Fives = new ArrayList<Dice>();
        diceWith0Fives.add(d1);
        diceWith0Fives.add(d2);
        diceWith0Fives.add(d3);
        diceWith0Fives.add(d4);
        diceWith0Fives.add(d6);
        int expectedScore2 = 0;

        // When
        int actualScore1 = yahtzee.scoreFives(diceWith3Fives);
        int actualScore2 = yahtzee.scoreFives(diceWith0Fives);

        // Then
        Assert.assertEquals(expectedScore1, actualScore1);
        Assert.assertEquals(expectedScore2, actualScore2);
    }


    @Test
    public void scoreSixesTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        Dice d1 = new Dice(1, 1);
        Dice d2 = new Dice(1, 2);
        Dice d3 = new Dice(1, 3);
        Dice d4 = new Dice(1, 4);
        Dice d5 = new Dice(1, 5);
        Dice d6 = new Dice(1, 6);

        ArrayList<Dice> diceWith4Sixes = new ArrayList<Dice>();
        diceWith4Sixes.add(d6);
        diceWith4Sixes.add(d6);
        diceWith4Sixes.add(d1);
        diceWith4Sixes.add(d6);
        diceWith4Sixes.add(d6);
        int expectedScore1 = 24;

        ArrayList<Dice> diceWith0Sixes = new ArrayList<Dice>();
        diceWith0Sixes.add(d1);
        diceWith0Sixes.add(d2);
        diceWith0Sixes.add(d3);
        diceWith0Sixes.add(d4);
        diceWith0Sixes.add(d5);
        int expectedScore2 = 0;

        // When
        int actualScore1 = yahtzee.scoreSixes(diceWith4Sixes);
        int actualScore2 = yahtzee.scoreSixes(diceWith0Sixes);

        // Then
        Assert.assertEquals(expectedScore1, actualScore1);
        Assert.assertEquals(expectedScore2, actualScore2);
    }


    @Test
    public void hasThreeOfAKindTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithThreeOfAKind = new ArrayList<Dice>();
        diceWithThreeOfAKind.add(d3);
        diceWithThreeOfAKind.add(d2);
        diceWithThreeOfAKind.add(d3);
        diceWithThreeOfAKind.add(d4);
        diceWithThreeOfAKind.add(d3);

        ArrayList<Dice> diceWithoutThreeOfAKind = new ArrayList<Dice>();
        diceWithoutThreeOfAKind.add(d1);
        diceWithoutThreeOfAKind.add(d2);
        diceWithoutThreeOfAKind.add(d3);
        diceWithoutThreeOfAKind.add(d4);
        diceWithoutThreeOfAKind.add(d3);

        // When
        boolean actualThreeOfAKind = yahtzee.hasThreeOfAKind(diceWithThreeOfAKind);
        boolean actualNotThreeOfAKind = yahtzee.hasThreeOfAKind(diceWithoutThreeOfAKind);

        // Then
        Assert.assertTrue(actualThreeOfAKind);
        Assert.assertFalse(actualNotThreeOfAKind);
    }


    @Test
    public void hasFourOfAKindTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithFourOfAKind = new ArrayList<Dice>();
        diceWithFourOfAKind.add(d2);
        diceWithFourOfAKind.add(d2);
        diceWithFourOfAKind.add(d6);
        diceWithFourOfAKind.add(d2);
        diceWithFourOfAKind.add(d2);

        ArrayList<Dice> diceWithoutFourOfAKind = new ArrayList<Dice>();
        diceWithoutFourOfAKind.add(d2);
        diceWithoutFourOfAKind.add(d3);
        diceWithoutFourOfAKind.add(d4);
        diceWithoutFourOfAKind.add(d2);
        diceWithoutFourOfAKind.add(d2);

        // When
        boolean actualFourOfAKind = yahtzee.hasFourOfAKind(diceWithFourOfAKind);
        boolean actualNotFourOfAKind = yahtzee.hasFourOfAKind(diceWithoutFourOfAKind);

        // Then
        Assert.assertTrue(actualFourOfAKind);
        Assert.assertFalse(actualNotFourOfAKind);
    }


    @Test
    public void hasFullHouseTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithFullHouse = new ArrayList<Dice>();
        diceWithFullHouse.add(d3);
        diceWithFullHouse.add(d6);
        diceWithFullHouse.add(d6);
        diceWithFullHouse.add(d3);
        diceWithFullHouse.add(d3);

        ArrayList<Dice> diceWithoutFullHouse = new ArrayList<Dice>();
        diceWithoutFullHouse.add(d3);
        diceWithoutFullHouse.add(d6);
        diceWithoutFullHouse.add(d6);
        diceWithoutFullHouse.add(d3);
        diceWithoutFullHouse.add(d2);

        // When
        boolean actualFullHouse = yahtzee.hasFullHouse(diceWithFullHouse);
        boolean actualNotFullHouse = yahtzee.hasFullHouse(diceWithoutFullHouse);

        // Then
        Assert.assertTrue(actualFullHouse);
        Assert.assertFalse(actualNotFullHouse);
    }


    @Test
    public void hasSmallStraightTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithSmallStraight = new ArrayList<Dice>();
        diceWithSmallStraight.add(d1);
        diceWithSmallStraight.add(d4);
        diceWithSmallStraight.add(d6);
        diceWithSmallStraight.add(d2);
        diceWithSmallStraight.add(d3);

        ArrayList<Dice> diceWithoutSmallStraight = new ArrayList<Dice>();
        diceWithoutSmallStraight.add(d1);
        diceWithoutSmallStraight.add(d2);
        diceWithoutSmallStraight.add(d3);
        diceWithoutSmallStraight.add(d5);
        diceWithoutSmallStraight.add(d6);

        // When
        boolean actualSmallStraight = yahtzee.hasSmallStraight(diceWithSmallStraight);
        boolean actualNotSmallStraight = yahtzee.hasSmallStraight(diceWithoutSmallStraight);

        // Then
        Assert.assertTrue(actualSmallStraight);
        Assert.assertFalse(actualNotSmallStraight);
    }


    @Test
    public void hasLargeStraightTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithLargeStraight = new ArrayList<Dice>();
        diceWithLargeStraight.add(d6);
        diceWithLargeStraight.add(d2);
        diceWithLargeStraight.add(d5);
        diceWithLargeStraight.add(d3);
        diceWithLargeStraight.add(d4);

        ArrayList<Dice> diceWithoutLargeStraight = new ArrayList<Dice>();
        diceWithoutLargeStraight.add(d6);
        diceWithoutLargeStraight.add(d2);
        diceWithoutLargeStraight.add(d4);
        diceWithoutLargeStraight.add(d3);
        diceWithoutLargeStraight.add(d1);

        // When
        boolean actualLargeStraight = yahtzee.hasLargeStraight(diceWithLargeStraight);
        boolean actualNotLargeStraight = yahtzee.hasLargeStraight(diceWithoutLargeStraight);

        // Then
        Assert.assertTrue(actualLargeStraight);
        Assert.assertFalse(actualNotLargeStraight);
    }


    @Test
    public void hasYahtzeeTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithYahtzee = new ArrayList<Dice>();
        diceWithYahtzee.add(d2);
        diceWithYahtzee.add(d2);
        diceWithYahtzee.add(d2);
        diceWithYahtzee.add(d2);
        diceWithYahtzee.add(d2);

        ArrayList<Dice> diceWithoutYahtzee = new ArrayList<Dice>();
        diceWithoutYahtzee.add(d2);
        diceWithoutYahtzee.add(d2);
        diceWithoutYahtzee.add(d2);
        diceWithoutYahtzee.add(d2);
        diceWithoutYahtzee.add(d1);

        // When
        boolean actualYahtzee = yahtzee.hasYahtzee(diceWithYahtzee);
        boolean actualNotYahtzee = yahtzee.hasYahtzee(diceWithoutYahtzee);

        // Then
        Assert.assertTrue(actualYahtzee);
        Assert.assertFalse(actualNotYahtzee);
    }


    @Test
    public void scoreThreeOfAKindTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithThreeOfAKind = new ArrayList<Dice>();
        diceWithThreeOfAKind.add(d5);
        diceWithThreeOfAKind.add(d5);
        diceWithThreeOfAKind.add(d3);
        diceWithThreeOfAKind.add(d4);
        diceWithThreeOfAKind.add(d5);
        int expectedScore1 = 22;

        ArrayList<Dice> diceWithoutThreeOfAKind = new ArrayList<Dice>();
        diceWithoutThreeOfAKind.add(d1);
        diceWithoutThreeOfAKind.add(d2);
        diceWithoutThreeOfAKind.add(d3);
        diceWithoutThreeOfAKind.add(d4);
        diceWithoutThreeOfAKind.add(d3);
        int expectedScore2 = 0;

         // When
        int actualScore1 = yahtzee.scoreThreeOfAKind(diceWithThreeOfAKind);
        int actualScore2 = yahtzee.scoreThreeOfAKind(diceWithoutThreeOfAKind);

        // Then
        Assert.assertEquals(expectedScore1, actualScore1);
        Assert.assertEquals(expectedScore2, actualScore2);
    }


    @Test
    public void scoreFourOfAKindTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithFourOfAKind = new ArrayList<Dice>();
        diceWithFourOfAKind.add(d5);
        diceWithFourOfAKind.add(d3);
        diceWithFourOfAKind.add(d5);
        diceWithFourOfAKind.add(d5);
        diceWithFourOfAKind.add(d5);
        int expectedScore1 = 23;

        ArrayList<Dice> diceWithoutFourOfAKind = new ArrayList<Dice>();
        diceWithoutFourOfAKind.add(d5);
        diceWithoutFourOfAKind.add(d3);
        diceWithoutFourOfAKind.add(d3);
        diceWithoutFourOfAKind.add(d5);
        diceWithoutFourOfAKind.add(d5);
        int expectedScore2 = 0;

        // When
        int actualScore1 = yahtzee.scoreFourOfAKind(diceWithFourOfAKind);
        int actualScore2 = yahtzee.scoreFourOfAKind(diceWithoutFourOfAKind);

        // Then
        Assert.assertEquals(expectedScore1, actualScore1);
        Assert.assertEquals(expectedScore2, actualScore2);
    }


    @Test
    public void scoreFullHouseTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithFullHouse = new ArrayList<Dice>();
        diceWithFullHouse.add(d5);
        diceWithFullHouse.add(d2);
        diceWithFullHouse.add(d5);
        diceWithFullHouse.add(d2);
        diceWithFullHouse.add(d5);
        int expectedScore1 = 25;

        ArrayList<Dice> diceWithoutFullHouse = new ArrayList<Dice>();
        diceWithoutFullHouse.add(d5);
        diceWithoutFullHouse.add(d2);
        diceWithoutFullHouse.add(d5);
        diceWithoutFullHouse.add(d3);
        diceWithoutFullHouse.add(d5);
        int expectedScore2 = 0;

        // When
        int actualScore1 = yahtzee.scoreFullHouse(diceWithFullHouse);
        int actualScore2 = yahtzee.scoreFullHouse(diceWithoutFullHouse);

        // Then
        Assert.assertEquals(expectedScore1, actualScore1);
        Assert.assertEquals(expectedScore2, actualScore2);
    }


    @Test
    public void scoreSmallStraightTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithSmallStraight1 = new ArrayList<Dice>();
        diceWithSmallStraight1.add(d1);
        diceWithSmallStraight1.add(d4);
        diceWithSmallStraight1.add(d6);
        diceWithSmallStraight1.add(d2);
        diceWithSmallStraight1.add(d3);
        int expectedScore1 = 30;

        ArrayList<Dice> diceWithSmallStraight2 = new ArrayList<Dice>();
        diceWithSmallStraight2.add(d5);
        diceWithSmallStraight2.add(d4);
        diceWithSmallStraight2.add(d3);
        diceWithSmallStraight2.add(d2);
        diceWithSmallStraight2.add(d3);
        int expectedScore2 = 30;

        ArrayList<Dice> diceWithSmallStraight3 = new ArrayList<Dice>();
        diceWithSmallStraight3.add(d1);
        diceWithSmallStraight3.add(d4);
        diceWithSmallStraight3.add(d6);
        diceWithSmallStraight3.add(d5);
        diceWithSmallStraight3.add(d3);
        int expectedScore3 = 30;

        ArrayList<Dice> diceWithoutSmallStraight = new ArrayList<Dice>();
        diceWithoutSmallStraight.add(d1);
        diceWithoutSmallStraight.add(d2);
        diceWithoutSmallStraight.add(d3);
        diceWithoutSmallStraight.add(d5);
        diceWithoutSmallStraight.add(d6);
        int expectedScore4 = 0;

        // When
        int actualScore1 = yahtzee.scoreSmallStraight(diceWithSmallStraight1);
        int actualScore2 = yahtzee.scoreSmallStraight(diceWithSmallStraight2);
        int actualScore3 = yahtzee.scoreSmallStraight(diceWithSmallStraight3);
        int actualScore4 = yahtzee.scoreSmallStraight(diceWithoutSmallStraight);

        // Then
        Assert.assertEquals(expectedScore1, actualScore1);
        Assert.assertEquals(expectedScore2, actualScore2);
        Assert.assertEquals(expectedScore3, actualScore3);
        Assert.assertEquals(expectedScore4, actualScore4);
    }


    @Test
    public void scoreLargeStraightTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithLargeStraight1 = new ArrayList<Dice>();
        diceWithLargeStraight1.add(d6);
        diceWithLargeStraight1.add(d2);
        diceWithLargeStraight1.add(d5);
        diceWithLargeStraight1.add(d3);
        diceWithLargeStraight1.add(d4);
        int expectedScore1 = 40;

        ArrayList<Dice> diceWithLargeStraight2 = new ArrayList<Dice>();
        diceWithLargeStraight2.add(d1);
        diceWithLargeStraight2.add(d2);
        diceWithLargeStraight2.add(d5);
        diceWithLargeStraight2.add(d3);
        diceWithLargeStraight2.add(d4);
        int expectedScore2 = 40;

        ArrayList<Dice> diceWithoutLargeStraight = new ArrayList<Dice>();
        diceWithoutLargeStraight.add(d6);
        diceWithoutLargeStraight.add(d2);
        diceWithoutLargeStraight.add(d4);
        diceWithoutLargeStraight.add(d3);
        diceWithoutLargeStraight.add(d1);
        int expectedScore3 = 0;

        // When
        int actualScore1 = yahtzee.scoreLargeStraight(diceWithLargeStraight1);
        int actualScore2 = yahtzee.scoreLargeStraight(diceWithLargeStraight2);
        int actualScore3 = yahtzee.scoreLargeStraight(diceWithoutLargeStraight);

        // Then
        Assert.assertEquals(expectedScore1, actualScore1);
        Assert.assertEquals(expectedScore2, actualScore2);
        Assert.assertEquals(expectedScore3, actualScore3);
    }


    @Test
    public void scoreYahtzeeTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithYahtzee = new ArrayList<Dice>();
        diceWithYahtzee.add(d4);
        diceWithYahtzee.add(d4);
        diceWithYahtzee.add(d4);
        diceWithYahtzee.add(d4);
        diceWithYahtzee.add(d4);
        int expectedScore1 = 50;

        ArrayList<Dice> diceWithoutYahtzee = new ArrayList<Dice>();
        diceWithoutYahtzee.add(d4);
        diceWithoutYahtzee.add(d4);
        diceWithoutYahtzee.add(d4);
        diceWithoutYahtzee.add(d4);
        diceWithoutYahtzee.add(d6);
        int expectedScore2 = 0;

        // When
        int actualScore1 = yahtzee.scoreYahtzee(diceWithYahtzee);
        int actualScore2 = yahtzee.scoreYahtzee(diceWithoutYahtzee);

        // Then
        Assert.assertEquals(expectedScore1, actualScore1);
        Assert.assertEquals(expectedScore2, actualScore2);
    }


    @Test
    public void diceCounterTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceToCount1 = new ArrayList<Dice>();
        diceToCount1.add(d1);
        diceToCount1.add(d2);
        diceToCount1.add(d3);
        diceToCount1.add(d4);
        diceToCount1.add(d5);
        Integer[] expected1 = {1, 1, 1, 1, 1, 0};

        ArrayList<Dice> diceToCount2 = new ArrayList<Dice>();
        diceToCount2.add(d6);
        diceToCount2.add(d6);
        diceToCount2.add(d6);
        diceToCount2.add(d6);
        diceToCount2.add(d6);
        Integer[] expected2 = {0, 0, 0, 0, 0, 5};

        ArrayList<Dice> diceToCount3 = new ArrayList<Dice>();
        diceToCount3.add(d3);
        diceToCount3.add(d2);
        diceToCount3.add(d3);
        diceToCount3.add(d2);
        diceToCount3.add(d3);
        Integer[] expected3 = {0, 2, 3, 0, 0, 0};

        // When
        Integer[] actual1 = yahtzee.countDice(diceToCount1);
        Integer[] actual2 = yahtzee.countDice(diceToCount2);
        Integer[] actual3 = yahtzee.countDice(diceToCount3);

        // Then
        Assert.assertArrayEquals(expected1, actual1);
        Assert.assertArrayEquals(expected2, actual2);
        Assert.assertArrayEquals(expected3, actual3);
    }


    @Test
    public void getSumOfDiceTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceToSum1 = new ArrayList<>();
        diceToSum1.add(d1);
        diceToSum1.add(d4);
        diceToSum1.add(d2);
        diceToSum1.add(d6);
        diceToSum1.add(d1);
        int expectedSum1 = 14;

        ArrayList<Dice> diceToSum2 = new ArrayList<>();
        diceToSum2.add(d6);
        diceToSum2.add(d3);
        diceToSum2.add(d6);
        diceToSum2.add(d4);
        diceToSum2.add(d6);
        int expectedSum2 = 25;

        // When
        int actualSum1 = yahtzee.getSumOfDice(diceToSum1);
        int actualSum2 = yahtzee.getSumOfDice(diceToSum2);

        // Then
        Assert.assertEquals(expectedSum1, actualSum1);
        Assert.assertEquals(expectedSum2, actualSum2);
    }
}
