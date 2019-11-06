package io.zipcoder.casino.Games;

import io.zipcoder.casino.GamePieces.SnakesLaddersPiece;
import io.zipcoder.casino.Games.SnakesAndLadders.SnakesAndLadders;
import io.zipcoder.casino.TestGames.SnakesAndLaddersTester;
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
    public void playerSnakesAndLaddersTest1(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 7;
        Integer expected = 7;
        Integer actual = snakesAndLadders.playerSnakesAndLadders(position);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void playerSnakesAndLaddersTest2(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 16;
        Integer expected = 6;
        Integer actual = snakesAndLadders.playerSnakesAndLadders(position);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void playerSnakesAndLaddersTest3(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 4;
        Integer expected = 14;
        Integer actual = snakesAndLadders.playerSnakesAndLadders(position);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void aiSnakesAndLaddersTest1(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 7;
        Integer expected = 7;
        Integer actual = snakesAndLadders.aiSnakesAndLadders(position);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void aiSnakesAndLaddersTest2(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 16;
        Integer expected = 6;
        Integer actual = snakesAndLadders.aiSnakesAndLadders(position);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void aiSnakesAndLaddersTest3(){
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        Integer position = 4;
        Integer expected = 14;
        Integer actual = snakesAndLadders.aiSnakesAndLadders(position);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void playerDiceRollTest1(){
        SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
        Integer roll = 5;
        playerPiece.setCurrentPosition(10);
        Integer expected = 15;
        playerPiece.setCurrentPosition(playerPiece.getCurrentPosition() + roll);

        Integer actual = playerPiece.getCurrentPosition();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void playerDiceRollTest2(){
        SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
        Integer roll = 2;
        playerPiece.setCurrentPosition(67);
        Integer expected = 69;
        playerPiece.setCurrentPosition(playerPiece.getCurrentPosition() + roll);

        Integer actual = playerPiece.getCurrentPosition();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void playerDiceRollTest3(){
        SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
        Integer roll = 4;
        playerPiece.setCurrentPosition(44);
        Integer expected = 48;
        playerPiece.setCurrentPosition(playerPiece.getCurrentPosition() + roll);

        Integer actual = playerPiece.getCurrentPosition();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void aiDiceRollTest1(){
        SnakesLaddersPiece aiPiece = new SnakesLaddersPiece();
        Integer roll = 3;
        aiPiece.setCurrentPosition(4);
        Integer expected = 7;
        aiPiece.setCurrentPosition(aiPiece.getCurrentPosition() + roll);

        Integer actual = aiPiece.getCurrentPosition();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void aiDiceRollTest2(){
        SnakesLaddersPiece aiPiece = new SnakesLaddersPiece();
        Integer roll = 2;
        aiPiece.setCurrentPosition(67);
        Integer expected = 69;
        aiPiece.setCurrentPosition(aiPiece.getCurrentPosition() + roll);

        Integer actual = aiPiece.getCurrentPosition();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void aiDiceRollTest3(){
        SnakesLaddersPiece aiPiece = new SnakesLaddersPiece();
        Integer roll = 6;
        aiPiece.setCurrentPosition(22);
        Integer expected = 28;
        aiPiece.setCurrentPosition(aiPiece.getCurrentPosition() + roll);

        Integer actual = aiPiece.getCurrentPosition();
        Assert.assertEquals(expected,actual);
    }

    /*@Test
    public void aiTurnTest1(){
        SnakesLaddersPiece aiPiece = new SnakesLaddersPiece();
        SnakesAndLaddersTester snakesAndLadders = new SnakesAndLaddersTester();
        aiPiece.setCurrentPosition(99);
        Integer aiPosition = 100;
        String expected = "Ai";
        String actual = snakesAndLadders.aiTurn(aiPosition);
        Assert.assertEquals(expected,actual);
    }*/

    @Test
    public void aiTurnTest2(){
        SnakesLaddersPiece aiPiece = new SnakesLaddersPiece();
        SnakesAndLaddersTester snakesAndLadders = new SnakesAndLaddersTester();
        aiPiece.setCurrentPosition(99);
        Integer aiPosition = 45;
        String expected = "no winner yet";
        String actual = snakesAndLadders.aiTurn(aiPosition);
        Assert.assertEquals(expected,actual);
    }

    /*@Test
    public void playerTurnTest1(){
        SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
        SnakesAndLaddersTester snakesAndLadders = new SnakesAndLaddersTester();
        playerPiece.setCurrentPosition(99);
        Integer aiPosition = 100;
        String expected = "Ai";
        String actual = snakesAndLadders.playerTurn(aiPosition);
        Assert.assertEquals(expected,actual);
    }*/

    @Test
    public void playerTurnTest2(){
        SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
        SnakesAndLaddersTester snakesAndLadders = new SnakesAndLaddersTester();
        playerPiece.setCurrentPosition(99);
        Integer aiPosition = 22;
        String expected = "no winner yet";
        String actual = snakesAndLadders.playerTurn(aiPosition);
        playerPiece.setCurrentPosition(100);
        Assert.assertEquals(expected,actual);
    }
}
