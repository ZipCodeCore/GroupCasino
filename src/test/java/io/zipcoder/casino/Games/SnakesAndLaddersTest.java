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
    public void playerTurn(){

    }
}
