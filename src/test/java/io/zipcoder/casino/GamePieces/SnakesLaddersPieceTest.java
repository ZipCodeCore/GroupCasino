package io.zipcoder.casino.GamePieces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnakesLaddersPieceTest {

    @Test
    public void getCurrentPosition() {
        SnakesLaddersPiece piece = new SnakesLaddersPiece();
        Integer expected = 78;
        piece.setCurrentPosition(expected);
        Integer actual = piece.getCurrentPosition();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void setCurrentPosition() {
        SnakesLaddersPiece piece = new SnakesLaddersPiece();
        Integer expected = 78;
        piece.setCurrentPosition(expected);
        Integer actual = piece.getCurrentPosition();

        Assert.assertEquals(expected,actual);
    }
}