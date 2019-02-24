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

}
