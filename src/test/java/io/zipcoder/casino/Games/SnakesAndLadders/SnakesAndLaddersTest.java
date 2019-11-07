package io.zipcoder.casino.Games.SnakesAndLadders;

import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.GamePieces.SnakesLaddersPiece;
import io.zipcoder.casino.Games.SnakesAndLadders.SnakesAndLadders;
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
    public void setUpTest(){
        SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
        SnakesLaddersPiece aiPiece = new SnakesLaddersPiece();
        boolean running = true;
        boolean currentGame = true;
        Integer playerActual = playerPiece.getCurrentPosition();
        Integer aiActual = aiPiece.getCurrentPosition();
        Integer playerExpected = 0;
        Integer aiExpected = 0;
        Assert.assertEquals(playerExpected,playerActual);
        Assert.assertEquals(aiExpected,aiActual);
        Assert.assertTrue(running);
        Assert.assertTrue(currentGame);
    }


    @Test
    public void snakesAndLaddersTest1(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 7;
        Integer expected = 7;
        Integer actual = snakesAndLadders.snakesAndLaddersCheck(position, true);
        Assert.assertEquals(expected,actual);
    }

    /*@Test
    public void snakesAndLaddersTest2(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        SnakesLaddersPiece aiPiece = new SnakesLaddersPiece();
        Integer position = 16;
        Integer expected = 6;
        Integer actual = snakesAndLadders.snakesAndLaddersCheck(position, false);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void snakesAndLaddersTest3(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
        Integer position = 4;
        Integer expected = 14;
        Integer actual = snakesAndLadders.snakesAndLaddersCheck(position, true);
        Assert.assertEquals(expected,actual);
    }*/


    @Test
    public void diceRollTest1(){
        SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
        Integer roll = 5;
        playerPiece.setCurrentPosition(10);
        Integer expected = 15;
        playerPiece.setCurrentPosition(playerPiece.getCurrentPosition() + roll);

        Integer actual = playerPiece.getCurrentPosition();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void diceRollTest2(){
        SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
        Integer roll = 2;
        playerPiece.setCurrentPosition(67);
        Integer expected = 69;
        playerPiece.setCurrentPosition(playerPiece.getCurrentPosition() + roll);

        Integer actual = playerPiece.getCurrentPosition();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void diceRollTest3(){
        SnakesLaddersPiece aiPiece = new SnakesLaddersPiece();
        Integer roll = 4;
        aiPiece.setCurrentPosition(44);
        Integer expected = 48;
        aiPiece.setCurrentPosition(aiPiece.getCurrentPosition() + roll);

        Integer actual = aiPiece.getCurrentPosition();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void turnTest1(){
        SnakesLaddersPiece aiPiece = new SnakesLaddersPiece();
        String actual = "";
        Dice dice = new Dice();
        aiPiece.setCurrentPosition(99);
        Integer roll = dice.rollDice(1);
        Integer actualPosition = aiPiece.getCurrentPosition() + roll;
        if (actualPosition >= 100) {
            actual = "Ai";
        }

        String expected = "Ai";

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void turnTest2(){
        SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
        String actual = "";
        Dice dice = new Dice();
        playerPiece.setCurrentPosition(99);
        Integer roll = dice.rollDice(1);
        Integer actualPosition = playerPiece.getCurrentPosition() + roll;
        if (actualPosition >= 100) {
            actual = "Player";
        }

        String expected = "Player";

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void turnTest3(){
        SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
        Dice dice = new Dice();
        String actual = "";
        Integer roll = dice.rollDice(1);
        Integer playerPosition = playerPiece.getCurrentPosition() + roll;
        String expected = "no winner yet";
        if (playerPosition >= 100) {
            actual = "Player";
        }
        if (playerPosition >= 100) {
            actual = "Ai";
        }
        actual = "no winner yet";

        playerPiece.setCurrentPosition(100);
        Assert.assertEquals(expected,actual);
    }
}
