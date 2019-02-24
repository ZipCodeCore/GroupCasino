package io.zipcoder.casino;

import io.zipcoder.casino.DiceGame.Dice;
import io.zipcoder.casino.DiceGame.Yahtzee;
import io.zipcoder.casino.DiceGame.YahtzeePlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

public class YahtzeePlayerTests {

    Dice d1 = new Dice(1, 1);
    Dice d2 = new Dice(1, 2);
    Dice d3 = new Dice(1, 3);
    Dice d4 = new Dice(1, 4);
    Dice d5 = new Dice(1, 5);
    Dice d6 = new Dice(1, 6);

    @Test
    public void YahtzeePlayerConstructorTest(){
        // Given
        String expectedName = "Cara";
        Player expectedPlayer = new Player(expectedName, 1000.0);

        // When
        YahtzeePlayer yahtzeePlayer = new YahtzeePlayer(expectedPlayer);
        Player actualPlayer = yahtzeePlayer.getPlayer();
        String actualName = yahtzeePlayer.getName();

        // Then
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPlayer, actualPlayer);
    }


    @Test
    public void rollDiceTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        YahtzeePlayer yahtzeePlayer = new YahtzeePlayer(player);
        int expected = 5;

        // When
        ArrayList<Dice> rolledDice = yahtzeePlayer.rollDice(5);
        int actual = rolledDice.size();

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void saveDiceTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        YahtzeePlayer yahtzeePlayer = new YahtzeePlayer(player);

        ArrayList<Dice> rolledDice = new ArrayList<>();
        rolledDice.add(d3);
        rolledDice.add(d6);
        rolledDice.add(d1);
        rolledDice.add(d6);
        rolledDice.add(d2);

        String diceToSaveInput = "135";

        ArrayList<Dice> expected = new ArrayList<>();
        expected.add(d3);
        expected.add(d1);
        expected.add(d2);

        // When
        ArrayList<Dice> actual = yahtzeePlayer.saveDice(rolledDice, diceToSaveInput);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void returnDiceTest(){
        // Given
        Player player = new Player("Cara", 1000.00);
        YahtzeePlayer yahtzeePlayer = new YahtzeePlayer(player);

        ArrayList<Dice> savedDice = new ArrayList<>();
        savedDice.add(d1);
        savedDice.add(d3);
        savedDice.add(d2);
        savedDice.add(d3);
        savedDice.add(d6);

        String diceToReturnInput = "324";

        ArrayList<Dice> expected = new ArrayList<>();
        expected.add(d2);
        expected.add(d3);
        expected.add(d3);

        // When
        ArrayList<Dice> actual = yahtzeePlayer.returnDice(savedDice, diceToReturnInput);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void moveDiceTest(){
        Player player = new Player("Cara", 1000.00);
        YahtzeePlayer yahtzeePlayer = new YahtzeePlayer(player);

        ArrayList<Dice> diceToMoveFrom = new ArrayList<>();
        diceToMoveFrom.add(d1);
        diceToMoveFrom.add(d2);
        diceToMoveFrom.add(d3);
        diceToMoveFrom.add(d4);
        diceToMoveFrom.add(d5);

        String diceToMoveInput = "124";

        ArrayList<Dice> expected = new ArrayList<>();
        expected.add(d1);
        expected.add(d2);
        expected.add(d4);

        // When
        ArrayList<Dice> actual = yahtzeePlayer.moveDice(diceToMoveFrom, diceToMoveInput);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void markScoreCardTest(){
        //Given
        Player player = new Player("Cara", 1000.00);
        YahtzeePlayer yahtzeePlayer = new YahtzeePlayer(player);
        TreeMap<String, Integer> scoreCard = new TreeMap<>();

        // mark Aces
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
        yahtzeePlayer.markScoreCard("Aces", rollAces, scoreCard);
        int actualAces = scoreCard.get("Aces");

        yahtzeePlayer.markScoreCard("Twos", rollTwos, scoreCard);
        int actualTwos = scoreCard.get("Twos");

        yahtzeePlayer.markScoreCard("Threes", rollThrees, scoreCard);
        int actualThrees = scoreCard.get("Threes");

        yahtzeePlayer.markScoreCard("Fours", rollFours, scoreCard);
        int actualFours = scoreCard.get("Fours");

        yahtzeePlayer.markScoreCard("Fives", rollFives, scoreCard);
        int actualFives = scoreCard.get("Fives");

        yahtzeePlayer.markScoreCard("Sixes", rollSixes, scoreCard);
        int actualSixes = scoreCard.get("Sixes");

        yahtzeePlayer.markScoreCard("3 of a kind", rollThreeOfAKind, scoreCard);
        int actualThreeOfAKind = scoreCard.get("3 of a kind");

        yahtzeePlayer.markScoreCard("4 of a kind", rollFourOfAKind, scoreCard);
        int actualFourOfAKind = scoreCard.get("4 of a kind");

        yahtzeePlayer.markScoreCard("Full House", rollFullHouse, scoreCard);
        int actualFullHouse = scoreCard.get("Full House");

        yahtzeePlayer.markScoreCard("Small straight", rollSmallStraight, scoreCard);
        int actualSmallStraight = scoreCard.get("Small straight");

        yahtzeePlayer.markScoreCard("Large straight", rollLargeStraight, scoreCard);
        int actualLargeStraight = scoreCard.get("Large straight");

        yahtzeePlayer.markScoreCard("Yahtzee", rollYahtzee, scoreCard);
        int actualYahtzee = scoreCard.get("Yahtzee");

        yahtzeePlayer.markScoreCard("Chance", rollChance, scoreCard);
        int actualChance = scoreCard.get("Chance");


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
}
