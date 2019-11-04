package io.zipcoder.casino;

import io.zipcoder.casino.DiceGame.Dice;
import io.zipcoder.casino.DiceGame.Yahtzee;
import io.zipcoder.casino.DiceGame.YahtzeePlayer;
import org.junit.Assert;
import org.junit.Test;

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
    public void YahtzeeConstructorTest() {
        // Given
        String expectedYahtzeePlayerName = "Cara";
        Player player = new Player(expectedYahtzeePlayerName, 1000.00);
        ArrayList<Dice> expectedSavedDice = new ArrayList<>();
        ArrayList<Dice> expectedRolledDice = new ArrayList<>();
        int expectedScore = 0;

        // When
        Yahtzee yahtzee = new Yahtzee(player);
        String actualYahtzeePlayerName = yahtzee.getYahtzeePlayer().getName();
        ArrayList<Dice> actualSavedDice = yahtzee.getSavedDice();
        ArrayList<Dice> actualRolledDice = yahtzee.getRolledDice();
        int actualScore = yahtzee.getScore();

        // Then
        Assert.assertEquals(expectedYahtzeePlayerName, actualYahtzeePlayerName);
        Assert.assertEquals(expectedSavedDice, actualSavedDice);
        Assert.assertEquals(expectedRolledDice, actualRolledDice);
        Assert.assertEquals(expectedScore, actualScore);
    }


    @Test
    public void getAllDiceTest() {
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
    public void getScoreForCategoryTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);

        // Aces
        ArrayList<Dice> acesDice = new ArrayList<>();
        acesDice.add(d1);
        acesDice.add(d2);
        acesDice.add(d3);
        acesDice.add(d1);
        acesDice.add(d1);
        int expectedAcesScore = 3;

        // Twos
        ArrayList<Dice> twosDice = new ArrayList<>();
        twosDice.add(d2);
        twosDice.add(d6);
        twosDice.add(d5);
        twosDice.add(d2);
        twosDice.add(d1);
        int expectedTwosScore = 4;

        // Threes
        ArrayList<Dice> threesDice = new ArrayList<>();
        threesDice.add(d3);
        threesDice.add(d3);
        threesDice.add(d4);
        threesDice.add(d3);
        threesDice.add(d3);
        int expectedThreesScore = 12;

        // Fours
        ArrayList<Dice> foursDice = new ArrayList<>();
        foursDice.add(d4);
        foursDice.add(d1);
        foursDice.add(d4);
        foursDice.add(d5);
        foursDice.add(d2);
        int expectedFoursScore = 8;

        // Fives
        ArrayList<Dice> fivesDice = new ArrayList<>();
        fivesDice.add(d5);
        fivesDice.add(d5);
        fivesDice.add(d5);
        fivesDice.add(d5);
        fivesDice.add(d5);
        int expectedFivesScore = 25;

        // Sixes
        ArrayList<Dice> sixesDice = new ArrayList<>();
        sixesDice.add(d1);
        sixesDice.add(d6);
        sixesDice.add(d6);
        sixesDice.add(d6);
        sixesDice.add(d1);
        int expectedSixesScore = 18;

        // Three of a Kind
        ArrayList<Dice> threeOfAKindDice = new ArrayList<>();
        threeOfAKindDice.add(d5);
        threeOfAKindDice.add(d4);
        threeOfAKindDice.add(d5);
        threeOfAKindDice.add(d5);
        threeOfAKindDice.add(d2);
        int expectedThreeOfAKindScore = 21;
        int expectedNotThreeOfAKindScore = 0;

        // Four of a Kind
        ArrayList<Dice> fourOfAKindDice = new ArrayList<>();
        fourOfAKindDice.add(d1);
        fourOfAKindDice.add(d1);
        fourOfAKindDice.add(d1);
        fourOfAKindDice.add(d6);
        fourOfAKindDice.add(d1);
        int expectedFourOfAKindScore = 10;
        int expectedNotFourOfAKindScore = 0;

        // Small Straight
        ArrayList<Dice> smallStraightDice = new ArrayList<>();
        smallStraightDice.add(d3);
        smallStraightDice.add(d2);
        smallStraightDice.add(d1);
        smallStraightDice.add(d3);
        smallStraightDice.add(d4);
        int expectedSmallStraightScore = 30;
        int expectedNotSmallStraightScore = 0;

        // Large Straight
        ArrayList<Dice> largeStraightDice = new ArrayList<>();
        largeStraightDice.add(d2);
        largeStraightDice.add(d3);
        largeStraightDice.add(d4);
        largeStraightDice.add(d6);
        largeStraightDice.add(d5);
        int expectedLargeStraight = 40;
        int expectedNotLargeStraight = 0;

        // Yahtzee
        ArrayList<Dice> yahtzeeDice = new ArrayList<>();
        yahtzeeDice.add(d2);
        yahtzeeDice.add(d2);
        yahtzeeDice.add(d2);
        yahtzeeDice.add(d2);
        yahtzeeDice.add(d2);
        int expectedYahtzeeScore = 50;
        int expectedNotYahtzeeScore = 0;

        // Chance
        ArrayList<Dice> chanceDice = new ArrayList<>();
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
        Assert.assertEquals(expectedNotThreeOfAKindScore, actualNotThreeOfAKindScore);

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
    public void scoreAcesTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWith2Aces = new ArrayList<>();
        diceWith2Aces.add(d1);
        diceWith2Aces.add(d2);
        diceWith2Aces.add(d3);
        diceWith2Aces.add(d1);
        diceWith2Aces.add(d5);
        int expectedScore1 = 2;

        ArrayList<Dice> diceWith0Aces = new ArrayList<>();
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
    public void scoreTwosTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWith4Twos = new ArrayList<>();
        diceWith4Twos.add(d2);
        diceWith4Twos.add(d3);
        diceWith4Twos.add(d2);
        diceWith4Twos.add(d2);
        diceWith4Twos.add(d2);
        int expectedScore1 = 8;

        ArrayList<Dice> diceWith0Twos = new ArrayList<>();
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
    public void scoreThreesTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWith3Threes = new ArrayList<>();
        diceWith3Threes.add(d3);
        diceWith3Threes.add(d2);
        diceWith3Threes.add(d2);
        diceWith3Threes.add(d3);
        diceWith3Threes.add(d3);
        int expectedScore1 = 9;

        ArrayList<Dice> diceWith0Threes = new ArrayList<>();
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
    public void scoreFoursTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWith4Fours = new ArrayList<>();
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
    public void scoreFivesTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWith3Fives = new ArrayList<>();
        diceWith3Fives.add(d1);
        diceWith3Fives.add(d2);
        diceWith3Fives.add(d5);
        diceWith3Fives.add(d5);
        diceWith3Fives.add(d5);
        int expectedScore1 = 15;

        ArrayList<Dice> diceWith0Fives = new ArrayList<>();
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
    public void scoreSixesTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWith4Sixes = new ArrayList<>();
        diceWith4Sixes.add(d6);
        diceWith4Sixes.add(d6);
        diceWith4Sixes.add(d1);
        diceWith4Sixes.add(d6);
        diceWith4Sixes.add(d6);
        int expectedScore1 = 24;

        ArrayList<Dice> diceWith0Sixes = new ArrayList<>();
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
    public void hasThreeOfAKindTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithThreeOfAKind = new ArrayList<>();
        diceWithThreeOfAKind.add(d3);
        diceWithThreeOfAKind.add(d2);
        diceWithThreeOfAKind.add(d3);
        diceWithThreeOfAKind.add(d4);
        diceWithThreeOfAKind.add(d3);

        ArrayList<Dice> diceWithoutThreeOfAKind = new ArrayList<>();
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

        ArrayList<Dice> diceWithFourOfAKind = new ArrayList<>();
        diceWithFourOfAKind.add(d2);
        diceWithFourOfAKind.add(d2);
        diceWithFourOfAKind.add(d6);
        diceWithFourOfAKind.add(d2);
        diceWithFourOfAKind.add(d2);

        ArrayList<Dice> diceWithoutFourOfAKind = new ArrayList<>();
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

        ArrayList<Dice> diceWithFullHouse = new ArrayList<>();
        diceWithFullHouse.add(d3);
        diceWithFullHouse.add(d6);
        diceWithFullHouse.add(d6);
        diceWithFullHouse.add(d3);
        diceWithFullHouse.add(d3);

        ArrayList<Dice> diceWithoutFullHouse = new ArrayList<>();
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

        ArrayList<Dice> diceWithSmallStraight = new ArrayList<>();
        diceWithSmallStraight.add(d1);
        diceWithSmallStraight.add(d4);
        diceWithSmallStraight.add(d6);
        diceWithSmallStraight.add(d2);
        diceWithSmallStraight.add(d3);

        ArrayList<Dice> diceWithoutSmallStraight = new ArrayList<>();
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
    public void hasLargeStraightTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithLargeStraight = new ArrayList<>();
        diceWithLargeStraight.add(d6);
        diceWithLargeStraight.add(d2);
        diceWithLargeStraight.add(d5);
        diceWithLargeStraight.add(d3);
        diceWithLargeStraight.add(d4);

        ArrayList<Dice> diceWithoutLargeStraight = new ArrayList<>();
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
    public void hasYahtzeeTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithYahtzee = new ArrayList<>();
        diceWithYahtzee.add(d2);
        diceWithYahtzee.add(d2);
        diceWithYahtzee.add(d2);
        diceWithYahtzee.add(d2);
        diceWithYahtzee.add(d2);

        ArrayList<Dice> diceWithoutYahtzee = new ArrayList<>();
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
    public void scoreThreeOfAKindTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithThreeOfAKind = new ArrayList<>();
        diceWithThreeOfAKind.add(d5);
        diceWithThreeOfAKind.add(d5);
        diceWithThreeOfAKind.add(d3);
        diceWithThreeOfAKind.add(d4);
        diceWithThreeOfAKind.add(d5);
        int expectedScore1 = 22;

        ArrayList<Dice> diceWithoutThreeOfAKind = new ArrayList<>();
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
    public void scoreFourOfAKindTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithFourOfAKind = new ArrayList<>();
        diceWithFourOfAKind.add(d5);
        diceWithFourOfAKind.add(d3);
        diceWithFourOfAKind.add(d5);
        diceWithFourOfAKind.add(d5);
        diceWithFourOfAKind.add(d5);
        int expectedScore1 = 23;

        ArrayList<Dice> diceWithoutFourOfAKind = new ArrayList<>();
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
    public void scoreFullHouseTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceWithFullHouse = new ArrayList<>();
        diceWithFullHouse.add(d5);
        diceWithFullHouse.add(d2);
        diceWithFullHouse.add(d5);
        diceWithFullHouse.add(d2);
        diceWithFullHouse.add(d5);
        int expectedScore1 = 25;

        ArrayList<Dice> diceWithoutFullHouse = new ArrayList<>();
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
    public void scoreSmallStraightTest() {
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
    public void scoreLargeStraightTest() {
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
    public void scoreYahtzeeTest() {
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
    public void diceCounterTest() {
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

    @Test
    public void markScoreCardTest() {
        //Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);
        TreeMap<String, Integer> scoreCard = yahtzee.getScoreCard();

        // Mark Aces
        ArrayList<Dice> rollAces = new ArrayList<>();
        rollAces.add(d1);
        rollAces.add(d2);
        rollAces.add(d3);
        rollAces.add(d1);
        rollAces.add(d1);
        int expectedAces = 3;

        // Mark Twos
        ArrayList<Dice> rollTwos = new ArrayList<>();
        rollTwos.add(d2);
        rollTwos.add(d2);
        rollTwos.add(d3);
        rollTwos.add(d2);
        rollTwos.add(d1);
        int expectedTwos = 6;

        // Mark Threes
        ArrayList<Dice> rollThrees = new ArrayList<>();
        rollThrees.add(d3);
        rollThrees.add(d2);
        rollThrees.add(d3);
        rollThrees.add(d3);
        rollThrees.add(d3);
        int expectedThrees = 12;

        // Mark Fours
        ArrayList<Dice> rollFours = new ArrayList<>();
        rollFours.add(d3);
        rollFours.add(d4);
        rollFours.add(d1);
        rollFours.add(d5);
        rollFours.add(d4);
        int expectedFours = 8;

        // Mark Fives
        ArrayList<Dice> rollFives = new ArrayList<>();
        rollFives.add(d1);
        rollFives.add(d5);
        rollFives.add(d5);
        rollFives.add(d5);
        rollFives.add(d5);
        int expectedFives = 20;

        // Mark Sixes
        ArrayList<Dice> rollSixes = new ArrayList<>();
        rollSixes.add(d6);
        rollSixes.add(d1);
        rollSixes.add(d4);
        rollSixes.add(d6);
        rollSixes.add(d6);
        int expectedSixes = 18;

        // Mark Three of A Kind
        ArrayList<Dice> rollThreeOfAKind = new ArrayList<>();
        rollThreeOfAKind.add(d4);
        rollThreeOfAKind.add(d4);
        rollThreeOfAKind.add(d3);
        rollThreeOfAKind.add(d6);
        rollThreeOfAKind.add(d4);
        int expectedThreeOfAKind = 21;

        // Mark Four of A Kind
        ArrayList<Dice> rollFourOfAKind = new ArrayList<>();
        rollFourOfAKind.add(d6);
        rollFourOfAKind.add(d6);
        rollFourOfAKind.add(d1);
        rollFourOfAKind.add(d6);
        rollFourOfAKind.add(d6);
        int expectedFourOfAKind = 25;

        // Mark Full House
        ArrayList<Dice> rollFullHouse = new ArrayList<>();
        rollFullHouse.add(d3);
        rollFullHouse.add(d3);
        rollFullHouse.add(d4);
        rollFullHouse.add(d3);
        rollFullHouse.add(d4);
        int expectedFullHouse = 25;

        // Mark Small Straight
        ArrayList<Dice> rollSmallStraight = new ArrayList<>();
        rollSmallStraight.add(d2);
        rollSmallStraight.add(d3);
        rollSmallStraight.add(d5);
        rollSmallStraight.add(d3);
        rollSmallStraight.add(d4);
        int expectedSmallStraight = 30;

        // Mark Large Straight
        ArrayList<Dice> rollLargeStraight = new ArrayList<>();
        rollLargeStraight.add(d6);
        rollLargeStraight.add(d5);
        rollLargeStraight.add(d4);
        rollLargeStraight.add(d2);
        rollLargeStraight.add(d3);
        int expectedLargeStraight = 40;

        // Mark Yahtzee
        ArrayList<Dice> rollYahtzee = new ArrayList<>();
        rollYahtzee.add(d1);
        rollYahtzee.add(d1);
        rollYahtzee.add(d1);
        rollYahtzee.add(d1);
        rollYahtzee.add(d1);
        int expectedYahtzee = 50;

        // Mark Chance
        ArrayList<Dice> rollChance = new ArrayList<>();
        rollChance.add(d5);
        rollChance.add(d6);
        rollChance.add(d5);
        rollChance.add(d4);
        rollChance.add(d4);
        int expectedChance = 24;


        // When
        yahtzee.markScoreCard("Aces", rollAces);
        int actualAces = yahtzee.getScoreCard().get("aces");

        yahtzee.markScoreCard("Twos", rollTwos);
        int actualTwos = yahtzee.getScoreCard().get("twos");

        yahtzee.markScoreCard("Threes", rollThrees);
        int actualThrees = yahtzee.getScoreCard().get("threes");

        yahtzee.markScoreCard("Fours", rollFours);
        int actualFours = yahtzee.getScoreCard().get("fours");

        yahtzee.markScoreCard("Fives", rollFives);
        int actualFives = yahtzee.getScoreCard().get("fives");

        yahtzee.markScoreCard("Sixes", rollSixes);
        int actualSixes = yahtzee.getScoreCard().get("sixes");

        yahtzee.markScoreCard("3 of a kind", rollThreeOfAKind);
        int actualThreeOfAKind = yahtzee.getScoreCard().get("3 of a kind");

        yahtzee.markScoreCard("4 of a kind", rollFourOfAKind);
        int actualFourOfAKind = yahtzee.getScoreCard().get("4 of a kind");

        yahtzee.markScoreCard("Full House", rollFullHouse);
        int actualFullHouse = yahtzee.getScoreCard().get("full house");

        yahtzee.markScoreCard("Small straight", rollSmallStraight);
        int actualSmallStraight = yahtzee.getScoreCard().get("small straight");

        yahtzee.markScoreCard("Large straight", rollLargeStraight);
        int actualLargeStraight = yahtzee.getScoreCard().get("large straight");

        yahtzee.markScoreCard("Yahtzee", rollYahtzee);
        int actualYahtzee = yahtzee.getScoreCard().get("yahtzee");

        yahtzee.markScoreCard("Chance", rollChance);
        int actualChance = yahtzee.getScoreCard().get("chance");


        // Then
        Assert.assertEquals(expectedAces, actualAces);
        Assert.assertEquals(expectedTwos, actualTwos);
        Assert.assertEquals(expectedThrees, actualThrees);
        Assert.assertEquals(expectedFours, actualFours);
        Assert.assertEquals(expectedFives, actualFives);
        Assert.assertEquals(expectedSixes, actualSixes);
        Assert.assertEquals(expectedThreeOfAKind, actualThreeOfAKind);
        Assert.assertEquals(expectedFourOfAKind, actualFourOfAKind);
        Assert.assertEquals(expectedFullHouse, actualFullHouse);
        Assert.assertEquals(expectedSmallStraight, actualSmallStraight);
        Assert.assertEquals(expectedLargeStraight, actualLargeStraight);
        Assert.assertEquals(expectedYahtzee, actualYahtzee);
        Assert.assertEquals(expectedChance, actualChance);
    }


    @Test
    public void listOfDiceToStringTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> diceList1 = new ArrayList<>();
        diceList1.add(d1);
        diceList1.add(d2);
        diceList1.add(d3);
        diceList1.add(d4);
        diceList1.add(d5);

        String expected1 = "  ⚀  |  ⚁  |  ⚂  |  ⚃  |  ⚄  |";

        ArrayList<Dice> diceList2 = new ArrayList<>();
        diceList2.add(d6);
        diceList2.add(d2);

        String expected2 = "  ⚅  |  ⚁  |";

        // When
        String actual1 = yahtzee.listOfDiceToDiceString(diceList1);
        String actual2 = yahtzee.listOfDiceToDiceString(diceList2);

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getCurrentDiceStringTest() {
        // Given
        Player player = new Player("Cara", 1000.00);
        Yahtzee yahtzee = new Yahtzee(player);

        ArrayList<Dice> rolledDice = new ArrayList<>();
        rolledDice.add(d4);
        rolledDice.add(d6);

        ArrayList<Dice> savedDice = new ArrayList<>();
        savedDice.add(d2);
        savedDice.add(d2);
        savedDice.add(d5);

        String expected = "\n|------------------------------------------|\n" +
                "|            |  1  |  2  |  3  |  4  |  5  |\n" +
                "|------------------------------------------|\n" +
                "|Rolled Dice |  ⚃  |  ⚅  |     |     |     |\n" +
                "|------------------------------------------|\n" +
                "| Saved Dice |     |     |  ⚁  |  ⚁  |  ⚄  |\n" +
                "|------------------------------------------|\n";


        // When
        String actual = yahtzee.getCurrentDiceString(rolledDice, savedDice);

        // Then
        Assert.assertEquals(expected, actual);
        System.out.println(actual);

    }


    @Test
    public void setUpScoreCardTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);

        // When
        TreeMap<String, Integer> actualScoreCard = yahtzee.setUpScoreCard();
        Integer actualAces = actualScoreCard.get("aces");
        Integer actualTwos = actualScoreCard.get("twos");
        Integer actualThrees = actualScoreCard.get("threes");
        Integer actualFours = actualScoreCard.get("fours");
        Integer actualFives = actualScoreCard.get("fives");
        Integer actualSixes = actualScoreCard.get("sixes");
        Integer actualUpperBonus = actualScoreCard.get("upper bonus");
        Integer actualThreeOfAKind = actualScoreCard.get("3 of a kind");
        Integer actualFourOfAKind = actualScoreCard.get("4 of a kind");
        Integer actualFullHouse = actualScoreCard.get("full house");
        Integer actualSmallStraight = actualScoreCard.get("small straight");
        Integer actualLargeStraight = actualScoreCard.get("large straight");
        Integer actualYahtzee = actualScoreCard.get("yahtzee");
        Integer actualChance = actualScoreCard.get("chance");
        Integer actualTotalScore = actualScoreCard.get("total score");

        // Then
        Assert.assertNull(actualAces);
        Assert.assertNull(actualTwos);
        Assert.assertNull(actualThrees);
        Assert.assertNull(actualFours);
        Assert.assertNull(actualFives);
        Assert.assertNull(actualSixes);
        Assert.assertNull(actualUpperBonus);
        Assert.assertNull(actualThreeOfAKind);
        Assert.assertNull(actualFourOfAKind);
        Assert.assertNull(actualFullHouse);
        Assert.assertNull(actualSmallStraight);
        Assert.assertNull(actualLargeStraight);
        Assert.assertNull(actualYahtzee);
        Assert.assertNull(actualChance);
        Assert.assertNull(actualTotalScore);

    }


    @Test
    public void getScoreCardStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);

        String expected = "" +
                "|---------------------------------|\n" +
                "  Category         |  Score        \n" +
                "|---------------------------------|\n" +
                "   Aces            |\n" +
                "|---------------------------------|\n" +
                "   Twos            |\n" +
                "|---------------------------------|\n" +
                "   Threes          |\n" +
                "|---------------------------------|\n" +
                "   Fours           |\n" +
                "|---------------------------------|\n" +
                "   Fives           |\n" +
                "|---------------------------------|\n" +
                "   Sixes           |\n" +
                "|---------------------------------|\n" +
                "   Upper Bonus     |\n" +
                "|---------------------------------|\n" +
                "   3 of a Kind     |\n" +
                "|---------------------------------|\n" +
                "   4 of a Kind     |\n" +
                "|---------------------------------|\n" +
                "   Full House      |\n" +
                "|---------------------------------|\n" +
                "   Small Straight  |\n" +
                "|---------------------------------|\n" +
                "   Large Straight  |\n" +
                "|---------------------------------|\n" +
                "   Yahtzee         |\n" +
                "|---------------------------------|\n" +
                "   Chance          |\n" +
                "|---------------------------------|\n" +
                "   Total Score     |\n" +
                "|---------------------------------|\n";

        System.out.println(expected);

        // When
        String actual = yahtzee.getScoreCardString();

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getAcesScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   Aces            |\n";
        String expected2 = "   Aces            |    3\n";

        // When
        String actual1 = yahtzee.getAcesScoreString();

        yahtzee.getScoreCard().put("aces", 3);
        String actual2 = yahtzee.getAcesScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getTwosScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   Twos            |\n";
        String expected2 = "   Twos            |    8\n";

        // When
        String actual1 = yahtzee.getTwosScoreString();

        yahtzee.getScoreCard().put("twos", 8);
        String actual2 = yahtzee.getTwosScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getThreesScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   Threes          |\n";
        String expected2 = "   Threes          |    12\n";

        // When
        String actual1 = yahtzee.getThreesScoreString();

        yahtzee.getScoreCard().put("threes", 12);
        String actual2 = yahtzee.getThreesScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getFoursScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   Fours           |\n";
        String expected2 = "   Fours           |    8\n";

        // When
        String actual1 = yahtzee.getFoursScoreString();

        yahtzee.getScoreCard().put("fours", 8);
        String actual2 = yahtzee.getFoursScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getFivesScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   Fives           |\n";
        String expected2 = "   Fives           |    0\n";

        // When
        String actual1 = yahtzee.getFivesScoreString();

        yahtzee.getScoreCard().put("fives", 0);
        String actual2 = yahtzee.getFivesScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getSixesScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   Sixes           |\n";
        String expected2 = "   Sixes           |    24\n";

        // When
        String actual1 = yahtzee.getSixesScoreString();

        yahtzee.getScoreCard().put("sixes", 24);
        String actual2 = yahtzee.getSixesScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getUpperBonusScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   Upper Bonus     |\n";
        String expected2 = "   Upper Bonus     |    35\n";

        // When
        String actual1 = yahtzee.getUpperBonusScoreString();

        yahtzee.getScoreCard().put("upper bonus", 35);
        String actual2 = yahtzee.getUpperBonusScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getThreeOfAKindScoreString() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   3 of a Kind     |\n";
        String expected2 = "   3 of a Kind     |    22\n";

        // When
        String actual1 = yahtzee.getThreeOfAKindScoreString();

        yahtzee.getScoreCard().put("3 of a kind", 22);
        String actual2 = yahtzee.getThreeOfAKindScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getFourOfAKindScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   4 of a Kind     |\n";
        String expected2 = "   4 of a Kind     |    20\n";

        // When
        String actual1 = yahtzee.getFourOfAKindScoreString();

        yahtzee.getScoreCard().put("4 of a kind", 20);
        String actual2 = yahtzee.getFourOfAKindScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getFullHouseScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   Full House      |\n";
        String expected2 = "   Full House      |    25\n";

        // When
        String actual1 = yahtzee.getFullHouseScoreString();

        yahtzee.getScoreCard().put("full house", 25);
        String actual2 = yahtzee.getFullHouseScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getSmallStraightScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   Small Straight  |\n";
        String expected2 = "   Small Straight  |    30\n";

        // When
        String actual1 = yahtzee.getSmallStraightScoreString();

        yahtzee.getScoreCard().put("small straight", 30);
        String actual2 = yahtzee.getSmallStraightScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getLargeStraightScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   Large Straight  |\n";
        String expected2 = "   Large Straight  |    40\n";

        // When
        String actual1 = yahtzee.getLargeStraightScoreString();

        yahtzee.getScoreCard().put("large straight", 40);
        String actual2 = yahtzee.getLargeStraightScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getYahtzeeScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   Yahtzee         |\n";
        String expected2 = "   Yahtzee         |    50\n";

        // When
        String actual1 = yahtzee.getYahtzeeScoreString();

        yahtzee.getScoreCard().put("yahtzee", 50);
        String actual2 = yahtzee.getYahtzeeScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getChanceScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   Chance          |\n";
        String expected2 = "   Chance          |    23\n";

        // When
        String actual1 = yahtzee.getChanceScoreString();

        yahtzee.getScoreCard().put("chance", 23);
        String actual2 = yahtzee.getChanceScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getTotalScoreStringTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected1 = "   Total Score     |\n";
        String expected2 = "   Total Score     |    200\n";

        // When
        String actual1 = yahtzee.getTotalScoreString();

        yahtzee.getScoreCard().put("total score", 200);
        String actual2 = yahtzee.getTotalScoreString();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getUpperSectionTotalTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee1 = new Yahtzee(player);
        Yahtzee yahtzee2 = new Yahtzee(player);
        Yahtzee yahtzee3 = new Yahtzee(player);
        int expected1 = 63;
        int expected2 = 62;
        int expected3 = 68;

        // When
        yahtzee1.getScoreCard().put("aces", 3);
        yahtzee1.getScoreCard().put("twos", 2);
        yahtzee1.getScoreCard().put("threes", 12);
        yahtzee1.getScoreCard().put("fours", 8);
        yahtzee1.getScoreCard().put("fives", 20);
        yahtzee1.getScoreCard().put("sixes", 18);
        int actual1 = yahtzee1.getUpperSectionTotal(yahtzee1.getScoreCard());

        yahtzee2.getScoreCard().put("aces", 2);
        yahtzee2.getScoreCard().put("twos", 2);
        yahtzee2.getScoreCard().put("threes", 12);
        yahtzee2.getScoreCard().put("fours", 8);
        yahtzee2.getScoreCard().put("fives", 20);
        yahtzee2.getScoreCard().put("sixes", 18);
        int actual2 = yahtzee2.getUpperSectionTotal(yahtzee2.getScoreCard());

        yahtzee3.getScoreCard().put("aces", 2);
        yahtzee3.getScoreCard().put("twos", 2);
        yahtzee3.getScoreCard().put("threes", 12);
        yahtzee3.getScoreCard().put("fours", 8);
        yahtzee3.getScoreCard().put("fives", 20);
        yahtzee3.getScoreCard().put("sixes", 24);
        int actual3 = yahtzee3.getUpperSectionTotal(yahtzee3.getScoreCard());

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }


    @Test
    public void upperSectionBonusTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee1 = new Yahtzee(player);
        Yahtzee yahtzee2 = new Yahtzee(player);
        Yahtzee yahtzee3 = new Yahtzee(player);
        int expected1 = 35;
        int expected2 = 0;
        int expected3 = 35;

        // When
        yahtzee1.getScoreCard().put("aces", 3);
        yahtzee1.getScoreCard().put("twos", 2);
        yahtzee1.getScoreCard().put("threes", 12);
        yahtzee1.getScoreCard().put("fours", 8);
        yahtzee1.getScoreCard().put("fives", 20);
        yahtzee1.getScoreCard().put("sixes", 18);
        int actual1 = yahtzee1.upperSectionBonus(yahtzee1.getScoreCard());

        yahtzee2.getScoreCard().put("aces", 2);
        yahtzee2.getScoreCard().put("twos", 2);
        yahtzee2.getScoreCard().put("threes", 12);
        yahtzee2.getScoreCard().put("fours", 8);
        yahtzee2.getScoreCard().put("fives", 20);
        yahtzee2.getScoreCard().put("sixes", 18);
        int actual2 = yahtzee2.upperSectionBonus(yahtzee2.getScoreCard());

        yahtzee3.getScoreCard().put("aces", 2);
        yahtzee3.getScoreCard().put("twos", 2);
        yahtzee3.getScoreCard().put("threes", 12);
        yahtzee3.getScoreCard().put("fours", 8);
        yahtzee3.getScoreCard().put("fives", 20);
        yahtzee3.getScoreCard().put("sixes", 24);
        int actual3 = yahtzee3.upperSectionBonus(yahtzee3.getScoreCard());

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void getLowerSectionTotalTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        int expected = 210;

        // When
        yahtzee.getScoreCard().put("3 of a kind", 20);
        yahtzee.getScoreCard().put("4 of a kind", 22);
        yahtzee.getScoreCard().put("full house", 25);
        yahtzee.getScoreCard().put("small straight", 30);
        yahtzee.getScoreCard().put("large straight", 40);
        yahtzee.getScoreCard().put("yahtzee", 50);
        yahtzee.getScoreCard().put("chance", 23);
        int actual = yahtzee.getLowerSectionTotal(yahtzee.getScoreCard());

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getTotalScoreTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);

        yahtzee.getScoreCard().put("aces", 3);
        yahtzee.getScoreCard().put("twos", 2);
        yahtzee.getScoreCard().put("threes", 12);
        yahtzee.getScoreCard().put("fours", 8);
        yahtzee.getScoreCard().put("fives", 20);
        yahtzee.getScoreCard().put("sixes", 18);
        yahtzee.getScoreCard().put("upper bonus", 35);
        yahtzee.getScoreCard().put("3 of a kind", 20);
        yahtzee.getScoreCard().put("4 of a kind", 22);
        yahtzee.getScoreCard().put("full house", 25);
        yahtzee.getScoreCard().put("small straight", 30);
        yahtzee.getScoreCard().put("large straight", 40);
        yahtzee.getScoreCard().put("yahtzee", 50);
        yahtzee.getScoreCard().put("chance", 23);

        int expected = 308;

        // When
        int actual = yahtzee.getTotalScore(yahtzee.getScoreCard());

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void upperSectionScoresCompleteTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);

        // When
        boolean expectedFalse1 = yahtzee.upperSectionScoresComplete();

        yahtzee.getScoreCard().put("aces", 3);
        yahtzee.getScoreCard().put("twos", 2);
        yahtzee.getScoreCard().put("threes", 12);

        boolean expectedFalse2 = yahtzee.upperSectionScoresComplete();

        yahtzee.getScoreCard().put("fours", 8);
        yahtzee.getScoreCard().put("fives", 20);
        yahtzee.getScoreCard().put("sixes", 18);

        boolean expectedTrue = yahtzee.upperSectionScoresComplete();

        // Then
        Assert.assertFalse(expectedFalse1);
        Assert.assertFalse(expectedFalse2);
        Assert.assertTrue(expectedTrue);
    }


    @Test
    public void scorecardCompleteTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);

        // When
        boolean expectedFalse = yahtzee.scorecardComplete();

        yahtzee.getScoreCard().put("aces", 3);
        yahtzee.getScoreCard().put("twos", 2);
        yahtzee.getScoreCard().put("threes", 12);
        yahtzee.getScoreCard().put("fours", 8);
        yahtzee.getScoreCard().put("fives", 20);
        yahtzee.getScoreCard().put("sixes", 18);

        boolean expectedFalse2 = yahtzee.scorecardComplete();

        yahtzee.getScoreCard().put("3 of a kind", 20);
        yahtzee.getScoreCard().put("4 of a kind", 22);
        yahtzee.getScoreCard().put("full house", 25);
        yahtzee.getScoreCard().put("small straight", 30);
        yahtzee.getScoreCard().put("large straight", 40);
        yahtzee.getScoreCard().put("yahtzee", 50);
        yahtzee.getScoreCard().put("chance", 23);

        boolean expectedTrue = yahtzee.scorecardComplete();

        // Then
        Assert.assertFalse(expectedFalse);
        Assert.assertFalse(expectedFalse2);
        Assert.assertTrue(expectedTrue);
    }


    @Test
    public void isValidCategoryTest() {
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);

        String validCategory = "full house";
        String invalidCategory = "small straihgt";

        // When
        boolean actualTrue = yahtzee.isValidCategory(validCategory);
        boolean actualFalse = yahtzee.isValidCategory(invalidCategory);

        // Then
        Assert.assertTrue(actualTrue);
        Assert.assertFalse(actualFalse);
    }


    @Test
    public void welcomeToYahtzeeStringTest(){
        // Given
        Player player = new Player("Cara", 1000.0);
        Yahtzee yahtzee = new Yahtzee(player);
        String expected = "\n⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅\n" +
                "      ___       __   __         ___    ___  __                   ___ __  ___  ___   /\n" +
                "|  | |__  |    /  ` /  \\  |\\/| |__      |  /  \\    \\ /  /\\  |__|  |   / |__  |__   / \n" +
                "|/\\| |___ |___ \\__, \\__/  |  | |___     |  \\__/     |  /~~\\ |  |  |  /_ |___ |___ .  \n\n" +
                "⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅\n";

        // When
        String actual = yahtzee.welcomeToYahtzeeString();

        // Then
        Assert.assertEquals(expected, actual);
    }


}
