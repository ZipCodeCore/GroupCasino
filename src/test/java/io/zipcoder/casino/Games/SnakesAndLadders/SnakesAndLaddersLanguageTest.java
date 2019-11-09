package io.zipcoder.casino.Games.SnakesAndLadders;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnakesAndLaddersLanguageTest {

    @Test
    public void getSnakeLanguageTest1() {
        SnakesAndLaddersLanguage getSnakeLanguage = new SnakesAndLaddersLanguage();
        String expected = getSnakeLanguage.getSnakeLanguage(SnakesAndLaddersLanguage.Language.PLAYERWINS);
        String actual = "Congratulations! You won!";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getSnakeLanguageTest2() {
        SnakesAndLaddersLanguage getSnakeLanguage = new SnakesAndLaddersLanguage();
        String expected = getSnakeLanguage.getSnakeLanguage(SnakesAndLaddersLanguage.Language.APPROACHTABLE);
        String actual = "You approach the Snakes and Ladders table. What would you like to do?\n" +
                "(1) - Play the game\n" +
                "(2) - Read the rules\n" +
                "(3) - Return to the game menu";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getSnakeLanguageTest3() {
        SnakesAndLaddersLanguage getSnakeLanguage = new SnakesAndLaddersLanguage();
        String expected = getSnakeLanguage.getSnakeLanguage(SnakesAndLaddersLanguage.Language.RULES);
        String actual = "Snakes and Ladders finds its origins in Ancient India, where it\n" +
                "was first created under the name Moksha Patam.\n" +
                "It was used to teach children values, rewarding proper behavior with\n" +
                "a boost in point value, via climbing a ladder, or punishing a player\n" +
                "in point value for bad behavior, via sliding down the back of a snake.\n\n" +
                "Commercially known in the West as Chutes and Ladders, the game has been published by Milton Bradley\n" +
                "since the 1940's, and players compete by rolling dice and\n" +
                "and racing to the value of 100 points, the final spot on the board.\n" +
                "But beware! Certain spots on the board will send you down the backs of the Snakes!\n" +
                "Likewise, certain spots on the board will push you closer to your goal.\n" +
                "Roll the dice and see who gets there first!\n\n";
        Assert.assertEquals(expected,actual);
    }
}