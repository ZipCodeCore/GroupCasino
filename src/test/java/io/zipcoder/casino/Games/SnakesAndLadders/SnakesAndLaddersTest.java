package io.zipcoder.casino.Games.SnakesAndLadders;

import io.zipcoder.casino.GamePieces.SnakesLaddersPiece;
import org.junit.Test;
import org.junit.Assert;

public class SnakesAndLaddersTest {

    @Test
    public void setUpGameTest1(){
        Integer expected = 0;
        SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
        SnakesLaddersPiece aiPiece = new SnakesLaddersPiece();
        playerPiece.setCurrentPosition(expected);
        aiPiece.setCurrentPosition(expected);
        Integer actual = playerPiece.getCurrentPosition();
        Integer actual2 = aiPiece.getCurrentPosition();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actual2);
    }

    @Test
    public void snakesAndLaddersCheckerViaMapTest1(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 16;
        Integer expected = 6;
        Integer actual = snakesAndLadders.snakesAndLaddersCheckerViaMap(position);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void snakesAndLaddersCheckerViaMapTest2(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 1;
        Integer expected = 38;
        Integer actual = snakesAndLadders.snakesAndLaddersCheckerViaMap(position);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void snakesAndLaddersCheckerViaMapTest3(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 34;
        Integer expected = 34;
        Integer actual = snakesAndLadders.snakesAndLaddersCheckerViaMap(position);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void showRulesTest(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        String expected = "Snakes and Ladders finds its origins in Ancient India, where it\n" +
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
        String actual = snakesAndLadders.showRules();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void snakesAndLaddersCheckTest1(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 7;
        Integer expected = 7;
        Integer actual = snakesAndLadders.snakesAndLaddersCheck(position, true);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void snakesAndLaddersCheckTest2(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 16;
        Integer expected = 6;
        Integer actual = snakesAndLadders.snakesAndLaddersCheck(position, false);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void snakesAndLaddersCheckTest3(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 4;
        Integer expected = 14;
        Integer actual = snakesAndLadders.snakesAndLaddersCheck(position, true);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void snakesAndLaddersCheckTest4(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 4;
        Integer expected = 14;
        Integer actual = snakesAndLadders.snakesAndLaddersCheck(position, false);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void snakesAndLaddersCheckTest5(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 16;
        Integer expected = 6;
        Integer actual = snakesAndLadders.snakesAndLaddersCheck(position, true);
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void diceRollTest1(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer actual = snakesAndLadders.diceRoll();
        Assert.assertTrue(actual <= 6 && actual >= 1);
    }

    @Test
    public void testIfWonTest1(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        String expected = "Player";
        String actual = snakesAndLadders.testIfWon(100, true);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testIfWonTest2(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        String expected = "no winner yet";
        String actual = snakesAndLadders.testIfWon(77, false);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testIfWonTest3(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        String expected = "no winner yet";
        String actual = snakesAndLadders.testIfWon(77, true);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testIfWonTest4(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        String expected = "Ai";
        String actual = snakesAndLadders.testIfWon(100, false);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void diceResults1(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        SnakesLaddersPiece piece = new SnakesLaddersPiece();
        Integer roll = 6;
        Integer expected = roll + piece.getCurrentPosition();
        Integer actual = snakesAndLadders.diceResults(roll,true);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void diceResults2(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        SnakesLaddersPiece piece = new SnakesLaddersPiece();
        Integer roll = 6;
        Integer expected = roll + piece.getCurrentPosition();
        Integer actual = snakesAndLadders.diceResults(roll,false);
        Assert.assertEquals(expected,actual);
    }
}
