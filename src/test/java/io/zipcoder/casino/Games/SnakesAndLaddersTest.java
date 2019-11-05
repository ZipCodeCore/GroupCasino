package io.zipcoder.casino.Games;

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


}
